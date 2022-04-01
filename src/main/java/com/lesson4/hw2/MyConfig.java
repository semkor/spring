package com.lesson4.hw2;

import com.lesson2.OrderDAO;
import com.lesson2.OrderService;
import com.lesson2.hw1.Route;
import com.lesson2.hw1.Service;
import com.lesson2.hw1.Step;
import com.lesson2.hw2.ItemDAO;
import com.lesson2.hw2.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

@Configuration
@ComponentScan("com")
@EnableWebMvc
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //-----------------------------------------------------------------------------------------------------
    @Bean (name = "orderService")
    public OrderService getOrderService(){
        return new OrderService();
    }

    @Bean (name = "orderDAO")
    public OrderDAO getOrderDAO(){
        return new OrderDAO();
    }

    //-----------------------------------------------------------------------------------------------------
    @Bean (name = "service")
    @Scope("prototype")
    public Service getService(){
        List<String> params=new ArrayList<>();
            params.add("one");
            params.add("two");
            params.add("three");
        return new Service(1,"ServiceMobile",params);
    }

    @Bean (name = "step")
    @Scope("prototype")
    public Step getStep(){
        Map<String, String> paramServiceFrom = new HashMap<>();
            paramServiceFrom.put("1","one");
            paramServiceFrom.put("2","two");
            paramServiceFrom.put("3","three");
        Map<String, String> paramsServiceTo = new HashMap<>();
            paramsServiceTo.put("1","caseb");
            paramsServiceTo.put("2","caseb");
            paramsServiceTo.put("3","caser");
        return new Step(1,getService(),getService(), paramServiceFrom,paramsServiceTo);
    }

    @Bean (name = "route")
    public Route getRoute(){
        List<Step> listStep=new ArrayList<>();
            listStep.add(getStep());
            listStep.add(getStep());
            listStep.add(getStep());
        return new Route("3",  listStep);
    }

    //-----------------------------------------------------------------------------------------------------
    @Bean (name = "itemService")
    public ItemService getItemService(){
        return new ItemService();
    }

    @Bean (name = "itemDAO")
    public ItemDAO getItemDAO(){
        return new ItemDAO();
    }
}






