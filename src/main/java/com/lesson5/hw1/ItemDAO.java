package com.lesson5.hw1;

import com.lesson5.Item;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ItemDAO {

//

    @PersistenceContext
    private EntityManager entityManager;

    public Item save(Item item){
        entityManager.persist(item);
        return item;
    }

    public Item update(Item item){
        entityManager.persist(item);
        return item;
    }

    public void delete(Item item){
        entityManager.persist(item);
    }
}
