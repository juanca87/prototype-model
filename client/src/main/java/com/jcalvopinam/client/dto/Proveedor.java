package com.jcalvopinam.client.dto;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
public class Proveedor {

    private String atributo;
    private String amazon;
    private String google;
    private String heroku;

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getAmazon() {
        return amazon;
    }

    public void setAmazon(String amazon) {
        this.amazon = amazon;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getHeroku() {
        return heroku;
    }

    public void setHeroku(String heroku) {
        this.heroku = heroku;
    }

}
