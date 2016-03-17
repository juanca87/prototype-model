package com.jcalvopinam.client.dto;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
public class InfoServidor {

    private String sistemaOperativo;

    private String arquitectura;

    private String version;

    private String totalDisco;

    private String totalRAM;

    private String cpu;

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getArquitectura() {
        return arquitectura;
    }

    public void setArquitectura(String arquitectura) {
        this.arquitectura = arquitectura;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTotalDisco() {
        return totalDisco;
    }

    public void setTotalDisco(String totalDisco) {
        this.totalDisco = totalDisco;
    }

    public String getTotalRAM() {
        return totalRAM;
    }

    public void setTotalRAM(String totalRAM) {
        this.totalRAM = totalRAM;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

}
