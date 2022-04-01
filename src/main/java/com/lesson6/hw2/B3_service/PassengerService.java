package com.lesson6.hw2.B3_service;

import com.lesson6.hw2.B1_model.Passenger;
import com.lesson6.hw2.B1_model.Plane;
import com.lesson6.hw2.B4_dao.PassengerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private PassengerDAO passengerDAO;

    @Autowired
    public PassengerService(PassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;
    }

    //---------------------------------------------------------------------------------------------------------
    public Passenger findById(long id){ return passengerDAO.findById(id);}

    public Passenger save(Passenger passenger){
        return passengerDAO.save(passenger);
    }

    public Passenger update(Passenger passenger){
        return passengerDAO.update(passenger);
    }

    public void delete(long id){
        passengerDAO.delete(id);
    }

    //---------------------------------------------------------------------------------------------------------

    public List<Passenger> findBySQL(String sql, String year){
        return passengerDAO.findByFilter(sql, year);
    }
}
