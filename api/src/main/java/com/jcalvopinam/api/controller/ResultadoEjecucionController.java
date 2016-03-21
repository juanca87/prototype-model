package com.jcalvopinam.api.controller;

import static com.jcalvopinam.api.utils.Commons.getErrorMessage;
import static com.jcalvopinam.api.utils.Commons.getHpptHeader;

import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jcalvopinam.api.measures.AnchoBanda;
import com.jcalvopinam.api.measures.CPU;
import com.jcalvopinam.api.measures.InfoServidor;
import com.jcalvopinam.api.measures.Disco;
import com.jcalvopinam.api.measures.Latencia;
import com.jcalvopinam.api.measures.Memoria;
import com.jcalvopinam.api.model.ResultadoEjecucion;
import com.jcalvopinam.api.utils.Commons;
import com.jcalvopinam.api.utils.Valor;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

@Controller
public class ResultadoEjecucionController {

    private static final Logger logResultadoEjecucion = LoggerFactory.getLogger(ResultadoEjecucionController.class);

    @Value("${url.descarga}")
    private String urlString;

    @Value("${url.ping}")
    private String ip;

    Commons common = new Commons();
    ObjectMapper mapper = null;
    String json = "";

    /**
     * Mockup Obtiene el resultado de evaluar los atributos
     */
    @RequestMapping(value = "/getResultadoEjecucionMockup/{serverName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getResultadoEjecucionMockup(@PathVariable String serverName) {

        logResultadoEjecucion.info("Entra en el metodo getResultadoEjecucionMockup");

        try {
            ResultadoEjecucion resultadoEjecucion = new ResultadoEjecucion();
            resultadoEjecucion.setAnchoBanda("9.242");
            resultadoEjecucion.setCpu("12000");
            resultadoEjecucion.setEscrituraDisco("24100");
            resultadoEjecucion.setEscrituraMemoria("23115");
            resultadoEjecucion.setInstruccionesMinuto("14127");
            resultadoEjecucion.setLatencia("10123");
            resultadoEjecucion.setLecturaDisco("20345");
            resultadoEjecucion.setLecturaMemoria("38488");
            resultadoEjecucion.setFecha(new Date());
            resultadoEjecucion.setServidor(serverName);

            mapper = new ObjectMapper();
            json = mapper.writeValueAsString(resultadoEjecucion);

            return (new ResponseEntity<String>(json, getHpptHeader(), HttpStatus.OK));

        } catch (Exception e) {

            logResultadoEjecucion.error(e.getMessage());

            return (new ResponseEntity<String>(getErrorMessage("error", e.getMessage()).toJSONString(), getHpptHeader(),
                    HttpStatus.BAD_REQUEST));
        }

    }

    /**
     * Obtiene el resultado de evaluar los atributos
     */
    @RequestMapping(value = "/getResultadoEjecucion/{serverName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getResultadoEjecucion(@PathVariable String serverName) {

        logResultadoEjecucion.info("Entra en el metodo getResultadoEjecucion");

        try {

            long startTime = System.nanoTime();

            Disco escrituraDiscoMeasure = new Disco();
            Valor escrituraDiscoResult = escrituraDiscoMeasure.getTiempoEscrituraDisco();
            String resultadoED = "0";
            if (escrituraDiscoResult.getErrorMessage().isEmpty()) {
                resultadoED = escrituraDiscoResult.getResult();
            }

            Disco lecturaDiscoMeasure = new Disco();
            Valor lecturaDiscoResult = lecturaDiscoMeasure.getTiempoLecturaDisco();
            String resultadoLD = "0";
            if (lecturaDiscoResult.getErrorMessage().isEmpty()) {
                resultadoLD = lecturaDiscoResult.getResult();
            }

            CPU cpuMeasure = new CPU();
            Valor cpuResult = cpuMeasure.getCPUMeasure();
            String resultadoCPU = "0";
            if (cpuResult.getErrorMessage().isEmpty()) {
                resultadoCPU = cpuResult.getResult();
            }

            Memoria escrituraMemoriaMeasure = new Memoria();
            Valor escrituraMemoriaResult = escrituraMemoriaMeasure.getTiempoEscrituraMemoria();
            String resultadoEM = "0";
            if (escrituraMemoriaResult.getErrorMessage().isEmpty()) {
                resultadoEM = escrituraMemoriaResult.getResult();
            }

            Memoria lecturaMemoriaMeasure = new Memoria();
            Valor lecturaMemoriaResult = lecturaMemoriaMeasure.getTiempoLecturaMemoria();
            String resultadoLM = "0";
            if (lecturaMemoriaResult.getErrorMessage().isEmpty()) {
                resultadoLM = lecturaMemoriaResult.getResult();
            }

            AnchoBanda bandwithMeasure = new AnchoBanda();
            Valor bandwithResult = bandwithMeasure.getBandwith(urlString);
            String resultadoBA = "0";
            if (bandwithResult.getErrorMessage().isEmpty()) {
                resultadoBA = bandwithResult.getResult();
            }

            Latencia latencyMeasure = new Latencia();
            Valor latencyResult = latencyMeasure.getLatency(ip);
            String resultadoL = "0";
            if (latencyResult.getErrorMessage().isEmpty()) {
                resultadoL = latencyResult.getResult();
            }

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            String instruccionesMinMeasure = common.formatearResultado(totalTime);

            logResultadoEjecucion.info("Instrucciones por minuto: " + instruccionesMinMeasure);

            Valor instruccionesMinResult = new Valor(instruccionesMinMeasure, "");
            String resultadoIM = instruccionesMinResult.getResult();

            ResultadoEjecucion resultadoEjecucion = new ResultadoEjecucion();
            resultadoEjecucion.setAnchoBanda(resultadoBA);
            resultadoEjecucion.setCpu(resultadoCPU);
            resultadoEjecucion.setEscrituraDisco(resultadoED);
            resultadoEjecucion.setEscrituraMemoria(resultadoEM);
            resultadoEjecucion.setInstruccionesMinuto(resultadoIM);
            resultadoEjecucion.setLatencia(resultadoL);
            resultadoEjecucion.setLecturaDisco(resultadoLD);
            resultadoEjecucion.setLecturaMemoria(resultadoLM);
            resultadoEjecucion.setFecha(new Date());
            resultadoEjecucion.setServidor(serverName);

            mapper = new ObjectMapper();
            json = mapper.writeValueAsString(resultadoEjecucion);
            return (new ResponseEntity<String>(json, getHpptHeader(), HttpStatus.OK));

        } catch (Exception e) {

            logResultadoEjecucion.error("Error al calcular los atributos: " + e.getMessage());

            return (new ResponseEntity<String>(getErrorMessage("error", e.getMessage()).toJSONString(), getHpptHeader(),
                    HttpStatus.BAD_REQUEST));
        }
    }

    /**
     * Obtiene las caracteristicas del servidor
     */
    @RequestMapping(value = "/getInfoServidor", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getInfoServidor() {

        try {

            InfoServidor info = new InfoServidor();
            mapper = new ObjectMapper();
            json = mapper.writeValueAsString(info);
            return (new ResponseEntity<String>(json, getHpptHeader(), HttpStatus.OK));

        } catch (Exception e) {

            logResultadoEjecucion.error("Error al recuperar las caracteristicas del servidor: " + e.getMessage());

            return (new ResponseEntity<String>(getErrorMessage("error", e.getMessage()).toJSONString(), getHpptHeader(),
                    HttpStatus.BAD_REQUEST));
        }
    }

    /**
     * Manejo de excepciones
     * 
     * @param exception
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleException(Exception exception) {
        logResultadoEjecucion.error(exception.getMessage());

        return (new ResponseEntity<String>(getErrorMessage("error", exception.getMessage()).toJSONString(),
                getHpptHeader(), HttpStatus.BAD_REQUEST));
    }

    /**
     * Manejo de paginas no encontradas
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "error";
    }

}
