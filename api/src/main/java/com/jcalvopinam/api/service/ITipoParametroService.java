package com.jcalvopinam.api.service;

import java.util.List;

import com.jcalvopinam.api.model.TipoParametro;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public interface ITipoParametroService {

    public void add(TipoParametro tipo);

    public void update(TipoParametro tipo);

    public void delete(int id);

    public TipoParametro getTipoParametro(int id);

    public List<TipoParametro> getAllTipoParametros();
}
