package com.lesson5.hw1;

import com.lesson5.hw1.exception.NoUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServ {
    private ItemRepository itemRepository;

    @Autowired
    public ItemServ(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findById(long id) throws NoUserException {
        Item item= itemRepository.findById(id);
        if(item == null)
            throw new NoUserException("User with this id = " + id + " does not exist");
        return item;
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public Item update(Item item){
        return itemRepository.update(item);
    }

    public void delete(long id) throws NoUserException {
        if(itemRepository.findById(id) == null)
            throw new NoUserException("User with this id = " + id + " does not exist");
        itemRepository.delete(id);
    }
}
