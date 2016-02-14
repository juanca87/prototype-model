package com.jcalvopinam.api.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jcalvopinam.api.model.Person;

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getListName() {
        Random r = new Random();
        Person per1 = new Person(r.nextInt(), "AAAAAA", "BBBBBBBB", 25, "aaaaaa.bbbbbbbb@gmail.com");
        Person per2 = new Person(r.nextInt(), "DDD", "CCCCCCCCC BBBBBBBB", 0, "-");
        Person per3 = new Person(r.nextInt(), "JJJJ", "CCCCCCCCC", 29, "juan.calvopina@gmail.com");

        List<Person> listNames = new ArrayList<Person>();
        listNames.add(per1);
        listNames.add(per2);
        listNames.add(per3);

        return listNames;
    }
}
