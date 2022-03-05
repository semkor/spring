package com.lesson2.hw1;

import org.springframework.stereotype.Component;
import java.util.Map;


public class Step {
    private long id;
    private Service serviceFrom;
    private Service serviceTo;
    private Map<String,String> paramServiceFrom;
    private Map<String,String> paramsServiceTo;

    public Step(long id, Service serviceFrom, Service serviceTo, Map<String, String> paramServiceFrom, Map<String, String> paramsServiceTo) {
        this.id = id;
        this.serviceFrom = serviceFrom;
        this.serviceTo = serviceTo;
        this.paramServiceFrom = paramServiceFrom;
        this.paramsServiceTo = paramsServiceTo;
    }

    public long getId() {
        return id;
    }

    public Service getServiceFrom() {
        return serviceFrom;
    }

    public Service getServiceTo() {
        return serviceTo;
    }

    public Map<String, String> getParamServiceFrom() {
        return paramServiceFrom;
    }

    public Map<String, String> getParamsServiceTo() {
        return paramsServiceTo;
    }

}
