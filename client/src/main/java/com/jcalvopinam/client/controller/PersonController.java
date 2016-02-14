package com.jcalvopinam.client.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcalvopinam.client.model.Person;
import com.jcalvopinam.client.service.IPersonService;

@Controller
public class PersonController {

    @Autowired
    private IPersonService personService;

    @RequestMapping("/personIndex")
    public String setupForm(Map<String, Object> map) {
        Person person = new Person();
        map.put("person", person);
        map.put("personList", personService.getAllPersons());
        return "person";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Person person, BindingResult result, @RequestParam String action,
            Map<String, Object> map) {
        Person personResult = new Person();
        int val = 0;
        System.out.println("ACTION VALUE: " + action);
        if (action.toLowerCase().equals("add"))
            val = 1;
        if (action.toLowerCase().equals("edit"))
            val = 2;
        if (action.toLowerCase().equals("delete"))
            val = 3;
        if (action.toLowerCase().equals("search"))
            val = 4;

        switch (val) {
        case 1:
            personService.add(person);
            personResult = person;
            System.out.println("entra en 1\n" + person.getName() + " " + result.toString());
            break;
        case 2:
            personService.edit(person);
            personResult = person;
            System.out.println("entra en 2");
            break;
        case 3:
            personService.delete(person.getId());
            personResult = new Person();
            System.out.println("entra en 3");
            break;
        case 4:
            Person searchedPerson = personService.getPerson(person.getId());
            personResult = searchedPerson != null ? searchedPerson : new Person();
            System.out.println("entra en 4");
            break;
        default:
            System.out.println("NO HACE NADA");
            break;
        }
        map.put("person", personResult);
        map.put("personList", personService.getAllPersons());
        return "person";
    }
}
