package com.lesson6.hw2.B2_controller;

import com.lesson6.hw2.B1_model.Plane;
import com.lesson6.hw2.B3_service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/plane")
public class PlaneController {
    private PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    //---------------------------------------------------------------------------------------------------------
    @GetMapping(value = "/find")
    public @ResponseBody
    String findBy(@RequestParam(value = "param") long id) {
        System.out.println(planeService.findById(id));
        return "FindById  Passenger - OK";
    }

    @PostMapping(value = "/save")
    public @ResponseBody String save(@RequestBody Plane plane){
        System.out.println(planeService.save(plane));
        return "SAVE  Passenger - OK";
    }

    @PutMapping(value = "/update/{id}")
    public @ResponseBody String update (@PathVariable (name = "id") long id, @RequestBody Plane plane){
        System.out.println(planeService.update(plane));
        return "UPDATE  Passenger - OK";
    }

    @DeleteMapping(value = "/del")
    public @ResponseBody String delete(@RequestParam(value = "id") long id){
        planeService.delete(id);
        return "DELETE Passenger - OK";
    }
}
