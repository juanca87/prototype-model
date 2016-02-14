package com.jcalvopinam.api.dao;

import java.util.List;

import com.jcalvopinam.api.model.ResultadoPrueba;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public interface IResultadoPruebaDao {

    public void add(ResultadoPrueba resultado);

    public void update(ResultadoPrueba resultado);

    public void delete(int id);

    public ResultadoPrueba getResultado(int id);

    public List<ResultadoPrueba> getAllResultados();

}
