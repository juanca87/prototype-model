package com.jcalvopinam.client.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jcalvopinam.client.model.Person;
import com.jcalvopinam.client.model.ResultadoEjecucion;

@Controller
public class HomeController {

    private ResultadoEjecucion currentValue;

    public ResultadoEjecucion getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(ResultadoEjecucion currentValue) {
        this.currentValue = currentValue;
    }

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
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("home");

        return model;

    }

    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/getResults", method = RequestMethod.GET)
    @ResponseBody
    public ResultadoEjecucion getResults() {
        return this.getCurrentValue();
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
