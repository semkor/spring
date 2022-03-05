package com.lesson4.hw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("myService")
public class MyService {

    @Autowired
    private Utils utils;
    @Autowired
    private FileDAOConnector fileDAOConnector;


    public void put(Storage storage, File file) {
        utils.check(storage, file);
        fileDAOConnector.update(new File(file.getId(),file.getName(),file.getFormat(),file.getSize(),storage));
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        File file=fileDAOConnector.findById(id);
        utils.check(storageTo, file);
        fileDAOConnector.update(new File(file.getId(),file.getName(),file.getFormat(),file.getSize(),storageTo));
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
            List<File> files=fileDAOConnector.findByStorageId(storageFrom.getId());
            utils.check(storageTo, files);
            for(File el:files)
                fileDAOConnector.update(new File(el.getId(),el.getName(),el.getFormat(),el.getSize(),storageTo));
    }

    public void delete(Storage storage, File file) {
        fileDAOConnector.update(new File(file.getId(),file.getName(),file.getFormat(),file.getSize(),null));
    }
}
