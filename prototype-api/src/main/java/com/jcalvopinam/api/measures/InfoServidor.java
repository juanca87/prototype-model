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

package com.jcalvopinam.api.measures;

import java.io.File;
import java.lang.management.ManagementFactory;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
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
