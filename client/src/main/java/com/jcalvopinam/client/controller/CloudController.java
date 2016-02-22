/**
 * 
 */
package com.jcalvopinam.client.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcalvopinam.client.model.ResultadoEjecucion;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
@Controller
public class CloudController {

    @RequestMapping(value = "/amazon", method = RequestMethod.GET)
    public ModelAndView amazonHome() {
        ModelAndView model = new ModelAndView();
        model.addObject("servidor", "Amazon EC2");
        model.addObject("mensaje", "Para iniciar el test presione clic en boton <Iniciar>");
        model.setViewName("amazon");

        return model;
    }
    
    @RequestMapping(value = "/google", method = RequestMethod.GET)
    public ModelAndView googleHome() {
        Locale locale = new Locale("es");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring security - Hello World!");
        model.addObject("message", "Welcome, the server Time is:" + formattedDate);
        model.setViewName("google");

        return model;
    }
    
    @RequestMapping(value = "/heroku", method = RequestMethod.GET)
    public ModelAndView herkuHome() {
        Locale locale = new Locale("es");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring security - Hello World!");
        model.addObject("message", "Welcome, the server Time is:" + formattedDate);
        model.setViewName("heroku");

        return model;
    }
    
    public ModelAndView loadAmazonValues(@RequestBody ResultadoEjecucion jsonString){
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Loading values...");
        model.addObject("cpuResult", jsonString.getCpu());
        model.addObject("escrituraDiscoResult", jsonString.getEscrituraDisco());
        model.addObject("lecturaDiscoResult", jsonString.getLecturaDisco());
        model.addObject("escrituraMemoriaResult", jsonString.getEscrituraMemoria());
        model.addObject("lecturaMemoriaResult", jsonString.getLecturaMemoria());
        model.addObject("bandwithResult", jsonString.getAnchoBanda());
        model.addObject("latencyResult", jsonString.getLatencia());
        model.addObject("instruccionesMinResult", jsonString.getInstruccionesMinuto());
        return model;
    }
}
