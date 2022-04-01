package com.lesson5.hw1;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Item findById(long id){
        return entityManager.find(Item.class,new Long(id));
    }

    public Item save(Item item){
        entityManager.persist(item);
        return item;
    }

    public Item update(Item item){
        entityManager.merge(item);
        return item;
    }

    public void delete(long id){
        entityManager.remove(findById(id));
    }
}
