/**
 * 
 */
package com.jcalvopinam.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcalvopinam.client.utils.Localizacion;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
@Controller
public class CloudController {

    Logger logCloud = LoggerFactory.getLogger(CloudController.class);

    @RequestMapping(value = "/amazon", method = RequestMethod.GET)
    public ModelAndView amazonHome() {
        logCloud.info("Obteniendo datos de Amazon");

        ModelAndView model = new ModelAndView();
        model.addObject("servidor", "Amazon EC2");
        model.addObject("serverName", "amazon");
        model.addObject("hostAddress", Localizacion.getInfoServidor());
        model.addObject("mensaje", "Para iniciar el test presione clic en boton <Iniciar>");
        model.setViewName("amazon");

        return model;
    }

    @RequestMapping(value = "/google", method = RequestMethod.GET)
    public ModelAndView googleHome() {
        logCloud.info("Obteniendo datos de Google");
        
        ModelAndView model = new ModelAndView();
        model.addObject("servidor", "Google App Engine");
        model.addObject("serverName", "google");
        model.addObject("hostAddress", Localizacion.getInfoServidor());
        model.addObject("message", "Para iniciar el test presione clic en boton <Iniciar>");
        model.setViewName("google");

        return model;
    }

    @RequestMapping(value = "/heroku", method = RequestMethod.GET)
    public ModelAndView herkuHome() {
        logCloud.info("Obteniendo datos de Heroku");

        ModelAndView model = new ModelAndView();
        model.addObject("servidor", "Heroku");
        model.addObject("serverName", "heroku");
        model.addObject("hostAddress", Localizacion.getInfoServidor());
        model.addObject("message", "Para iniciar el test presione clic en boton <Iniciar>");
        model.setViewName("heroku");

        return model;
    }

}
