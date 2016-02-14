package com.jcalvopinam.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

@Entity
public class ResultadoPrueba {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private Date fecha;

    @Column
    private String valor;

    @ManyToOne
    private TipoParametro tipo;

    public ResultadoPrueba() {
    }

    public ResultadoPrueba(int id, Date fecha, String valor, TipoParametro tipo) {
        super();
        this.id = id;
        this.fecha = fecha;
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoParametro getTipo() {
        return tipo;
    }

    public void setTipo(TipoParametro tipo) {
        this.tipo = tipo;
    }

}
