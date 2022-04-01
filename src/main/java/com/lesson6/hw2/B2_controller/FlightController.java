package com.lesson6.hw2.B2_controller;

import com.lesson6.hw2.B1_model.Flight;
import com.lesson6.hw2.B3_service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flight")
public class FlightController {
    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    //---------------------------------------------------------------------------------------------------------
    @GetMapping(value = "/find")
    public @ResponseBody String findBy(@RequestParam(value = "param") long id) {
        System.out.println(flightService.findById(id));
        return "FindById  Flight - OK";
    }

    @PostMapping(value = "/save")
    public @ResponseBody String save(@RequestBody Flight flight){
        System.out.println(flightService.save(flight));
        return "SAVE  Flight - OK";
    }

    @PutMapping(value = "/update/{id}")
    public @ResponseBody String update (@PathVariable (name = "id") long id, @RequestBody Flight flight){
        System.out.println(flightService.update(flight));
        return "UPDATE  Flight - OK";
    }

    @DeleteMapping(value = "/del")
    public @ResponseBody String delete(@RequestParam(value = "id") long id){
        flightService.delete(id);
        return "DELETE Flight - OK";
    }
}
