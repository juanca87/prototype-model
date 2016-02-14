package com.jcalvopinam.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jcalvopinam.api.measures.Bandwidth;
import com.jcalvopinam.api.measures.CPU;
import com.jcalvopinam.api.measures.Disco;
import com.jcalvopinam.api.measures.Latency;
import com.jcalvopinam.api.measures.Memoria;
import com.jcalvopinam.api.model.ResultadoEjecucion;
import com.jcalvopinam.api.model.Valor;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

@Controller
public class ResultadoEjecucionController {

    // @Autowired
    // private IResultadoEjecucionService resultadoEjecucion;

    @RequestMapping(value = "saveResultadoEjecucion", method = { RequestMethod.GET, RequestMethod.POST })
    public String doAction(ResultadoEjecucion resultadoPrueba, ModelMap model) {
        model.addAttribute("cpu", resultadoPrueba.getCpu());
        System.out.println(resultadoPrueba.getCpu());
        return "resultadoPrueba";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView loadValues() {
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

        Bandwidth bandwithMeasure = new Bandwidth();
        Valor bandwithResult = bandwithMeasure.getBandwith();

        Latency latencyMeasure = new Latency();
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

    @RequestMapping(value = "/dashboardMockup", method = RequestMethod.GET)
    @ResponseBody
    public ResultadoEjecucion loadValuesMockup() {

        ResultadoEjecucion resultadoEjecucion = new ResultadoEjecucion();
        resultadoEjecucion.setAnchoBanda("123");
        resultadoEjecucion.setCpu("231");
        resultadoEjecucion.setEscrituraDisco("345");
        resultadoEjecucion.setEscrituraMemoria("325");
        resultadoEjecucion.setInstruccionesMinuto("623");
        resultadoEjecucion.setLatencia("923");
        resultadoEjecucion.setLecturaDisco("234");
        resultadoEjecucion.setLecturaMemoria("521");

        return resultadoEjecucion;
    }

    @RequestMapping(value = "/getResultadoEjecucion", method = RequestMethod.GET)
    @ResponseBody
    public ResultadoEjecucion getResultadoEjecucion() {
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

        Bandwidth bandwithMeasure = new Bandwidth();
        Valor bandwithResult = bandwithMeasure.getBandwith();

        Latency latencyMeasure = new Latency();
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

        return resultadoEjecucion;
    }
}
