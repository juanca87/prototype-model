package com.jcalvopinam.api.dao;

import java.util.List;

import com.jcalvopinam.api.model.TipoParametro;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public interface ITipoParametroDao {
    public void add(TipoParametro tipo);

    public void update(TipoParametro tipo);

    public void delete(int id);

    public TipoParametro getTipoParametro(int id);

    public List<TipoParametro> getAllTipoParametros();
}
