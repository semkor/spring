package com.lesson5.hw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//если ошибка метод должен возвращать соответствующий статус код и описание ошибки



@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;

    @RequestMapping(method = RequestMethod.GET, value="/save", produces = "text/plain")
    public @ResponseBody String saveItem(){
//        Item item=new Item();
//        item.setDescription("spring grom");
//        dao.save(item);
        return "ok";
    }


    @RequestMapping(method = RequestMethod.GET, value="/update", produces = "text/plain")
    public @ResponseBody String updateItem(){
//        Item item=new Item();
//        item.setDescription("spring grom");
//        dao.save(item);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.GET, value="/delete", produces = "text/plain")
    public @ResponseBody String deleteItem(){
//        Item item=new Item();
//        item.setDescription("spring grom");
//        dao.save(item);
        //если ошибка, нужно возвращать соответствующий статус код и описание ошибки
        return "ok";
    }
}



//    @RequestMapping(method= RequestMethod.POST, value = "/save", produces = {MediaType.ALL_VALUE})
//    public @ResponseBody String save(@RequestParam("name") String name,
//                                     @RequestParam("dateCreated") Date dateCreated,
//                                     @RequestParam("lastUpdatedDate") Date lastUpdatedDate,
//                                     @RequestParam("description") String description){
//        System.out.println("Получили параметр");
//        Item item=new Item();
//        item.setNames(name);
//        item.setDateCreated(dateCreated);
//        item.setLastUpdatedDate(lastUpdatedDate);
//        item.setDescription(description);
//        itemService.save(item);
//        return "Save - ok";
//    }
//
//
//    @RequestMapping(method= RequestMethod.PUT, value = "/update", produces = {MediaType.ALL_VALUE})
//    public @ResponseBody String update(@RequestParam("id") long id, @RequestParam("name") String name,
//                                       @RequestParam("dateCreated") Date dateCreated,
//                                       @RequestParam("lastUpdatedDate") Date lastUpdatedDate,
//                                       @RequestParam("description") String description){
//        System.out.println("Получили параметр");
//        Item item=new Item();
//        item.setId(id);
//        item.setNames(name);
//        item.setDateCreated(dateCreated);
//        item.setLastUpdatedDate(lastUpdatedDate);
//        item.setDescription(description);
//        itemService.update(item);
//        return "Update - ok";
//    }
//
//    @RequestMapping(method= RequestMethod.GET, value = "/find", produces = "text/plain")
//    public @ResponseBody String findById(@RequestParam(value = "param")long id){
//        System.out.println("Получили параметр");
//        itemService.findById(id);
//        return "findBy-OK";
//    }
//
//    @RequestMapping(method= RequestMethod.DELETE, value = "/delete", produces = "text/plain")
//    public @ResponseBody String delete(@RequestParam(value = "param")long id){
//        System.out.println("Получили параметр");
//        itemService.delete(id);
//        return "Delete-OK";
//    }
