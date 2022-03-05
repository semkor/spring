package com.lesson2.hw1;

import com.lesson4.hw2.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("Get класса Service");
            System.out.println(context.getBean(Service.class).getId());
            System.out.println(context.getBean(Service.class).getName());
            System.out.println(context.getBean(Service.class).getParamsToCall());
        System.out.println("Get класса Step");
            System.out.println(context.getBean(Step.class).getId());
            System.out.println(context.getBean(Step.class).getServiceFrom());
            System.out.println(context.getBean(Step.class).getServiceTo());
        System.out.println("Get класса Route");
            System.out.println(context.getBean(Route.class).getId());
            System.out.println(context.getBean(Route.class).getSteps());
    }
}
