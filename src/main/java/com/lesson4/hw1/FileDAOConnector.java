package com.lesson4.hw1;

import java.util.List;

public interface FileDAOConnector {
    File save(File file);

    File update(File file);

    List<File> update(List<File> files);

    File findById(long id);

    List<File> findByStorageId(long id);

    void delete(long id);
}
