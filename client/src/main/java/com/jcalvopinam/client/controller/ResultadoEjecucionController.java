package com.jcalvopinam.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcalvopinam.client.model.ResultadoEjecucion;
import com.jcalvopinam.client.service.IResultadoEjecucionService;

@Controller
public class ResultadoEjecucionController {

    @Autowired
    private IResultadoEjecucionService resultadoEjecucion;

    @RequestMapping(value = "saveResultadoEjecucion", consumes = "application/json", method = RequestMethod.POST)
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
     * Devuelve un json con el historial de ejecuciones
     * */
    @RequestMapping(value = "/getHistorialEjecuciones", method = RequestMethod.GET)
    @ResponseBody
    public List<ResultadoEjecucion> getHistorialEjecuciones() {
        return resultadoEjecucion.getAllResultadosEjecucion();
    }

}
