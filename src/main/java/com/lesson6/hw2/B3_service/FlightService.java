package com.lesson6.hw2.B3_service;

import com.lesson6.hw2.B1_model.Flight;
import com.lesson6.hw2.B4_dao.FlightDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class FlightService {
    private FlightDAO flightDAO;

    @Autowired
    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    //---------------------------------------------------------------------------------------------------------
    public Flight findById(long id){
        return flightDAO.findById(id);
    }

    public Flight save(Flight flight){
        return flightDAO.save(flight);
    }

    public Flight update(Flight flight){
        return flightDAO.update(flight);
    }

    public void delete(long id){
        flightDAO.delete(id);
    }

    //---------------------------------------------------------------------------------------------------------

    public Map<String,Integer> findBySQL(String sql){
        return flightDAO.findByFilterMap(sql);
    }

    public List<Flight> findBySQL(String sql, String searchName){
           return flightDAO.findByFilter(sql,searchName);
    }

    public List<Flight> findBySQL(String sql, String dateToConvert, String dateFromConvert){
        return flightDAO.findByFilter(sql,dateToConvert, dateFromConvert);
    }
}
