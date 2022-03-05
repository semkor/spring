package com.lesson4.hw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component("utils")
public class Utils {

    @Autowired
    private FileDAOConnector fileDAOConnector;

    public void check(Storage storage, File file) {
        List<File> files =new ArrayList<>();
            files.add(file);
        check(storage, files);
    }


    public void check(Storage storage, List<File> file) {
        try {
            checkFormat(storage.getId(), storage.getFormatsSupported().split(","), file);
            checkSize(storage.getId(), storage.getStorageMaxSize(), file);
        } catch (RuntimeException e) {
            System.err.println("Error:" + e.getMessage());
            System.exit(0);
        }
    }

    //-может ли Storage хранить  файлы такого формата
    public boolean checkFormat(long storageId, String[] fomatSupported, List<File> file) throws RuntimeException {
        System.out.println("начало чек формат");
        int count = 0;
        for (File el : file) {
            int countPlace = 0;
            for (String els : fomatSupported) {
                if (el.getFormat().equalsIgnoreCase(els))
                    countPlace++;
            }
            if (countPlace == 0) {
                System.err.println("Storage id - " + storageId + " files cannot be stored in the format - " + el.getFormat() + " for  file id - " + el.getId());
                count++;
            }
        }
        if (count > 0)
            throw new RuntimeException("Storage id: " + storageId + " files cannot be stored in the format ");
        return true;
    }


    //-хватит ли размера Storage для перенесения файлов
    public boolean checkSize(long storageId, long size, List<File> file) throws RuntimeException {
        long sizeAllFileStorage = 0;
        List<File> filesAll = fileDAOConnector.findByStorageId(storageId);
        for (File el : filesAll) {
            sizeAllFileStorage += el.getSize();
        }

        long sizeFile = 0;
        for (File el : file) {
            sizeFile += el.getSize();
        }

        if ((size - sizeAllFileStorage - sizeFile) < 0)
            throw new RuntimeException("Storage id: " + storageId + " there is not enough space to transfer the file." +
                    " Storage size - " + size + "   The size of all files on storage - " + sizeAllFileStorage + "   The size of the files we are transferring  - " + sizeFile);
        return true;
    }
}
