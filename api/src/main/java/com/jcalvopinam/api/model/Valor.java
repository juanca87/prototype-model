package com.jcalvopinam.api.model;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public class Valor {

    private String result;
    private String errorMessage;

    public Valor(String result, String errorMessage) {
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
