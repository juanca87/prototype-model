package com.jcalvopinam.client.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jcalvopinam.client.model.ResultadoEjecucion;
import com.jcalvopinam.client.service.IResultadoEjecucionService;

@Controller
public class ResultadoEjecucionController {
    
    Logger log = LoggerFactory.getLogger(ResultadoEjecucionController.class);

    @Autowired
    private IResultadoEjecucionService resultadoEjecucion;

    /**
     * Guarda el resultado de la ejecucion
     * */
    @RequestMapping(value = "/saveResultadoEjecucion", consumes = "application/json", method = RequestMethod.POST)
    public String save(@RequestBody ResultadoEjecucion resultadoJson, ModelMap model) {

        model.addAttribute("title", "Loading values...");
        model.addAttribute("cpuResult", resultadoJson.getCpu());
        model.addAttribute("escrituraDiscoResult", resultadoJson.getEscrituraDisco());
        model.addAttribute("lecturaDiscoResult", resultadoJson.getLecturaDisco());
        model.addAttribute("escrituraMemoriaResult", resultadoJson.getEscrituraMemoria());
        model.addAttribute("lecturaMemoriaResult", resultadoJson.getLecturaMemoria());
        model.addAttribute("bandwithResult", resultadoJson.getAnchoBanda());
        model.addAttribute("latencyResult", resultadoJson.getLatencia());
        model.addAttribute("instruccionesMinResult", resultadoJson.getInstruccionesMinuto());

        resultadoEjecucion.add(resultadoJson);

        return "dashboard";
    }

    /**
     * Devuelve un json con el historial de ejecuciones filtrado por servidor
     * */
//    @RequestMapping(value = "/getHistorialEjecuciones/{serverName}", method = RequestMethod.GET)
//    @ResponseBody
//    public List<ResultadoEjecucion> getHistorialEjecuciones(@PathVariable String serverName) {
//        if (StringUtils.isEmpty(serverName)){
//            return resultadoEjecucion.getAllResultadosEjecucion();
//        }else{
//            return resultadoEjecucion.getAllResultadosEjecucion(serverName);
//        }
//    }
    
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getHistorialEjecuciones/{serverName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getHistorialEjecuciones(@PathVariable String serverName) {
        String data = "";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin","*");
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            if (StringUtils.isEmpty(serverName)){
                data = mapper.writeValueAsString(resultadoEjecucion.getAllResultadosEjecucion());
                return (new ResponseEntity<String>(data, headers, HttpStatus.OK));
            }else{
                data = mapper.writeValueAsString(resultadoEjecucion.getAllResultadosEjecucion(serverName));
                return (new ResponseEntity<String>(data, headers, HttpStatus.OK));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            JSONObject errorMessage = new JSONObject();
            errorMessage.put("type", "error");
            errorMessage.put("message", e.getMessage());
            return (new ResponseEntity<String>(errorMessage.toJSONString(), headers, HttpStatus.BAD_REQUEST));
        }
    }

    @SuppressWarnings("unchecked")
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleException(Exception exception){
        JSONObject errorMessage = new JSONObject();
        errorMessage.put("type", "error");
        errorMessage.put("message", exception.getMessage());
        return (new ResponseEntity<String>(errorMessage.toJSONString(), new HttpHeaders(), HttpStatus.BAD_REQUEST));
    }
    
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "error";
    }
}
