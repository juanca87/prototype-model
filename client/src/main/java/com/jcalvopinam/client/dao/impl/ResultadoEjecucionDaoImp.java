package com.jcalvopinam.client.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcalvopinam.client.dao.IResultadoEjecucionDao;
import com.jcalvopinam.client.dto.Atributo;
import com.jcalvopinam.client.dto.Proveedor;
import com.jcalvopinam.client.dto.UltimaFechaEjecucion;
import com.jcalvopinam.client.model.ResultadoEjecucion;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
@Repository
public class ResultadoEjecucionDaoImp implements IResultadoEjecucionDao {

    private static final String AMAZON = "amazon";
    private static final String GOOGLE = "google";
    private static final String HEROKU = "heroku";

    List<Proveedor> listaAtributosProveedor = null;
    List<Proveedor> listaAtributosUltimaEjecucion = new ArrayList<Proveedor>();

    @Autowired
    private SessionFactory session;

    @Override
    public void add(ResultadoEjecucion resultado) {
        session.getCurrentSession().save(resultado);
    }

    @Override
    public void update(ResultadoEjecucion resultado) {
        session.getCurrentSession().update(resultado);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getResultadoEjecucion(id));
    }

    @Override
    public ResultadoEjecucion getResultadoEjecucion(int id) {
        return (ResultadoEjecucion) session.getCurrentSession().get(ResultadoEjecucion.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ResultadoEjecucion> getAllResultadosEjecucion() {
        return session.getCurrentSession().createQuery("from ResultadoEjecucion").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ResultadoEjecucion> getAllResultadosEjecucion(String serverName) {
        return session.getCurrentSession()
                .createQuery("from ResultadoEjecucion where servidor = :serverName order by fecha desc")
                .setParameter("serverName", serverName).setMaxResults(200).list();
    }

    @Override
    public List<Proveedor> getUltimaEjecucion() {
        listaAtributosProveedor = new ArrayList<Proveedor>();
        List<Proveedor> ultimaEjecucion = setResultadoUltimaEjecucion(getListaUltimaEjecucion());
        this.setListaAtributosUltimaEjecucion(ultimaEjecucion);
        return ultimaEjecucion;
    }

    /**
     * Recupera una lista con los resultados de la utilma fecha de ejecucion de cada proveedor
     * 
     * @return Lista de ResultadoEjecucion
     */
    public List<ResultadoEjecucion> getListaUltimaEjecucion() {
        UltimaFechaEjecucion fechaUltimaEjecucion = this.getFechaUltimaEjecucion();

        Date fechaAmazon = fechaUltimaEjecucion.getFechaAmazon();
        Date fechaGoogle = fechaUltimaEjecucion.getFechaGoogle();
        Date fechaHeroku = fechaUltimaEjecucion.getFechaHeroku();

        List<ResultadoEjecucion> amazon = getResultadoByServidor(fechaAmazon, AMAZON);
        List<ResultadoEjecucion> google = getResultadoByServidor(fechaGoogle, GOOGLE);
        List<ResultadoEjecucion> heroku = getResultadoByServidor(fechaHeroku, HEROKU);

        List<ResultadoEjecucion> listaResultados = new ArrayList<ResultadoEjecucion>();
        listaResultados.addAll(amazon);
        listaResultados.addAll(google);
        listaResultados.addAll(heroku);

        return listaResultados;
    }

    @Override
    public List<ResultadoEjecucion> getComparacion() {
        List<ResultadoEjecucion> resultado = this.getListaUltimaEjecucion();
        return resultado;
    }

    /**
     * Busca el atributo y recuperar los resultados
     * 
     * @param atributo
     *            nombre del atributo
     * @return objeto Atributo
     */
    @Override
    public List<Atributo> getAtributoByName(String atributo) {

        List<Proveedor> listaProveedores = this.getUltimaEjecucion();
        List<Atributo> listaAtributos = new ArrayList<Atributo>();
        Atributo resultadoAmazon = new Atributo();
        Atributo resultadoGoogle = new Atributo();
        Atributo resultadoHeroku = new Atributo();

        for (Proveedor p : listaProveedores) {
            if (p.getAtributo().contains(atributo)) {
                resultadoAmazon.setLabel(AMAZON);
                resultadoAmazon.setValue(Double.parseDouble(p.getAmazon()));
                listaAtributos.add(resultadoAmazon);
                resultadoGoogle.setLabel(GOOGLE);
                resultadoGoogle.setValue(Double.parseDouble(p.getGoogle()));
                listaAtributos.add(resultadoGoogle);
                resultadoHeroku.setLabel(HEROKU);
                resultadoHeroku.setValue(Double.parseDouble(p.getHeroku()));
                listaAtributos.add(resultadoHeroku);
                break;
            }
        }
        return listaAtributos;
    }

    /**
     * Obtiene los resultado de la ejecucion por proveedor
     * 
     * @param fecha
     * @param servidor
     * @return Lista de ResultadoEjecucion
     */
    @SuppressWarnings("unchecked")
    private List<ResultadoEjecucion> getResultadoByServidor(Date fecha, String servidor) {
        List<ResultadoEjecucion> resultado = session.getCurrentSession()
                .createQuery("from ResultadoEjecucion where fecha = :fechaActual and " + "servidor = :nombreServidor")
                .setParameter("fechaActual", fecha).setParameter("nombreServidor", servidor).setMaxResults(1).list();
        return resultado;
    }

    /**
     * Setea los resultados de la ultima ejecucion en una lista de proveedores
     * 
     * @param resultados
     * @return Lista de Proveedores
     */
    private List<Proveedor> setResultadoUltimaEjecucion(List<ResultadoEjecucion> resultados) {

        Proveedor anchoBanda = new Proveedor();
        Proveedor cpu = new Proveedor();
        Proveedor escrituraDisco = new Proveedor();
        Proveedor escrituraMemoria = new Proveedor();
        Proveedor instruccionesMinuto = new Proveedor();
        Proveedor latencia = new Proveedor();
        Proveedor lecturaDisco = new Proveedor();
        Proveedor lecturaMemoria = new Proveedor();

        for (ResultadoEjecucion resultado : resultados) {

            anchoBanda.setAtributo("Ancho de banda");
            if (resultado.getServidor().equals(AMAZON))
                anchoBanda.setAmazon(resultado.getAnchoBanda());
            else if (resultado.getServidor().equals(GOOGLE))
                anchoBanda.setGoogle(resultado.getAnchoBanda());
            else
                anchoBanda.setHeroku(resultado.getAnchoBanda());

            cpu.setAtributo("CPU");
            if (resultado.getServidor().equals(AMAZON))
                cpu.setAmazon(resultado.getCpu());
            else if (resultado.getServidor().equals(GOOGLE))
                cpu.setGoogle(resultado.getCpu());
            else
                cpu.setHeroku(resultado.getCpu());

            escrituraDisco.setAtributo("Escritura en Disco");
            if (resultado.getServidor().equals(AMAZON))
                escrituraDisco.setAmazon(resultado.getEscrituraDisco());
            else if (resultado.getServidor().equals(GOOGLE))
                escrituraDisco.setGoogle(resultado.getEscrituraDisco());
            else
                escrituraDisco.setHeroku(resultado.getEscrituraDisco());

            escrituraMemoria.setAtributo("Escritura en Memoria");
            if (resultado.getServidor().equals(AMAZON))
                escrituraMemoria.setAmazon(resultado.getEscrituraMemoria());
            else if (resultado.getServidor().equals(GOOGLE))
                escrituraMemoria.setGoogle(resultado.getEscrituraMemoria());
            else
                escrituraMemoria.setHeroku(resultado.getEscrituraMemoria());

            instruccionesMinuto.setAtributo("Instrucciones por Minuto");
            if (resultado.getServidor().equals(AMAZON))
                instruccionesMinuto.setAmazon(resultado.getInstruccionesMinuto());
            else if (resultado.getServidor().equals(GOOGLE))
                instruccionesMinuto.setGoogle(resultado.getInstruccionesMinuto());
            else
                instruccionesMinuto.setHeroku(resultado.getInstruccionesMinuto());

            latencia.setAtributo("Latencia");
            if (resultado.getServidor().equals(AMAZON))
                latencia.setAmazon(resultado.getLatencia());
            else if (resultado.getServidor().equals(GOOGLE))
                latencia.setGoogle(resultado.getLatencia());
            else
                latencia.setHeroku(resultado.getLatencia());

            lecturaDisco.setAtributo("Lectura en Disco");
            if (resultado.getServidor().equals(AMAZON))
                lecturaDisco.setAmazon(resultado.getLecturaDisco());
            else if (resultado.getServidor().equals(GOOGLE))
                lecturaDisco.setGoogle(resultado.getLecturaDisco());
            else
                lecturaDisco.setHeroku(resultado.getLecturaDisco());

            lecturaMemoria.setAtributo("Lectura en Memoria");
            if (resultado.getServidor().equals(AMAZON))
                lecturaMemoria.setAmazon(resultado.getLecturaMemoria());
            else if (resultado.getServidor().equals(GOOGLE))
                lecturaMemoria.setGoogle(resultado.getLecturaMemoria());
            else
                lecturaMemoria.setHeroku(resultado.getLecturaMemoria());

        }

        listaAtributosProveedor.add(anchoBanda);
        listaAtributosProveedor.add(cpu);
        listaAtributosProveedor.add(escrituraDisco);
        listaAtributosProveedor.add(escrituraMemoria);
        listaAtributosProveedor.add(instruccionesMinuto);
        listaAtributosProveedor.add(latencia);
        listaAtributosProveedor.add(lecturaDisco);
        listaAtributosProveedor.add(lecturaMemoria);

        this.setListaAtributosUltimaEjecucion(listaAtributosUltimaEjecucion);

        return listaAtributosProveedor;
    }

    /**
     * Obtiene UltimaFechaEjecucion de todos los proveedor en un unico Objeto
     * 
     * @return Objeto UltimaFechaEjecucion
     */
    public UltimaFechaEjecucion getFechaUltimaEjecucion() {
        UltimaFechaEjecucion ultimaEjecucion = new UltimaFechaEjecucion();
        Date fechaAmazon = this.getUltimaFechaEjecucionByServidor(AMAZON);
        Date fechaGoogle = this.getUltimaFechaEjecucionByServidor(GOOGLE);
        Date fechaHeroku = this.getUltimaFechaEjecucionByServidor(HEROKU);

        ultimaEjecucion.setFechaAmazon(fechaAmazon);
        ultimaEjecucion.setFechaGoogle(fechaGoogle);
        ultimaEjecucion.setFechaHeroku(fechaHeroku);

        return ultimaEjecucion;
    }

    /**
     * Obtiene la fecha de la ultima ejecucion por cada proveedor
     * 
     * @param servidor
     * @return Date
     */
    private Date getUltimaFechaEjecucionByServidor(String servidor) {
        Date fechaActual = (Date) session.getCurrentSession()
                .createQuery("Select fecha from ResultadoEjecucion where servidor = :nombreServidor "
                        + "order by fecha desc")
                .setParameter("nombreServidor", servidor).setMaxResults(1).uniqueResult();

        return fechaActual;

    }

    public List<Proveedor> getListaAtributosUltimaEjecucion() {
        return listaAtributosUltimaEjecucion;
    }

    public void setListaAtributosUltimaEjecucion(List<Proveedor> listaAtributosUltimaEjecucion) {
        this.listaAtributosUltimaEjecucion = listaAtributosUltimaEjecucion;
    }

}
