/**
 * 
 */
package com.jcalvopinam.client.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
public class Localizacion {

    private static Logger log = LoggerFactory.getLogger(Localizacion.class);

    public static String getInfoServidor() {

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
        return ip.getHostAddress();
    }

}
