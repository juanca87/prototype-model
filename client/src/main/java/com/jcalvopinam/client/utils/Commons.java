package com.jcalvopinam.client.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
public class Commons {

    /**
     * Agrega la cabecera a la respuesta del mensaje
     */
    public static HttpHeaders getHpptHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        return headers;
    }

    /**
     * Crea un mensaje personalizado de error en formato json
     * 
     * @param type
     *            tipo de error
     * @param message
     *            descripcion del error
     * @return JSONObject object
     */
    @SuppressWarnings("unchecked")
    public static JSONObject getErrorMessage(String type, String message) {
        JSONObject errorMessage = new JSONObject();
        errorMessage.put("type", type);
        errorMessage.put("message", message);
        return errorMessage;
    }
    
    
    /**
     * TODO Comment
     * */
    public String leerUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();

        } finally {
            is.close();
        }
    }

}
