package com.lesson2.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ItemService {

    @Autowired
    private ItemDAO itemDAO;

    public Item save(Item item) {
       return itemDAO.save(item);
    }

    public Item update(Item item) {
        return itemDAO.update(item);
    }

    public Item findById(long id) {
        return itemDAO.findById(id);
    }

    public void delete(long id) {
        itemDAO.delete(id);
    }
}
