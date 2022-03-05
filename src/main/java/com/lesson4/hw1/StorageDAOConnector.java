package com.lesson4.hw1;

public interface StorageDAOConnector {
    Storage save(Storage storage);

    Storage update(Storage storage);

    Storage findById(long id);

    void delete(long id);
}
