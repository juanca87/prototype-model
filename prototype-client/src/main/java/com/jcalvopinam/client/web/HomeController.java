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

import com.jcalvopinam.client.dto.UltimaFechaEjecucion;
import com.jcalvopinam.client.service.ResultadoEjecucionService;
import com.jcalvopinam.client.utils.Localizacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */
@Controller
public class HomeController {

    private static final Logger logHome = LoggerFactory.getLogger(HomeController.class);
    private static final String SERVIDOR_LOCAL = "LOCAL";

    @Value("${host.address}")
    private String currentHost = "";

    @Autowired
    private ResultadoEjecucionService resultadoEjecucionService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home(Map<String, Object> model) {

        logHome.info("Obteniendo datos de index");

        Locale locale = new Locale("es");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.put("title", "Spring security - Hello World!");
        model.put("message", "Welcome, the server Time is:" + formattedDate);

        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String adminPage(Map<String, Object> model) {

        logHome.info("Obteniendo datos de home");

        model.put("title", "Modelo para Evaluar a Proveedores de Servicio en la Nube.");
        model.put("message", "Prototipo que permite evaluar algunos de los atributos claves.");
        model.put("hostAddress", getServidor());

        return "home";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/amazon", method = RequestMethod.GET)
    public String amazon() {
        return "amazon";
    }

    @RequestMapping(value = "/google", method = RequestMethod.GET)
    public String google() {
        return "google";
    }

    @RequestMapping(value = "/heroku", method = RequestMethod.GET)
    public String heroku() {
        return "heroku";
    }

    @RequestMapping(value = "/comparacion", method = RequestMethod.GET)
    public String comparacion(){
        return "comparacion";
    }

    @RequestMapping(value = "/protected", method = RequestMethod.GET)
    public String securityProtected() {
        return "protected";
    }

    @RequestMapping(value = "/unprotected", method = RequestMethod.GET)
    public String securityUnProtected(){
        return "unprotected";
    }

    @RequestMapping(value = "/ultimaFechaEjecucion", method = RequestMethod.GET)
    public UltimaFechaEjecucion ultimaFechaEjecucion() {
        return resultadoEjecucionService.getFechaUltimaEjecucion();
    }

    private String getServidor() {
        if (currentHost.equals(SERVIDOR_LOCAL))
            return Localizacion.getInfoServidorLocal();
        else
            return Localizacion.getInfoServidorRemoto();
    }
}
