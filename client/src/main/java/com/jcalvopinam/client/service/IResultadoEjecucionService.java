package com.jcalvopinam.client.service;

import java.util.List;

import com.jcalvopinam.client.dto.Atributo;
import com.jcalvopinam.client.dto.UltimaFechaEjecucion;
import com.jcalvopinam.client.model.ResultadoEjecucion;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
public interface IResultadoEjecucionService {

    public void save(ResultadoEjecucion resultado);

    public void update(ResultadoEjecucion resultado);

    public void delete(int id);

    public ResultadoEjecucion getResultadoEjecucion(int id);

    public List<ResultadoEjecucion> getAllResultadosEjecucion();

    public List<ResultadoEjecucion> getAllResultadosEjecucion(String serverName);

    public List<Atributo> getUltimaEjecucion();

    public UltimaFechaEjecucion getUltimaFechaEjecucion();

    public List<ResultadoEjecucion> getComparacion();

}
