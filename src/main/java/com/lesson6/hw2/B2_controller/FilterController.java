package com.lesson6.hw2.B2_controller;

import com.lesson6.hw2.B1_model.Filter;
import com.lesson6.hw2.B1_model.Flight;
import com.lesson6.hw2.B1_model.Plane;
import com.lesson6.hw2.B3_service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/filter")
public class FilterController {
    private FilterService filterService;

    @Autowired
    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    //перечень запросов cогласно фильтру
    @GetMapping(value = "/nameFilter")
    public @ResponseBody String flightsByDate(@RequestBody Filter filter) {
        System.out.println(filter);
        print(filterService.flightsByDate(filter));
        return "FlightsByDate  - OK";
    }

    //---------------------------------------------   полеты   ---------------------------------------------------------

    //cписок ТОП - 4 самых популярных рейсов по городам вылета
    @GetMapping(value = "/popularFrom")
    public @ResponseBody String mostPopularFrom() {
        Map<String,Integer> map = filterService.mostPopularFrom();
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(4).forEach(System.out::println);
        return "MostPopularFrom - OK";
    }

    //список ТОП - 4 самых  популярных рейсов по городам назначения
    @GetMapping(value = "/popularTo")
    public @ResponseBody String mostPopularTo() {
        Map<String,Integer> map = filterService.mostPopularTo();
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(4).forEach(System.out::println);
        return "MostPopularTo - OK";
    }

   //---------------------------------------------   cамолеты   --------------------------------------------------------

    //cписок cамолетов старше 20 лет на сегодняшний день
    @GetMapping(value = "/oldPlanes")
    public @ResponseBody String oldPlanes() {
        print(filterService.oldPlanes());
        return "OldPlanes - OK";
    }

    //cписок cамолетов, у которых больше 300 полетов за год
    @GetMapping(value = "/regularPlanes")
    public @ResponseBody String regularPlanes(@RequestParam(value = "year") int year) {
        System.out.println(year);
        print(filterService.regularPlanes(year));
        return "RegularPlanes - OK";
    }

    //---------------------------------------------   пассажиры   ------------------------------------------------------

    //cписок пассажиров, у которых больше 25 полетов за год
    @GetMapping(value = "/regularPassengers")
    public @ResponseBody String regularPassengers(@RequestParam(value = "year") int year) {
        print(filterService.regularPassengers(year));
        return "RegularPassengers - OK";
    }

    //---------------------------------------------   дополнительно   --------------------------------------------------
    private <T> void print(List<T> list){
        for (T el:list){
            System.out.println(el);
        }
    }
}
