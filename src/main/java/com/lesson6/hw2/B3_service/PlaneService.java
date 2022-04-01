package com.lesson6.hw2.B3_service;

import com.lesson6.hw2.B1_model.Flight;
import com.lesson6.hw2.B1_model.Passenger;
import com.lesson6.hw2.B1_model.Plane;
import com.lesson6.hw2.B4_dao.PlaneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {
    private PlaneDAO planeDAO;

    @Autowired
    public PlaneService(PlaneDAO planeDAO) {
        this.planeDAO = planeDAO;
    }

    //---------------------------------------------------------------------------------------------------------
    public Plane findById(long id){
        return planeDAO.findById(id);
    }

    public Plane save(Plane plane){
        return planeDAO.save(plane);
    }

    public Plane update(Plane plane){
        return planeDAO.update(plane);
    }

    public void delete(long id){
        planeDAO.delete(id);
    }

    //----------------------------------------------------------------------------------------------------------

    public List<Plane> findBySQL(String sql){
        return planeDAO.findByFilter(sql);
    }

    public List<Plane> findBySQL(String sql, String year){
        return planeDAO.findByFilter(sql, year);
    }
}
