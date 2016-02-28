package com.jcalvopinam.api.utils;

import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;

/**
 * @author Juan Calvopina Morillo <juan.calvopina@gmail.com>
 *
 */
public class Commons {

    /**
     * Agrega la cabecera a la respuesta del mensaje
     * 
     * @return HttpHeaders object
     */
    public static HttpHeaders getHpptHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        return headers;
    }

    /**
     * Crea un mensaje personalizado de error en formato json
     * 
     * @return JSONObject object
     */
    @SuppressWarnings("unchecked")
    public static JSONObject getErrorMessage(String type, String message) {
        JSONObject errorMessage = new JSONObject();
        errorMessage.put("type", type);
        errorMessage.put("message", message);
        return errorMessage;
    }
}
