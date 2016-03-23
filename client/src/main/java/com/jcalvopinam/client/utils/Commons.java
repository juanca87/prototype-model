package com.jcalvopinam.client.utils;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
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

    public static String getValorMinimo(List<Double> valores) {
        Double minVal = ObjectUtils.min(valores.toArray(new Double[valores.size()]));
        return String.valueOf(minVal);

    }
}
