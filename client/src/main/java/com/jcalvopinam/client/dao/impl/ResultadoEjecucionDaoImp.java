package com.jcalvopinam.client.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcalvopinam.client.dao.IResultadoEjecucionDao;
import com.jcalvopinam.client.dto.Comparacion;
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

    List<Comparacion> comparaciones = null;

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
    public List<Comparacion> getComparacion() {

        Date fechaActual = (Date) session.getCurrentSession()
                .createQuery("Select fecha from ResultadoEjecucion order by fecha desc").setMaxResults(1)
                .uniqueResult();

        comparaciones = new ArrayList<Comparacion>();

        List<ResultadoEjecucion> amazon = getResultadoByServidor(fechaActual, AMAZON);
        List<ResultadoEjecucion> google = getResultadoByServidor(fechaActual, GOOGLE);
        List<ResultadoEjecucion> heroku = getResultadoByServidor(fechaActual, HEROKU);

        List<ResultadoEjecucion> listaResultados = new ArrayList<ResultadoEjecucion>();
        listaResultados.addAll(amazon);
        listaResultados.addAll(google);
        listaResultados.addAll(heroku);

        List<Comparacion> resultadoComparacion = setResultadoComparacion(listaResultados);

        return resultadoComparacion;
    }

    @SuppressWarnings("unchecked")
    private List<ResultadoEjecucion> getResultadoByServidor(Date fecha, String servidor) {
        List<ResultadoEjecucion> resultado = session.getCurrentSession()
                .createQuery("from ResultadoEjecucion where fecha = :fechaActual and " + "servidor = :nombreServidor")
                .setParameter("fechaActual", fecha).setParameter("nombreServidor", servidor).setMaxResults(1).list();
        return resultado;
    }

    private List<Comparacion> setResultadoComparacion(List<ResultadoEjecucion> resultados) {

        Comparacion anchoBanda = new Comparacion();
        Comparacion cpu = new Comparacion();
        Comparacion escrituraDisco = new Comparacion();
        Comparacion escrituraMemoria = new Comparacion();
        Comparacion instruccionesMinuto = new Comparacion();
        Comparacion latencia = new Comparacion();
        Comparacion lecturaDisco = new Comparacion();
        Comparacion lecturaMemoria = new Comparacion();

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

        comparaciones.add(anchoBanda);
        comparaciones.add(cpu);
        comparaciones.add(escrituraDisco);
        comparaciones.add(escrituraMemoria);
        comparaciones.add(instruccionesMinuto);
        comparaciones.add(latencia);
        comparaciones.add(lecturaDisco);
        comparaciones.add(lecturaMemoria);

        return comparaciones;
    }

}
