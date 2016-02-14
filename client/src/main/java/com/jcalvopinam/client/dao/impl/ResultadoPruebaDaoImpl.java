package com.jcalvopinam.client.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcalvopinam.client.dao.IResultadoPruebaDao;
import com.jcalvopinam.client.model.ResultadoPrueba;

@Repository
public class ResultadoPruebaDaoImpl implements IResultadoPruebaDao {

    @Autowired
    SessionFactory session;

    @Override
    public void add(ResultadoPrueba resultado) {
        session.getCurrentSession().save(resultado);
    }

    @Override
    public void update(ResultadoPrueba resultado) {
        session.getCurrentSession().update(resultado);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getResultado(id));
    }

    @Override
    public ResultadoPrueba getResultado(int id) {
        return (ResultadoPrueba) session.getCurrentSession().get(ResultadoPrueba.class, id);
    }

    @Override
    public List<ResultadoPrueba> getAllResultados() {
        return session.getCurrentSession().createQuery("from ResultadoPrueba").list();
    }

}
