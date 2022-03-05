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

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//@Configuration
//@ComponentScan("com")
//@PropertySource("classpath:lesson.properties") - пример для указания фиксированных данных
public class MyConfig {
//
//    @Bean (name = "orderService")
//    public OrderService getOrderService(){
//        return new OrderService();
//    }
//
//    @Bean (name = "orderDAO")
//    public OrderDAO getOrderDAO(){
//        return new OrderDAO();
//    }
////-----------------------------------------------------------------------------------------------------
//    @Bean (name = "service")
//    public Service getService(){
//        List<String> params=new ArrayList<>();
//            params.add("one");
//        return new Service(1,"some",params);
//    }
//
//    @Bean (name = "step")
//    public Step getStep(){
//        return new Step(1, getService(), getService(), new TreeMap<>(),new TreeMap<>());
//    }
//
//    @Bean (name = "route")
//    public Route getRoute(){
//        List<Step> listStep=new ArrayList<>();
//            listStep.add(getStep());
//        return new Route("1",  listStep);
//    }
//
////-----------------------------------------------------------------------------------------------------
//    @Bean (name = "itemService")
//    public ItemService getItemService(){
//        return new ItemService();
//    }
//
//    @Bean (name = "itemDAO")
//    public ItemDAO getItemDAO(){
//        return new ItemDAO();
//    }
}
