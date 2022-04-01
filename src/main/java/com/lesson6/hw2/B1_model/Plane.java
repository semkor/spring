package com.lesson6.hw2.B1_model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="PLANE")
public class Plane {
    private Long id;
    private String model;
    private String code;
    private Date yearProduced;
    private double avgFuelConsumption;
    private Collection<Flight> flight;

    //----------------------------------------------------------------------------------------------------
    public Plane() {
    }

    public Plane(Long id, String model, String code, Date yearProduced, double avgFuelConsumption, Collection<Flight> flight) {
        this.id = id;
        this.model = model;
        this.code = code;
        this.yearProduced = yearProduced;
        this.avgFuelConsumption = avgFuelConsumption;
        this.flight = flight;
    }

    //----------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return id;
    }

    @Column(name="MODEL")
    public String getModel() {
        return model;
    }

    @Column(name="CODE")
    public String getCode() {
        return code;
    }

    @Column(name="YEAR_PRODUCED")
    public Date getYearProduced() {
        return yearProduced;
    }

    @Column(name="AVG_FUEL_CONSUMPTION")
    public double getAvgFuelConsumption() {
        return avgFuelConsumption;
    }

    @OneToMany (mappedBy = "plane", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    public Collection<Flight> getFlight() {
        return flight;
    }

    //----------------------------------------------------------------------------------------------------
    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setYearProduced(Date yearProduced) {
        this.yearProduced = yearProduced;
    }

    public void setAvgFuelConsumption(double avgFuelConsumption) {
        this.avgFuelConsumption = avgFuelConsumption;
    }

    public void setFlight(Collection<Flight> flight) {
        this.flight = flight;
    }

    //----------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", code='" + code + '\'' +
                ", yearProduced=" + yearProduced +
                ", avgFuelConsumption=" + avgFuelConsumption +
                '}';
    }
}
