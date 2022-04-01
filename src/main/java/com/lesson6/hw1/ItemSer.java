package com.lesson6.hw1;

import com.lesson5.hw1.exception.NoUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemSer {
    private ItemD itemD;

    @Autowired
    public ItemSer(ItemD itemD) {
        this.itemD = itemD;
    }

    public Item save(Item item){
        return itemD.save(item);
    }

    public Item update(Item item){
        return itemD.update(item);
    }

    public Item findById(long id) throws NoUserException {
        Item item= itemD.findById(id);
        if(item == null)
            throw new NoUserException("User with this id = " + id + " does not exist");
        return item;
    }

    public void delete(long id) throws NoUserException {
        if(itemD.findById(id) == null)
            throw new NoUserException("User with this id = " + id + " does not exist");
        itemD.delete(id);
    }

    @Transactional
    public void deleteAll(String name) {
        List<Item> list = itemD.findByName(name);
        for (Item el : list) {
            itemD.delete(el.getId());
        }
    }
}
