package com.jcalvopinam.client.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
public class Localizacion {

    private static Logger log = LoggerFactory.getLogger(Localizacion.class);
    private static final String LOCALHOST = "localhost";

    public static String getInfoServidorRemoto() {

        String ip = "";

        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            ip = in.readLine();
            log.info("IP publica servidor : " + ip);
        } catch (Exception e) {
            log.error("No se pudo obtener datos del servidor: ");
            e.printStackTrace();
        }
        return ip;
    }

    public static String getInfoServidorLocal() {

        InetAddress ip = null;
        String hostname = null;

        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            log.info("Direccion IP : " + ip);
            log.info("Nombre del servidor : " + hostname);
        } catch (UnknownHostException e) {
            log.error("No se pudo obtener datos del servidor: ");
            e.printStackTrace();
        }
        return LOCALHOST;
    }

}
