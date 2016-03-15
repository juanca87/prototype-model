package com.jcalvopinam.client.dto;

import java.util.Date;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
public class UltimaFechaEjecucion {

    private Date fechaAmazon;
    private Date fechaGoogle;
    private Date fechaHeroku;

    public Date getFechaAmazon() {
        return fechaAmazon;
    }

    public void setFechaAmazon(Date fechaAmazon) {
        this.fechaAmazon = fechaAmazon;
    }

    public Date getFechaGoogle() {
        return fechaGoogle;
    }

    public void setFechaGoogle(Date fechaGoogle) {
        this.fechaGoogle = fechaGoogle;
    }

    public Date getFechaHeroku() {
        return fechaHeroku;
    }

    public void setFechaHeroku(Date fechaHeroku) {
        this.fechaHeroku = fechaHeroku;
    }

}
