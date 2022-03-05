package com.lesson4.hw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller ("controltwo")
public class Controllers {

    @Autowired
    private MyService myService;

    public  void put(Storage storage, File file) {
        myService.put(storage, file);
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        myService.transferFile(storageFrom, storageTo,id);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        myService.transferAll(storageFrom, storageTo);
    }

    public void delete(Storage storage, File file) {
        myService.delete(storage,file);
    }
}
