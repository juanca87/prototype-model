package com.jcalvopinam.api.model;

import java.util.Date;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public class ResultadoEjecucion {

    private int id;
    private String cpu;
    private String lecturaMemoria;
    private String escrituraMemoria;
    private String lecturaDisco;
    private String escrituraDisco;
    private String anchoBanda;
    private String latencia;
    private String instruccionesMinuto;
    private Date fecha;
    private String servidor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getLecturaMemoria() {
        return lecturaMemoria;
    }

    public void setLecturaMemoria(String lecturaMemoria) {
        this.lecturaMemoria = lecturaMemoria;
    }

    public String getEscrituraMemoria() {
        return escrituraMemoria;
    }

    public void setEscrituraMemoria(String escrituraMemoria) {
        this.escrituraMemoria = escrituraMemoria;
    }

    public String getLecturaDisco() {
        return lecturaDisco;
    }

    public void setLecturaDisco(String lecturaDisco) {
        this.lecturaDisco = lecturaDisco;
    }

    public String getEscrituraDisco() {
        return escrituraDisco;
    }

    public void setEscrituraDisco(String escrituraDisco) {
        this.escrituraDisco = escrituraDisco;
    }

    public String getAnchoBanda() {
        return anchoBanda;
    }

    public void setAnchoBanda(String anchoBanda) {
        this.anchoBanda = anchoBanda;
    }

    public String getLatencia() {
        return latencia;
    }

    public void setLatencia(String latencia) {
        this.latencia = latencia;
    }

    public String getInstruccionesMinuto() {
        return instruccionesMinuto;
    }

    public void setInstruccionesMinuto(String instruccionesMinuto) {
        this.instruccionesMinuto = instruccionesMinuto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

}
