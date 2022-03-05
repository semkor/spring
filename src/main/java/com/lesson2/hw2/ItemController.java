package com.lesson2.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@Controller
@RequestMapping("/first")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(method= RequestMethod.POST, value = "/save", produces = {MediaType.ALL_VALUE})
    public @ResponseBody String save(@RequestParam("name") String name,
                                     @RequestParam("dateCreated") Date dateCreated,
                                     @RequestParam("lastUpdatedDate") Date lastUpdatedDate,
                                     @RequestParam("description") String description){
        System.out.println("Получили параметр");
        Item item=new Item();
            item.setNames(name);
            item.setDateCreated(dateCreated);
            item.setLastUpdatedDate(lastUpdatedDate);
            item.setDescription(description);
            itemService.save(item);
        return "Save - ok";
    }


    @RequestMapping(method= RequestMethod.PUT, value = "/update", produces = {MediaType.ALL_VALUE})
    public @ResponseBody String update(@RequestParam("id") long id, @RequestParam("name") String name,
                                       @RequestParam("dateCreated") Date dateCreated,
                                       @RequestParam("lastUpdatedDate") Date lastUpdatedDate,
                                       @RequestParam("description") String description){
        System.out.println("Получили параметр");
        Item item=new Item();
            item.setId(id);
            item.setNames(name);
            item.setDateCreated(dateCreated);
            item.setLastUpdatedDate(lastUpdatedDate);
            item.setDescription(description);
        itemService.update(item);
        return "Update - ok";
    }

    @RequestMapping(method= RequestMethod.GET, value = "/find", produces = "text/plain")
    public @ResponseBody String findById(@RequestParam(value = "param")long id){
        System.out.println("Получили параметр");
        itemService.findById(id);
        return "findBy-OK";
    }

    @RequestMapping(method= RequestMethod.DELETE, value = "/delete", produces = "text/plain")
    public @ResponseBody String delete(@RequestParam(value = "param")long id){
        System.out.println("Получили параметр");
        itemService.delete(id);
        return "Delete-OK";
    }
}



