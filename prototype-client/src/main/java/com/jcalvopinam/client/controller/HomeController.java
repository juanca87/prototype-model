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

package com.jcalvopinam.client.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcalvopinam.client.dto.UltimaFechaEjecucion;
import com.jcalvopinam.client.service.IResultadoEjecucionService;
import com.jcalvopinam.client.utils.Localizacion;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */
@Controller
public class HomeController {

    private static final Logger logHome = LoggerFactory.getLogger(HomeController.class);
    private static final String SERVIDOR_LOCAL = "LOCAL";

    String json = null;
    ObjectMapper mapper = null;

    @Value("${host.address}")
    private String currentHost = "";

    @Autowired
    private IResultadoEjecucionService resultadoEjecucion;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView home() {

        logHome.info("Obteniendo detos de index");

        Locale locale = new Locale("es");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring security - Hello World!");
        model.addObject("message", "Welcome, the server Time is:" + formattedDate);
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        logHome.info("Obteniendo datos de home");

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Modelo para Evaluar a Proveedores de Servicio en la Nube.");
        model.addObject("message", "Prototipo que permite evaluar algunos de los atributos claves.");
        model.addObject("hostAddress", getServidor());
        model.setViewName("home");

        try {
            UltimaFechaEjecucion ultima = resultadoEjecucion.getUltimaFechaEjecucion();
            model.addObject("fechaAmazon", ultima.getFechaAmazon());
            model.addObject("fechaGoogle", ultima.getFechaGoogle());
            model.addObject("fechaHeroku", ultima.getFechaHeroku());

            return model;

        } catch (Exception e) {
            logHome.error("Se produjo un error al obtener el historial de ejecuciones: " + e.getMessage());

            return new ModelAndView();
        }

    }

    private String getServidor() {
        if (currentHost.equals(SERVIDOR_LOCAL))
            return Localizacion.getInfoServidorLocal();
        else
            return Localizacion.getInfoServidorRemoto();
    }
}
