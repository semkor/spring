package com.lesson6.hw2.B4_dao;

import com.lesson6.hw2.B1_model.Passenger;
import com.lesson6.hw2.B1_model.Plane;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PassengerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    //---------------------------------------------------------------------------------------------------------
    public Passenger findById(long id) {
        return entityManager.find(Passenger.class, new Long(id));
    }

    public Passenger save(Passenger passenger) {
        entityManager.persist(passenger);
        entityManager.flush();
        return passenger;
    }

    public Passenger update(Passenger passenger) {
        entityManager.merge(passenger);
        return passenger;
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    //---------------------------------------------------------------------------------------------------------
    public List<Passenger> findByFilter(String sql, String year) {
        return entityManager.createNativeQuery(sql,Passenger.class).setParameter(1,year).getResultList();
    }
}
