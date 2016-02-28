package com.jcalvopinam.client.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView home() {

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

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Modelo para Evaluar a Proveedores de Servicio en la Nube.");
        model.addObject("message", "Prototipo que permite evaluar algunos de los atributos claves.");
        model.setViewName("home");

        return model;

    }

}
