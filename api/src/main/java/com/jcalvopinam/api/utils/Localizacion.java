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

/**
 * 
 */
package com.jcalvopinam.api.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
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
        return hostname + "[" + ip.getHostAddress() + "]";
    }

}
