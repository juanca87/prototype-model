package com.jcalvopinam.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcalvopinam.api.dao.IResultadoEjecucionDao;
import com.jcalvopinam.api.model.ResultadoEjecucion;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

@Repository
public class ResultadoEjecucionDaoImp implements IResultadoEjecucionDao{

    @Autowired
    private SessionFactory session;
    
    public void add(ResultadoEjecucion resultado) {
        session.getCurrentSession().save(resultado);
    }

    public void update(ResultadoEjecucion resultado) {
        session.getCurrentSession().update(resultado);
    }

    public void delete(int id) {
        session.getCurrentSession().delete(getResultadoEjecucion(id));
    }

    public ResultadoEjecucion getResultadoEjecucion(int id) {
        return (ResultadoEjecucion) session.getCurrentSession().get(ResultadoEjecucion.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<ResultadoEjecucion> getAllResultadosEjecucion() {
        return session.getCurrentSession().createQuery("from ResultadoEjecucion").list();
    }

}
