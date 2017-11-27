/*
 * MIT License
 *
 * Copyright (c) 2017 JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.jcalvopinam.api.web;

import com.jcalvopinam.api.measures.*;
import com.jcalvopinam.api.model.ResultadoEjecucion;
import com.jcalvopinam.api.utils.Commons;
import com.jcalvopinam.api.utils.Valor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 */

@Controller
public class ResultadoEjecucionController {

    private static final Logger logResultadoEjecucion = LoggerFactory.getLogger(ResultadoEjecucionController.class);

    @Value("${url.descarga}")
    private String urlString;

    @Value("${url.ping}")
    private String ip;

    Commons common = new Commons();

    /**
     * Mockup Obtiene el resultado de evaluar los atributos
     */
    @RequestMapping(value = "/getResultadoEjecucionMockup/{serverName}", method = RequestMethod.GET)
    @ResponseBody
    public ResultadoEjecucion getResultadoEjecucionMockup(@PathVariable String serverName) {

        logResultadoEjecucion.info("Entra en el metodo getResultadoEjecucionMockup");

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

        Disco discoMeasure = new Disco();
        discoMeasure.ejecutarRendimiento();

        Valor escrituraDiscoResult = discoMeasure.getTiempoEscrituraDisco();
        String resultadoED = "0";
        if (escrituraDiscoResult.getErrorMessage().isEmpty()) {
            resultadoED = escrituraDiscoResult.getResult();
        }

        Valor lecturaDiscoResult = discoMeasure.getTiempoLecturaDisco();
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

        return resultadoEjecucion;
    }

    /**
     * Obtiene las caracteristicas del servidor
     */
    @RequestMapping(value = "/getInfoServidor", method = RequestMethod.GET)
    @ResponseBody
    public InfoServidor getInfoServidor() {
        return new InfoServidor();
    }

}
