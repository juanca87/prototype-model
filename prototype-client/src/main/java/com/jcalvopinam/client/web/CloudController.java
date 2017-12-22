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

package com.jcalvopinam.client.web;

import com.jcalvopinam.client.utils.Localizacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 */
@Controller
public class CloudController {

    private static final Logger logCloud = LoggerFactory.getLogger(CloudController.class);
    private static final String SERVIDOR_LOCAL = "LOCAL";

    @Value("${host.address}")
    private String currentHost = "";

    @RequestMapping(value = "/amazon", method = RequestMethod.GET)
    public String amazonHome(Map<String, Object> model) {
        logCloud.info("Obteniendo datos de Amazon");

        model.put("servidor", "Amazon EC2");
        model.put("serverName", "amazon");
        model.put("hostAddress", getServidor());
        model.put("mensaje", "Para iniciar el test presione clic en boton <Iniciar>");

        return "amazon";
    }

    @RequestMapping(value = "/google", method = RequestMethod.GET)
    public String googleHome(Map<String, Object> model) {
        logCloud.info("Obteniendo datos de Google");

        model.put("servidor", "Google Cloud Engine");
        model.put("serverName", "google");
        model.put("hostAddress", getServidor());
        model.put("message", "Para iniciar el test presione clic en boton <Iniciar>");

        return "google";
    }

    @RequestMapping(value = "/heroku", method = RequestMethod.GET)
    public String herkuHome(Map<String, Object> model) {
        logCloud.info("Obteniendo datos de Heroku");

        model.put("servidor", "Heroku");
        model.put("serverName", "heroku");
        model.put("hostAddress", getServidor());
        model.put("message", "Para iniciar el test presione clic en boton <Iniciar>");

        return "heroku";
    }

    @RequestMapping(value = "/comparacion", method = RequestMethod.GET)
    public ModelAndView comparacion() {
        logCloud.info("Obteniendo datos para Comparación");

        ModelAndView model = new ModelAndView();
        model.addObject("pagina", "Comparaci\u00f3n");
        model.addObject("hostAddress", getServidor());

        return model;
    }

    private String getServidor() {
        if (currentHost.equals(SERVIDOR_LOCAL))
            return Localizacion.getInfoServidorLocal();
        else
            return Localizacion.getInfoServidorRemoto();
    }

}
