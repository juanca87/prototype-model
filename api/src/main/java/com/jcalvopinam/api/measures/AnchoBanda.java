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

        String filePath = System.getProperty("user.dir") + File.separator;
        String fileName = "imagenDescargada.jpg";
        String result = "";
        String errorMessage = "";

        BufferedInputStream bis = null;
        FileOutputStream fos = null;

        long startTime = System.nanoTime();

        try {
            URL url = new URL(urlString);
            URLConnection uc = url.openConnection();
            uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            uc.connect();

            bis = new BufferedInputStream(uc.getInputStream());
            fos = new FileOutputStream(filePath + fileName);

            logAnchoBanda.info("Directorio del archivo descargado: " + filePath);

            final byte data[] = new byte[1024];
            int count;

            while ((count = bis.read(data, 0, 1024)) != -1) {
                fos.write(data, 0, count);
            }

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            File file = new File(filePath, fileName);
            logAnchoBanda.info(String.format("Tardó %.3f segundos en descargar %d MB", totalTime / 1e9, file.length()));
            file.deleteOnExit();

            result = common.formatearResultado(totalTime);

        } catch (Exception e) {
            result = "0";
            logAnchoBanda.error("Ha ocurrido un error inesperado: " + e.getMessage());
            errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    logAnchoBanda.error("Input Error: " + e.getMessage());
                    errorMessage = e.getMessage();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    logAnchoBanda.error("Output Error: " + e.getMessage());
                    errorMessage = e.getMessage();
                }
            }
        }
        return new Valor(result, errorMessage);
    }

}
