package com.jcalvopinam.client.service;

import java.util.List;

import com.jcalvopinam.client.model.Person;

public interface IPersonService {

    public void add(Person person);

    public void edit(Person person);

    public void delete(int id);

    public Person getPerson(int id);

    public List<Person> getAllPersons();

}
