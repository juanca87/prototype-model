package com.jcalvopinam.api.measures;

import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

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

    public Valor getLatency() {
        String result = "";
        String errorMessage = "";
        String ip = "173.194.42.78";
        int port = 80;
        int times = 5;
        String hostaddr = "";

        try {
            hostaddr = InetAddress.getByName(ip).getHostAddress();
        } catch (UnknownHostException e) {
            errorMessage = e.getMessage();
        }

        System.out.println("Pinging " + ip + " (" + hostaddr + ") " + times + " times on port " + port + "...\n");
        int total = 0;
        long totalping = 0;
        Socket s = null;

        while (total < times) {
            total++;
            long start = System.nanoTime();

            try {
                SocketAddress sockaddr = new InetSocketAddress(hostaddr, port);
                s = new Socket();
                s.connect(sockaddr, 1000);
            } catch (SocketTimeoutException e) {
                System.out.println("Socket Request[" + total + "]: Connection timed out.");
                continue;
            } catch (UnknownHostException u) {
                errorMessage = u.getMessage();
            } catch (IOException io) {
                errorMessage = io.getMessage();
            }

            long end = System.nanoTime();
            totalping += (end - start);
            long totaltime = (end - start);
            long avg = (totalping / total);
            System.out.println("Socket Request[" + total + "]: Time(In nano): " + totaltime + " Average: " + avg);
            result = String.valueOf(avg);
        }

        long avg = (long) (totalping / total);
        System.out.println("\nFinal Result: Average request - " + avg);
        if (result.length() > 5)
            result = result.substring(0, 5);
        return new Valor(result, errorMessage);
    }

}
