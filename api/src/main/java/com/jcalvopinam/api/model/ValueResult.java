package com.jcalvopinam.api.model;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public class ValueResult {

    public String addResult(Valor r){
        return (r.getErrorMessage().isEmpty() ? r.getResult() : r.getErrorMessage());
    }
}
