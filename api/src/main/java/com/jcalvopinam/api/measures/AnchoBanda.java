package com.jcalvopinam.api.measures;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcalvopinam.api.utils.Commons;
import com.jcalvopinam.api.utils.Valor;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public class AnchoBanda {

    private static final Logger logAnchoBanda = LoggerFactory.getLogger(AnchoBanda.class);

    Commons common = new Commons();

    public Valor getBandwith(String urlString) {

        String result = "";
        String errorMessage = "";
        String fileOutput = System.getProperty("user.dir") + File.separator + "imagen_Descargada.jpg";

        BufferedInputStream in = null;
        FileOutputStream fout = null;

        long startTime = System.nanoTime();

        try {
            URL url = new URL(urlString);
            URLConnection uc = url.openConnection();
            uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            uc.connect();
            in = new BufferedInputStream(uc.getInputStream());
            fout = new FileOutputStream(fileOutput);

            final byte data[] = new byte[1024];
            int count;

            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            logAnchoBanda.info("Tiempo de descarga> " + totalTime);

            result = common.formatearResultado(totalTime);

        } catch (Exception e) {
            result = "0";
            logAnchoBanda.error("There has been an unexpected error: " + e.getMessage());
            errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logAnchoBanda.error("Input Error: " + e.getMessage());
                    errorMessage = e.getMessage();
                }
            }
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    logAnchoBanda.error("Output Error: " + e.getMessage());
                    errorMessage = e.getMessage();
                }
            }
        }
        return new Valor(result, errorMessage);
    }

}
