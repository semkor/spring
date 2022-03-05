package com.lesson2.hw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller ("control")
public class Controllers {
    @Autowired
    private Service service;
    @Autowired
    private Step step;
    @Autowired
    private Route route;

    @RequestMapping(method= RequestMethod.GET, value = "/result", produces = "text/plain")
    public @ResponseBody String callByBeans(){
        System.out.println("Get класса Service");
            System.out.println(service.getId());
            System.out.println(service.getName());
            System.out.println(service.getParamsToCall());
        System.out.println("Get класса Step");
            System.out.println(step.getId());
            System.out.println(step.getServiceFrom());
            System.out.println(step.getServiceTo());
            System.out.println(step.getParamServiceFrom());
            System.out.println(step.getParamsServiceTo());
        System.out.println("Get класса Route");
            System.out.println(route.getId());
            System.out.println(route.getSteps());
        return "ok";
    }
}
