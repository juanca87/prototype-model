package com.jcalvopinam.api.dao;

import java.util.List;

import com.jcalvopinam.api.model.Person;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public interface IPersonDao {

    public void add(Person person);

    public void edit(Person person);

    public void delete(int id);

    public Person getPerson(int id);

    public List<Person> getAllPersons();
}
