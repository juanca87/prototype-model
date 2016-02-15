package com.jcalvopinam.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcalvopinam.client.dao.IResultadoEjecucionDao;
import com.jcalvopinam.client.model.ResultadoEjecucion;
import com.jcalvopinam.client.service.IResultadoEjecucionService;

@Service
public class ResultadoEjecucionServiceImpl implements IResultadoEjecucionService {

    @Autowired
    private IResultadoEjecucionDao resultadoEjecucionDao;

    @Transactional
    public void add(ResultadoEjecucion resultado) {
        resultadoEjecucionDao.add(resultado);
    }

    @Transactional
    public void update(ResultadoEjecucion resultado) {
        resultadoEjecucionDao.update(resultado);
    }

    @Transactional
    public void delete(int id) {
        resultadoEjecucionDao.delete(id);
    }

    @Transactional
    public ResultadoEjecucion getResultadoEjecucion(int id) {
        return resultadoEjecucionDao.getResultadoEjecucion(id);
    }

    @Transactional
    public List<ResultadoEjecucion> getAllResultadosEjecucion() {
        return resultadoEjecucionDao.getAllResultadosEjecucion();
    }

}