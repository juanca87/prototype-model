package com.jcalvopinam.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcalvopinam.client.dao.IResultadoEjecucionDao;
import com.jcalvopinam.client.dto.Atributo;
import com.jcalvopinam.client.dto.UltimaFechaEjecucion;
import com.jcalvopinam.client.model.ResultadoEjecucion;
import com.jcalvopinam.client.service.IResultadoEjecucionService;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
@Service
public class ResultadoEjecucionServiceImpl implements IResultadoEjecucionService {

    @Autowired
    private IResultadoEjecucionDao resultadoEjecucionDao;

    @Transactional
    public void save(ResultadoEjecucion resultado) {
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

    @Transactional
    public List<ResultadoEjecucion> getAllResultadosEjecucion(String serverName) {
        return resultadoEjecucionDao.getAllResultadosEjecucion(serverName);
    }

    @Transactional
    public List<Atributo> getUltimaEjecucion() {
        return resultadoEjecucionDao.getUltimaEjecucion();
    }

    @Transactional
    public UltimaFechaEjecucion getUltimaFechaEjecucion() {
        return resultadoEjecucionDao.getFechaUltimaEjecucion();
    }

    @Transactional
    public List<ResultadoEjecucion> getComparacion() {
        return resultadoEjecucionDao.getComparacion();
    }
}
