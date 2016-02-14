package com.jcalvopinam.client.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcalvopinam.client.dao.ITipoParametroDao;
import com.jcalvopinam.client.model.TipoParametro;

@Repository
public class TipoParametroDaoImpl implements ITipoParametroDao {

    @Autowired
    SessionFactory session;

    @Override
    public void add(TipoParametro tipo) {
        session.getCurrentSession().save(tipo);
    }

    @Override
    public void update(TipoParametro tipo) {
        session.getCurrentSession().update(tipo);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getTipoParametro(id));
    }

    @Override
    public TipoParametro getTipoParametro(int id) {
        return (TipoParametro) session.getCurrentSession().get(TipoParametro.class, id);
    }

    @Override
    public List<TipoParametro> getAllTipoParametros() {
        return session.getCurrentSession().createQuery("from TipoParametro").list();
    }

}
