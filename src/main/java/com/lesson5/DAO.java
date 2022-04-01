package com.lesson5;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DAO {

    @PersistenceContext                             //анотация связывает entityManager с Bean Spring
    private EntityManager entityManager;

    public Item save(Item item){
        entityManager.persist(item);
        return item;
    }
}
