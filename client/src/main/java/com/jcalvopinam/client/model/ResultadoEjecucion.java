package com.jcalvopinam.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResultadoEjecucion {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String cpu;

    @Column
    private String lecturaMemoria;

    @Column
    private String escrituraMemoria;

    @Column
    private String lecturaDisco;

    @Column
    private String escrituraDisco;

    @Column
    private String anchoBanda;

    @Column
    private String latencia;

    @Column
    private String instruccionesMinuto;

    public ResultadoEjecucion() {
    }

    public ResultadoEjecucion(int id, String cpu, String lecturaMemoria, String escrituraMemoria, String lecturaDisco,
            String escrituraDisco, String anchoBanda, String latencia, String instruccionesMinuto) {
        super();
        this.id = id;
        this.cpu = cpu;
        this.lecturaMemoria = lecturaMemoria;
        this.escrituraMemoria = escrituraMemoria;
        this.lecturaDisco = lecturaDisco;
        this.escrituraDisco = escrituraDisco;
        this.anchoBanda = anchoBanda;
        this.latencia = latencia;
        this.instruccionesMinuto = instruccionesMinuto;
    }

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

}
