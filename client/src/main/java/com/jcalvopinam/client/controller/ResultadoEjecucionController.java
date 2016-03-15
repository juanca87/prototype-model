package com.jcalvopinam.client.controller;

import static com.jcalvopinam.client.utils.Commons.getErrorMessage;
import static com.jcalvopinam.client.utils.Commons.getHpptHeader;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
@Controller
public class ResultadoEjecucionController {

    private static final Logger log = LoggerFactory.getLogger(ResultadoEjecucionController.class);

    String json = null;
    ObjectMapper mapper = null;

    @Autowired
    private IResultadoEjecucionService resultadoEjecucion;

    /**
     * Guarda el resultado de la ejecucion
     */
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
     */
    @RequestMapping(value = "/getHistorialEjecuciones/{serverName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getHistorialEjecuciones(@PathVariable String serverName) {

        try {

            json = "";
            mapper = new ObjectMapper();

            if (StringUtils.isEmpty(serverName)) {
                json = mapper.writeValueAsString(resultadoEjecucion.getAllResultadosEjecucion());
                return (new ResponseEntity<String>(json, getHpptHeader(), HttpStatus.OK));
            } else {
                json = mapper.writeValueAsString(resultadoEjecucion.getAllResultadosEjecucion(serverName));
                return (new ResponseEntity<String>(json, getHpptHeader(), HttpStatus.OK));
            }

        } catch (Exception e) {

            log.error("Se produjo un error al obtener el historial de ejecuciones: " + e.getMessage());

            return (new ResponseEntity<String>(getErrorMessage("error", e.getMessage()).toJSONString(), getHpptHeader(),
                    HttpStatus.BAD_REQUEST));
        }

    }

    /**
     * Devuelve un json con los resultados de la ultima ejecucion de los 3 proveedores
     */
    @RequestMapping(value = "/getComparacion")
    @ResponseBody
    public ResponseEntity<String> getComparacion() {

        try {
            json = "";
            mapper = new ObjectMapper();
            // mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
            json = mapper.writeValueAsString(resultadoEjecucion.getComparacion());

            return (new ResponseEntity<String>(json, getHpptHeader(), HttpStatus.OK));
        } catch (Exception e) {
            log.error("Se produjo un error al obtener los resultados de la comparación: " + e.getMessage());

            return (new ResponseEntity<String>(getErrorMessage("error", e.getMessage()).toJSONString(), getHpptHeader(),
                    HttpStatus.BAD_REQUEST));
        }

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleException(Exception exception) {
        log.error("Faltan parametros en la solicitud enviada: " + exception.getMessage());

        return (new ResponseEntity<String>(getErrorMessage("error", exception.getMessage()).toJSONString(),
                getHpptHeader(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "error";
    }

}
