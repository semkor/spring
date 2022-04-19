package com.lesson2.hw2;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ItemDAO {

    @PersistenceContext
    private EntityManager entityManager;

    //---------------------------------------------------------------------------------------------------------
    @Transactional
    public Item findById(long id) {
        return entityManager.find(Item.class, new Long(id));
    }

    @Transactional
    public Item save(Item item) {
        entityManager.persist(item);
        entityManager.flush();
        return item;
    }

    @Transactional
    public Item update(Item item) {
        entityManager.merge(item);
        return item;
    }

    @Transactional
    public void delete(long id) {
        entityManager.remove(findById(id));
    }
}
