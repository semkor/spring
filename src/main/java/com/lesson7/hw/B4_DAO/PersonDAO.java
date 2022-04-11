package com.lesson7.hw.B4_DAO;

import com.lesson7.hw.B1_model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    //---------------------------------------------------------------------------------------------------------
    public Person findById(long id) {
        return entityManager.find(Person.class, new Long(id));
    }

    public Person save(Person person) {
        entityManager.persist(person);
        entityManager.flush();
        return person;
    }

    public Person update(Person person) {
        entityManager.merge(person);
        return person;
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    //---------------------------------------------------------------------------------------------------------
    public Person examLogin(String sql, String login, String password) {
        Person person = null;
            try {
                person = (Person) entityManager.createNativeQuery(sql, Person.class)
                        .setParameter(1, login)
                        .setParameter(2, password)
                        .getSingleResult();
            } catch (NoResultException e) {}
        return person;
    }
}
