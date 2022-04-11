package com.lesson7.hw.B2_controller;

import com.lesson7.hw.B1_model.Filter;
import com.lesson7.hw.B1_model.Person;
import com.lesson7.hw.B3_services.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller ("filterCon")
@RequestMapping("/filters")
public class FilterController {
    private FilterService filterService;

    @Autowired
    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    //------------------------------------ фильтр на базовой странице --------------------------------------------------
    @GetMapping(value = "/execute")
    public String flightsByDate(@ModelAttribute Filter filter,
                                @ModelAttribute ("personEmpty") Person person,
                                @ModelAttribute ("filterEmpty") Filter newFilter,
                                Model model) {
            model.addAttribute("articleAll", filterService.articleByFilter(filter));
            return "lesson7.hw/index";
        }
}
