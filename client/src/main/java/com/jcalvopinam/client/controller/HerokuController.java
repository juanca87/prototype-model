/**
 * 
 */
package com.jcalvopinam.client.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
@Controller
public class HerokuController {

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
}
