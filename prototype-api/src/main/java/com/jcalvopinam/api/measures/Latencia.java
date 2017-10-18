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

import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcalvopinam.api.utils.Commons;
import com.jcalvopinam.api.utils.Valor;

import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.io.IOException;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public class Latencia {

    private static final Logger logLatencia = LoggerFactory.getLogger(Latencia.class);

    Commons common = new Commons();

    public Valor getLatency(String ip) {
        String result = "";
        String errorMessage = "";
        int port = 80;
        int intentoMax = 5;
        String hostaddr = "";

        try {
            hostaddr = InetAddress.getByName(ip).getHostAddress();
        } catch (UnknownHostException e) {
            logLatencia.error("Host desconocido: " + e.getMessage());
            errorMessage = e.getMessage();
        }

        logLatencia
                .info("Ping a " + ip + " (" + hostaddr + ") " + intentoMax + " veces en el puerto " + port + "...\n");

        long tiempoTotal = 0;
        int intento = 0;
        long promedio = 0;
        long acumulaTiempo = 0;
        Socket s = null;

        while (intento < intentoMax) {
            intento++;
            long tiempoInicial = System.nanoTime();

            try {
                SocketAddress sockaddr = new InetSocketAddress(hostaddr, port);
                s = new Socket();
                s.connect(sockaddr, 1000);
            } catch (SocketTimeoutException e) {
                errorMessage = e.getMessage();
                logLatencia.error("Socket Request[" + intento + "]: Connection timed out.");
                continue;
            } catch (UnknownHostException u) {
                logLatencia.error("Unknown Host: " + u.getMessage());
                errorMessage = u.getMessage();
            } catch (IOException io) {
                logLatencia.error("IO Host: " + io.getMessage());
                errorMessage = io.getMessage();
            }

            long tiempoFinal = System.nanoTime();
            tiempoTotal = (tiempoFinal - tiempoInicial);
            acumulaTiempo += tiempoTotal;

            logLatencia.info("Petición [" + intento + "]: Tiempo " + tiempoTotal + " nanosegundos");

        }

        promedio = (acumulaTiempo / intento);
        logLatencia.info("Tiempo promedio: " + promedio + " nanosegundos");

        result = common.formatearResultado(promedio);

        return new Valor(result, errorMessage);
    }

}
