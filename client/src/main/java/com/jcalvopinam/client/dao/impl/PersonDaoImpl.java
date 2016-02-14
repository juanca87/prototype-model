package com.jcalvopinam.client.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcalvopinam.client.dao.IPersonDao;
import com.jcalvopinam.client.model.Person;

@Repository
public class PersonDaoImpl implements IPersonDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Person person) {
        session.getCurrentSession().save(person);
    }

    @Override
    public void edit(Person person) {
        session.getCurrentSession().update(person);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getPerson(id));
    }

    @Override
    public Person getPerson(int id) {
        return (Person) session.getCurrentSession().get(Person.class, id);
    }

    @Override
    public List<Person> getAllPersons() {
        return session.getCurrentSession().createQuery("from Person").list();
    }

}
