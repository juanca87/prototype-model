package com.jcalvopinam.client.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcalvopinam.client.dao.IResultadoEjecucionDao;
import com.jcalvopinam.client.model.ResultadoEjecucion;

@Repository
public class ResultadoEjecucionDaoImp implements IResultadoEjecucionDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(ResultadoEjecucion resultado) {
        session.getCurrentSession().save(resultado);
    }

    @Override
    public void update(ResultadoEjecucion resultado) {
        session.getCurrentSession().update(resultado);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getResultadoEjecucion(id));
    }

    @Override
    public ResultadoEjecucion getResultadoEjecucion(int id) {
        return (ResultadoEjecucion) session.getCurrentSession().get(ResultadoEjecucion.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ResultadoEjecucion> getAllResultadosEjecucion() {
        return session.getCurrentSession().createQuery("from ResultadoEjecucion").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ResultadoEjecucion> getAllResultadosEjecucion(String serverName) {
        return session.getCurrentSession()
                .createQuery("from ResultadoEjecucion where servidor = :serverName order by fecha desc")
                .setParameter("serverName", serverName)
                .setMaxResults(50)
                .list();
    }

}
