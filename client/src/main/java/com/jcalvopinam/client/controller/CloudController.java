package com.jcalvopinam.client.controller;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcalvopinam.client.dto.InfoServidor;
import com.jcalvopinam.client.utils.Commons;
import com.jcalvopinam.client.utils.Localizacion;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
@Controller
public class CloudController {

    private static final Logger logCloud = LoggerFactory.getLogger(CloudController.class);
    private static final String SERVIDOR_LOCAL = "LOCAL";

    @Value("${host.address}")
    private String currentHost = "";

    @RequestMapping(value = "/amazon", method = RequestMethod.GET)
    public ModelAndView amazonHome() {
        logCloud.info("Obteniendo datos de Amazon");

        ModelAndView model = new ModelAndView();
        model.addObject("servidor", "Amazon EC2");
        model.addObject("serverName", "amazon");
        model.addObject("hostAddress", getServidor());
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
        model.addObject("hostAddress", getServidor());
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
        model.addObject("hostAddress", getServidor());
        model.addObject("message", "Para iniciar el test presione clic en boton <Iniciar>");
        model.setViewName("heroku");

        return model;
    }

    @RequestMapping(value = "/comparacion", method = RequestMethod.GET)
    public ModelAndView comparacion() {
        ModelAndView model = new ModelAndView();
        model.addObject("pagina", "Comparaci\u00f3n");
        model.addObject("hostAddress", getServidor());

        return model;
    }

    @RequestMapping(value = "getInfoServidor/{url}", method = RequestMethod.GET)
    public ModelAndView getInfoServidor(@PathVariable String url) {
        try {
            InfoServidor info = this.getInfoServidorJson(url);
            ModelAndView model = new ModelAndView();
            model.addObject("arquitectura", info.getArquitectura());
            // TODO completar
            return model;
        } catch (Exception e) {
            logCloud.error("Se produjo un error al recuperar la informaci\u00f3n del servidor: " + e.getMessage());
            return new ModelAndView();
        }

    }

    private String getServidor() {
        if (currentHost.equals(SERVIDOR_LOCAL))
            return Localizacion.getInfoServidorLocal();
        else
            return Localizacion.getInfoServidorRemoto();
    }

    private InfoServidor getInfoServidorJson(String url) throws IOException {
        Commons common = new Commons();
        String json = common.leerUrl(url);
        ObjectMapper mapper = new ObjectMapper();
        InfoServidor info = mapper.readValue(json, InfoServidor.class);
        return info;
    }

}
