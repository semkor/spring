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
        System.out.println("Get класса Service: " + " " + service.getId() + " " + service.getName() + " " + service.getParamsToCall());
        System.out.println("Get класса Step: " + " " + step.getId() + " " + step.getServiceFrom() + " " + step.getServiceTo()
                + " " + step.getParamServiceFrom()  + " " + step.getParamsServiceTo());
        System.out.println("Get класса Route: "  + " " + route.getId()  + " " + route.getSteps());
        return "ok";
    }
}
