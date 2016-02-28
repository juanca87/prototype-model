package com.jcalvopinam.api.measures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcalvopinam.api.utils.Valor;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public class Disco {

    Logger logDisco = LoggerFactory.getLogger(Disco.class);

    private String filePath = System.getProperty("user.dir") + File.separator;
    private String fileName = "testSavefileInHDD.txt";
    private String result = "";
    private String errorMessage = "";

    public Valor getTiempoEscrituraDisco() {

        long startTime = System.nanoTime();
        BufferedWriter writer = null;

        try {
            File logFile = new File(filePath, fileName);
            writer = new BufferedWriter(new FileWriter(logFile));
            StringBuilder text = new StringBuilder();
            int n = 10000;

            for (Integer i = 0; i < n; i++) {
                text.append("La vida es bella. ");
            }
//            for (Integer i = 0; i < n; i++) {
//                text.append("La vida es cara. ");
//            }

            writer.write(text.toString());

            logDisco.info("Directorio del archivo generado: " + logFile.getCanonicalPath());

        } catch (Exception e) {
            logDisco.error("There has been an unexpected error: " + e.getMessage());
            errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
                logDisco.error("Failed to close the connection: " + e.getMessage());
                errorMessage = e.getMessage();
                e.printStackTrace();
            }
        }

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;

        logDisco.info("<Disco> Tiempo de escritura en nano: " + elapsedTime);

        // long seconds = (elapsedTime / 1000) % 60;
        // long minutes = ((elapsedTime - seconds) / 1000) / 60;
        result = String.valueOf(elapsedTime);

        if (result.length() > 5)
            result = result.substring(0, 5);

        return new Valor(result, errorMessage);
    }

    public Valor getTiempoLecturaDisco() {
        BufferedReader br = null;
        long startTime = System.nanoTime();

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(filePath + fileName));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

            long elapsedTime = System.nanoTime() - startTime;

            logDisco.info("<Disco> Tiempo de lectura en nano: " + elapsedTime);

            // long seconds = (elapsedTime / 1000) % 60;
            // long minutes = ((elapsedTime - seconds) / 1000) / 60;
            result = String.valueOf(elapsedTime);
        } catch (IOException e) {
            logDisco.error("There has been an unexpected error: " + e.getMessage());
            errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                logDisco.error("Failed to close the connection: " + ex.getMessage());
                errorMessage = ex.getMessage();
                ex.printStackTrace();
            }
        }

        if (result.length() > 5)
            result = result.substring(0, 5);

        return new Valor(result, errorMessage);
    }
}
