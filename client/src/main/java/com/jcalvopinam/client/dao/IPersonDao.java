package com.jcalvopinam.client.dao;

import java.util.List;

import com.jcalvopinam.client.model.Person;

public interface IPersonDao {
    public void add(Person person);

    public void edit(Person person);

    public void delete(int id);

    public Person getPerson(int id);

    public List<Person> getAllPersons();
}
