package com.lesson6.hw2.B4_dao;

import com.lesson6.hw2.B1_model.Flight;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
@Transactional
public class FlightDAO {

    @PersistenceContext
    private EntityManager entityManager;

    //---------------------------------------------------------------------------------------------------------
    public Flight findById(long id) {
        return entityManager.find(Flight.class, new Long(id));
    }

    public Flight save(Flight flight) {
        entityManager.persist(flight);
        entityManager.flush();
        return flight;
    }

    public Flight update(Flight flight) {
        entityManager.merge(flight);
        return flight;
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    //---------------------------------------------------------------------------------------------------------

    public   Map<String,Integer>  findByFilterMap(String sql) {
                Map<String,Integer> map = entityManager.createQuery(sql, Tuple.class)
                .getResultList().stream().collect(
                        Collectors.toMap(
                                tuple -> ((String) tuple.get("city")),
                                tuple -> ((Number) tuple.get("count")).intValue()));
             return map;
        }

        public List<Flight> findByFilter(String sql, String searchName) {
            List<Flight> list =entityManager.createNativeQuery(sql,Flight.class)
                    .setParameter(1,searchName)
                    .getResultList();
            return list;
        }

        public List<Flight> findByFilter(String sql, String dateToConvert, String dateFromConvert) {
            List<Flight> list =entityManager.createNativeQuery(sql,Flight.class)
                    .setParameter(1,dateToConvert)
                    .setParameter(2,dateFromConvert)
                    .getResultList();
            return list;
        }
    }
