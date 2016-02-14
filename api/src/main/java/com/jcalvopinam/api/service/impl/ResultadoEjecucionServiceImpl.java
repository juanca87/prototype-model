package com.jcalvopinam.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcalvopinam.api.dao.IResultadoEjecucionDao;
import com.jcalvopinam.api.model.ResultadoEjecucion;
import com.jcalvopinam.api.service.IResultadoEjecucionService;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

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
