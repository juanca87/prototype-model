package com.jcalvopinam.client.dao;

import java.util.List;

import com.jcalvopinam.client.model.ResultadoPrueba;

public interface IResultadoPruebaDao {

    public void add(ResultadoPrueba resultado);

    public void update(ResultadoPrueba resultado);

    public void delete(int id);

    public ResultadoPrueba getResultado(int id);

    public List<ResultadoPrueba> getAllResultados();

}
