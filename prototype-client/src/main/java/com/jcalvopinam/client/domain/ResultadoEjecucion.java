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

package com.jcalvopinam.client.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */
@Entity
public class ResultadoEjecucion {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @Temporal(TemporalType.DATE)
    @Column
    private Date fecha;

    @Column
    private String servidor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
