package com.jcalvopinam.client.dao;

import java.util.List;

import com.jcalvopinam.client.model.ResultadoEjecucion;

public interface IResultadoEjecucionDao {

    public void add(ResultadoEjecucion resultado);

    public void update(ResultadoEjecucion resultado);

    public void delete(int id);

    public ResultadoEjecucion getResultadoEjecucion(int id);

    public List<ResultadoEjecucion> getAllResultadosEjecucion();

}
