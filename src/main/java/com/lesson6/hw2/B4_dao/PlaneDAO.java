package com.lesson6.hw2.B4_dao;

import com.lesson6.hw2.B1_model.Flight;
import com.lesson6.hw2.B1_model.Plane;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PlaneDAO {

    @PersistenceContext
    private EntityManager entityManager;

    //---------------------------------------------------------------------------------------------------------
    public Plane findById(long id) {
        return entityManager.find(Plane.class, new Long(id));
    }

    public Plane save(Plane plane) {
        entityManager.persist(plane);
        entityManager.flush();
        return plane;
    }

    public Plane update(Plane plane) {
        entityManager.merge(plane);
        return plane;
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }
    //-----------------------------------------------------------------------------------------------------------

    public List<Plane> findByFilter(String sql) {
        return entityManager.createNativeQuery(sql,Plane.class).getResultList();
    }

    public List<Plane> findByFilter(String sql, String year) {
        return entityManager.createNativeQuery(sql,Plane.class).setParameter(1,year).getResultList();
    }
}
