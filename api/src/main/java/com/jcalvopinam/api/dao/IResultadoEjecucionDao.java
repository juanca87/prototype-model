package com.jcalvopinam.api.dao;

import java.util.List;

import com.jcalvopinam.api.model.ResultadoEjecucion;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public interface IResultadoEjecucionDao {

    public void add(ResultadoEjecucion resultado);

    public void update(ResultadoEjecucion resultado);

    public void delete(int id);

    public ResultadoEjecucion getResultadoEjecucion(int id);

    public List<ResultadoEjecucion> getAllResultadosEjecucion();

}
