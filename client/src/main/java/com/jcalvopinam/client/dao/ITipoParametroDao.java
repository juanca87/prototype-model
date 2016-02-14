package com.jcalvopinam.client.dao;

import java.util.List;

import com.jcalvopinam.client.model.TipoParametro;

public interface ITipoParametroDao {
    public void add(TipoParametro tipo);

    public void update(TipoParametro tipo);

    public void delete(int id);

    public TipoParametro getTipoParametro(int id);

    public List<TipoParametro> getAllTipoParametros();
}
