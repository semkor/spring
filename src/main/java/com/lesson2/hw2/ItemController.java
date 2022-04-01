package com.lesson2.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/first")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/find")
    public String findById(@RequestParam(value = "param") long id){
        itemService.findById(id);
        return "findBy-OK";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable ("id") long id){
        itemService.delete(id);
        return "Delete-OK";
    }

    @PostMapping(value = "/save")
    public String create(@RequestBody Item item){
        itemService.save(item);
        return "Save - ok";
    }

    @PutMapping(value = "/update/{id}")
    public String update (@PathVariable (name = "id") long id, @RequestBody Item item){
        itemService.update(item);
        return "Update - ok";
    }
}