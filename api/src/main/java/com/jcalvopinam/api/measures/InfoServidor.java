package com.jcalvopinam.api.measures;

import java.io.File;
import java.lang.management.ManagementFactory;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
public class InfoServidor {

    private static final Logger log = LoggerFactory.getLogger(InfoServidor.class);

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

    @SuppressWarnings("restriction")
    public InfoServidor() {
        long capacidadDisco = new File("/").getTotalSpace();
        this.totalDisco = FileUtils.byteCountToDisplaySize(capacidadDisco);
        log.info("Capacidad del Disco Duro: " + capacidadDisco);

        long capacidadRAM = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean())
                .getTotalPhysicalMemorySize();
        this.totalRAM = FileUtils.byteCountToDisplaySize(capacidadRAM);
        log.info("Capacidad de Memoria RAM: " + capacidadRAM);

        this.cpu = String.valueOf(ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors());
        log.info("Cantidad de CPU: " + cpu);

        this.sistemaOperativo = System.getProperty("os.name");
        log.info("Sistema Operativo: " + this.sistemaOperativo);
        this.arquitectura = System.getProperty("os.arch");
        log.info("Arquitectura del Sistema Operativo: " + this.arquitectura);
        this.version = System.getProperty("os.version");
        log.info("Version del Sistema Operativo: " + this.version);

    }

}
