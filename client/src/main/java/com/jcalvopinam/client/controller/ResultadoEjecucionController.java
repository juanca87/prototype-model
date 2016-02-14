package com.jcalvopinam.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcalvopinam.client.model.ResultadoEjecucion;

@Controller
public class ResultadoEjecucionController {

    // @Autowired
    // private IResultadoEjecucionService resultadoEjecucion;

//    @RequestMapping(value = "saveResultadoEjecucion", consumes="application/json", method = RequestMethod.POST)
//    public @ResponseBody ResultadoEjecucion save(@RequestBody ResultadoEjecucion jsonString) {
//
//        System.out.println(" Get cpu value " + jsonString.getCpu());
//        return jsonString;
//    }

    @RequestMapping(value = "saveResultadoEjecucion", consumes="application/json", method = RequestMethod.POST)
    public String save(@RequestBody ResultadoEjecucion jsonString, ModelMap model) {

        model.addAttribute("title", "Loading values...");
        model.addAttribute("cpuResult", jsonString.getCpu());
        model.addAttribute("escrituraDiscoResult", jsonString.getEscrituraDisco());
        model.addAttribute("lecturaDiscoResult", jsonString.getLecturaDisco());
        model.addAttribute("escrituraMemoriaResult", jsonString.getEscrituraMemoria());
        model.addAttribute("lecturaMemoriaResult", jsonString.getLecturaMemoria());
        model.addAttribute("bandwithResult", jsonString.getAnchoBanda());
        model.addAttribute("latencyResult", jsonString.getLatencia());
        model.addAttribute("instruccionesMinResult", jsonString.getInstruccionesMinuto());

        return "dashboard";
    }

}
