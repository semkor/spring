package com.lesson6.hw2.B2_controller;

import com.lesson6.hw2.B1_model.Flight;
import com.lesson6.hw2.B1_model.Passenger;
import com.lesson6.hw2.B3_service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
    private PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    //---------------------------------------------------------------------------------------------------------
    @GetMapping(value = "/find")
    public @ResponseBody
    String findBy(@RequestParam(value = "param") long id) {
        Passenger passenger=passengerService.findById(id);
        System.out.println(passengerService.findById(id));
        System.out.println(passenger.getFlight());
        return "FindById  Passenger - OK";
    }

    @PostMapping(value = "/save")
    public @ResponseBody String save(@RequestBody Passenger passenger){
        System.out.println(passengerService.save(passenger));
        return "SAVE  Passenger - OK";
    }

    @PutMapping(value = "/update/{id}")
    public @ResponseBody String update (@PathVariable (name = "id") long id, @RequestBody Passenger passenger){
        System.out.println(passengerService.update(passenger));
        return "UPDATE  Passenger - OK";
    }

    @DeleteMapping(value = "/del")
    public @ResponseBody String delete(@RequestParam(value = "id") long id){
        passengerService.delete(id);
        return "DELETE Passenger - OK";
    }
}
