package com.jcalvopinam.api.measures;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.jcalvopinam.api.utils.Valor;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public class AnchoBanda {

    public Valor getBandwith() {

        String result = "";
        String errorMessage = "";
        String urlString = "http://planwallpaper.com/static/images/2022725-wallpaper_625864_Iz6NK8G.jpg";
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
            System.out.println("Tiempo de descarga> " + totalTime);
            result = String.valueOf(totalTime);
            if (result.length() > 5)
                result = result.substring(0, 5);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    errorMessage = e.getMessage();
                }
            }
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    errorMessage = e.getMessage();
                }
            }
        }
        return new Valor(result, errorMessage);
    }

}
