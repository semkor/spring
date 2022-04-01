package com.lesson6.hw1;

import com.lesson5.hw1.exception.NoUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class ItemCon {
    private ItemSer itemSer;

    @Autowired
    public ItemCon(ItemSer itemSer) {
        this.itemSer = itemSer;
    }

    @GetMapping(value = "/find")
    public ResponseEntity<String> findById(@RequestParam(value = "param") long id) {
        try {
            System.out.println(itemSer.findById(id));
            return new ResponseEntity<String>("FindBy - OK!", HttpStatus.OK);
        } catch (NoUserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody Item item){
        try {
            System.out.println(itemSer.save(item));
            return new ResponseEntity<String>("Save - OK!", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not Save");
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> update (@PathVariable (name = "id") long id, @RequestBody Item item){
        try {
            System.out.println(itemSer.update(item));
            return new ResponseEntity<String>("Update - OK!", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not Update");
        }
    }

    @DeleteMapping(value = "/del")
    public ResponseEntity<String> delete(@RequestParam(value = "id") long id){
        try {
            itemSer.delete(id);
            return new ResponseEntity<String>("Delete - OK!", HttpStatus.OK);
        } catch (NoUserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity<String> deleteAll(@RequestParam(value = "name") String name){
        itemSer.deleteAll(name);
        return new ResponseEntity<String>("DeleteAll - OK!", HttpStatus.OK);
    }
}