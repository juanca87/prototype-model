package com.jcalvopinam.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcalvopinam.api.dao.ITipoParametroDao;
import com.jcalvopinam.api.model.TipoParametro;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

@Repository
public class TipoParametroDaoImpl implements ITipoParametroDao {

    @Autowired
    SessionFactory session;

    public void add(TipoParametro tipo) {
        session.getCurrentSession().save(tipo);
    }

    public void update(TipoParametro tipo) {
        session.getCurrentSession().update(tipo);
    }

    public void delete(int id) {
        session.getCurrentSession().delete(getTipoParametro(id));
    }

    public TipoParametro getTipoParametro(int id) {
        return (TipoParametro) session.getCurrentSession().get(TipoParametro.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<TipoParametro> getAllTipoParametros() {
        return session.getCurrentSession().createQuery("from TipoParametro").list();
    }

}
