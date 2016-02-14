package com.jcalvopinam.client.service;

import java.util.List;

import com.jcalvopinam.client.model.TipoParametro;

public interface ITipoParametroService {

    public void add(TipoParametro tipo);

    public void update(TipoParametro tipo);

    public void delete(int id);

    public TipoParametro getTipoParametro(int id);

    public List<TipoParametro> getAllTipoParametros();
}
