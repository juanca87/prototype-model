package com.jcalvopinam.api.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

@Controller
public class HomeController {

    @RequestMapping(value = { "/", "/index", "/home" }, method = RequestMethod.GET)
    public ModelAndView home() {

        Locale locale = new Locale("es");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Prototype Model Api");
        model.addObject("message", "Welcome to the API's list the server Time is:" + formattedDate);
        model.addObject("datetime", "The server Time is:" + formattedDate);
        model.setViewName("home");

        return model;
    }
}
