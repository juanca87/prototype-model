package com.jcalvopinam.client.dao;

import java.util.List;

import com.jcalvopinam.client.dto.Atributo;
import com.jcalvopinam.client.dto.Proveedor;
import com.jcalvopinam.client.dto.UltimaFechaEjecucion;
import com.jcalvopinam.client.model.ResultadoEjecucion;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
public interface IResultadoEjecucionDao {

    public void add(ResultadoEjecucion resultado);

    public void update(ResultadoEjecucion resultado);

    public void delete(int id);

    public ResultadoEjecucion getResultadoEjecucion(int id);

    public List<ResultadoEjecucion> getAllResultadosEjecucion();

    public List<ResultadoEjecucion> getAllResultadosEjecucion(String serverName);

    public List<Proveedor> getUltimaEjecucion();

    public UltimaFechaEjecucion getFechaUltimaEjecucion();

    public List<ResultadoEjecucion> getComparacion();

    public List<Atributo> getAtributoByName(String atributo);

}
