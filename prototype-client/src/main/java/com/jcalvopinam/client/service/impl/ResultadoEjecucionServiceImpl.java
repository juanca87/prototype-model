/*
 * MIT License
 *
 * Copyright (c) 2017 JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.jcalvopinam.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcalvopinam.client.dao.IResultadoEjecucionDao;
import com.jcalvopinam.client.dto.Atributo;
import com.jcalvopinam.client.dto.Proveedor;
import com.jcalvopinam.client.dto.UltimaFechaEjecucion;
import com.jcalvopinam.client.model.ResultadoEjecucion;
import com.jcalvopinam.client.service.IResultadoEjecucionService;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
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
    public List<Proveedor> getUltimaEjecucion() {
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

    @Transactional
    public List<Atributo> getAtributoByName(String atributo) {
        return resultadoEjecucionDao.getAtributoByName(atributo);
    }

}
