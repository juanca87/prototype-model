package com.jcalvopinam.api.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jcalvopinam.api.measures.AnchoBanda;
import com.jcalvopinam.api.measures.CPU;
import com.jcalvopinam.api.measures.Disco;
import com.jcalvopinam.api.measures.Latencia;
import com.jcalvopinam.api.measures.Memoria;
import com.jcalvopinam.api.model.ResultadoEjecucion;
import com.jcalvopinam.api.utils.Localizacion;
import com.jcalvopinam.api.utils.Valor;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

@Controller
public class ResultadoEjecucionController {

    Logger logResultadoEjecucion = LoggerFactory.getLogger(ResultadoEjecucionController.class);

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView loadDashboardValues() {

        logResultadoEjecucion.info("Entra en el metodo loadDashboardValues");

        long startTime = System.nanoTime();

        Disco escrituraDiscoMeasure = new Disco();
        Valor escrituraDiscoResult = escrituraDiscoMeasure.getTiempoEscrituraDisco();

        Disco lecturaDiscoMeasure = new Disco();
        Valor lecturaDiscoResult = lecturaDiscoMeasure.getTiempoLecturaDisco();

        CPU cpuMeasure = new CPU();
        Valor cpuResult = cpuMeasure.getCPUMeasure();

        Memoria escrituraMemoriaMeasure = new Memoria();
        Valor escrituraMemoriaResult = escrituraMemoriaMeasure.getTiempoEscrituraMemoria();

        Memoria lecturaMemoriaMeasure = new Memoria();
        Valor lecturaMemoriaResult = lecturaMemoriaMeasure.getTiempoLecturaMemoria();

        AnchoBanda bandwithMeasure = new AnchoBanda();
        Valor bandwithResult = bandwithMeasure.getBandwith();

        Latencia latencyMeasure = new Latencia();
        Valor latencyResult = latencyMeasure.getLatency();

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        String instruccionesMinMeasure = String.valueOf(totalTime);

        if (instruccionesMinMeasure.length() > 5)
            instruccionesMinMeasure = instruccionesMinMeasure.substring(0, 5);

        System.out.println("Instrucciones por minuto: " + instruccionesMinMeasure);

        Valor instruccionesMinResult = new Valor(instruccionesMinMeasure, "");

        ResultadoEjecucion resultadoEjecucion = new ResultadoEjecucion();
        resultadoEjecucion.setAnchoBanda(bandwithResult.getResult());
        resultadoEjecucion.setCpu(cpuResult.getResult());
        resultadoEjecucion.setEscrituraDisco(escrituraDiscoResult.getResult());
        resultadoEjecucion.setEscrituraMemoria(escrituraMemoriaResult.getResult());
        resultadoEjecucion.setInstruccionesMinuto(instruccionesMinResult.getResult());
        resultadoEjecucion.setLatencia(latencyResult.getResult());
        resultadoEjecucion.setLecturaDisco(lecturaDiscoResult.getResult());
        resultadoEjecucion.setLecturaMemoria(lecturaMemoriaResult.getResult());
        resultadoEjecucion.setFecha(new Date());
        resultadoEjecucion.setServidor(Localizacion.getInfoServidor());

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Loading values...");
        model.addObject("cpuResult", resultadoEjecucion.getCpu());
        model.addObject("escrituraDiscoResult", resultadoEjecucion.getEscrituraDisco());
        model.addObject("lecturaDiscoResult", resultadoEjecucion.getLecturaDisco());
        model.addObject("escrituraMemoriaResult", resultadoEjecucion.getEscrituraMemoria());
        model.addObject("lecturaMemoriaResult", resultadoEjecucion.getLecturaMemoria());
        model.addObject("bandwithResult", resultadoEjecucion.getAnchoBanda());
        model.addObject("latencyResult", resultadoEjecucion.getLatencia());
        model.addObject("instruccionesMinResult", resultadoEjecucion.getInstruccionesMinuto());

        return model;

    }

    /**
     * Mockup Obtiene el resultado de evaluar los atributos
     */
    @RequestMapping(value = "/getResultadoEjecucionMockup/{serverName}", method = RequestMethod.GET)
    @ResponseBody
    public ResultadoEjecucion getResultadoEjecucionMockup(@PathVariable String serverName) {

        logResultadoEjecucion.info("Entra en el metodo getResultadoEjecucionMockup");

        ResultadoEjecucion resultadoEjecucion = new ResultadoEjecucion();
        resultadoEjecucion.setAnchoBanda("123");
        resultadoEjecucion.setCpu("231");
        resultadoEjecucion.setEscrituraDisco("345");
        resultadoEjecucion.setEscrituraMemoria("325");
        resultadoEjecucion.setInstruccionesMinuto("623");
        resultadoEjecucion.setLatencia("923");
        resultadoEjecucion.setLecturaDisco("234");
        resultadoEjecucion.setLecturaMemoria("521");
        resultadoEjecucion.setFecha(new Date());
        resultadoEjecucion.setServidor(serverName);

        return resultadoEjecucion;
    }

    /**
     * Obtiene el resultado de evaluar los atributos
     */
    @RequestMapping(value = "/getResultadoEjecucion/{serverName}", method = RequestMethod.GET)
    @ResponseBody
    public ResultadoEjecucion getResultadoEjecucion(@PathVariable String serverName) {

        logResultadoEjecucion.info("Entra en el metodo getResultadoEjecucion");

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
        Valor bandwithResult = bandwithMeasure.getBandwith();
        String resultadoBA = "0";
        if (bandwithResult.getErrorMessage().isEmpty()) {
            resultadoBA = bandwithResult.getResult();
        }

        Latencia latencyMeasure = new Latencia();
        Valor latencyResult = latencyMeasure.getLatency();
        String resultadoL = "0";
        if (latencyResult.getErrorMessage().isEmpty()) {
            resultadoL = latencyResult.getResult();
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        String instruccionesMinMeasure = String.valueOf(totalTime);

        if (instruccionesMinMeasure.length() > 5)
            instruccionesMinMeasure = instruccionesMinMeasure.substring(0, 5);

        System.out.println("Instrucciones por minuto: " + instruccionesMinMeasure);

        Valor instruccionesMinResult = new Valor(instruccionesMinMeasure, "");

        ResultadoEjecucion resultadoEjecucion = new ResultadoEjecucion();
        resultadoEjecucion.setAnchoBanda(resultadoBA);
        resultadoEjecucion.setCpu(resultadoCPU);
        resultadoEjecucion.setEscrituraDisco(resultadoED);
        resultadoEjecucion.setEscrituraMemoria(resultadoEM);
        resultadoEjecucion.setInstruccionesMinuto(instruccionesMinResult.getResult());
        resultadoEjecucion.setLatencia(resultadoL);
        resultadoEjecucion.setLecturaDisco(resultadoLD);
        resultadoEjecucion.setLecturaMemoria(resultadoLM);
        resultadoEjecucion.setFecha(new Date());
        resultadoEjecucion.setServidor(serverName);

        return resultadoEjecucion;
    }
}
