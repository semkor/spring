package com.lesson2.hw1;

import java.util.List;

public class Service {
    private long id;
    private String name;
    private List<String> paramsToCall;


    public Service(long id, String name,List<String> paramsToCall) {
        this.id = id;
        this.name = name;
        this.paramsToCall = paramsToCall;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getParamsToCall() {
        return paramsToCall;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", paramsToCall='" + getParamsToCall() +
                '}';
    }
}
