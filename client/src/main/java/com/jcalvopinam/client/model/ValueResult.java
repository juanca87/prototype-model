package com.jcalvopinam.client.model;

public class ValueResult {

    public String addResult(Valor r){
        return (r.getErrorMessage().isEmpty() ? r.getResult() : r.getErrorMessage());
    }
}
