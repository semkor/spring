package com.lesson3.hw1;

import org.springframework.stereotype.Component;

public interface StorageDAOConnector {
    Storage save(Storage storage);

    Storage update(Storage storage);

    Storage findById(long id);

    void delete(long id);
}
