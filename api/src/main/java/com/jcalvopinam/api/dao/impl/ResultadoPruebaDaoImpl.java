package com.jcalvopinam.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcalvopinam.api.dao.IResultadoPruebaDao;
import com.jcalvopinam.api.model.ResultadoPrueba;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

@Repository
public class ResultadoPruebaDaoImpl implements IResultadoPruebaDao {

    @Autowired
    SessionFactory session;

    public void add(ResultadoPrueba resultado) {
        session.getCurrentSession().save(resultado);
    }

    public void update(ResultadoPrueba resultado) {
        session.getCurrentSession().update(resultado);
    }

    public void delete(int id) {
        session.getCurrentSession().delete(getResultado(id));
    }

    public ResultadoPrueba getResultado(int id) {
        return (ResultadoPrueba) session.getCurrentSession().get(ResultadoPrueba.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<ResultadoPrueba> getAllResultados() {
        return session.getCurrentSession().createQuery("from ResultadoPrueba").list();
    }

}
