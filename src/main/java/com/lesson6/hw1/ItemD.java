package com.lesson6.hw1;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional  //(value = "testTransaction", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,
                // readOnly = true,timeout = 1, rollbackOn = "IOException")
public class ItemD {
    @PersistenceContext
    private EntityManager entityManager;

    public Item save(Item item) {
        entityManager.persist(item);
        entityManager.flush();
        return item;
    }

    public Item update(Item item) {
        entityManager.merge(item);
        return item;
    }

    public Item findById(long id) {
        return entityManager.find(Item.class, new Long(id));
    }

    public List<Item> findByName(String name) {
        List<Item> item = entityManager.createNativeQuery("SELECT * FROM ITEM2 WHERE NAME LIKE ?1", Item.class)
                .setParameter(1, ("%" + name + "%"))
                .getResultList();
        return item;
    }

    public void delete(long id) throws RuntimeException {
        entityManager.remove(findById(id));
    }
}