package com.lesson5.hw1;

import com.lesson5.hw1.exception.NoUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemControl {
    private ItemServ itemServ;

    @Autowired
    public ItemControl(ItemServ itemServ) {
        this.itemServ = itemServ;
    }

    @GetMapping(value = "/find")
    public ResponseEntity<String> findById(@RequestParam(value = "param") long id) {
        try {
            System.out.println(itemServ.findById(id));
            return new ResponseEntity<String>("FindBy - OK!", HttpStatus.OK);
        } catch (NoUserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody Item item){
        try {
            System.out.println(itemServ.save(item));
            return new ResponseEntity<String>("Save - OK!", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not Save");
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> update (@PathVariable (name = "id") long id, @RequestBody Item item){
        try {
            System.out.println(itemServ.update(item));
            return new ResponseEntity<String>("Update - OK!", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not Update");
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam(value = "param") long id){
        try {
            itemServ.delete(id);
            return new ResponseEntity<String>("Delete - OK!", HttpStatus.OK);
        } catch (NoUserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}