package com.lesson6.hw2.B1_model;

import org.hibernate.annotations.SortComparator;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="FLIGHT")
public class Flight {
    private long id;
    private Plane plane;
    private Date dateFlight;
    private String cityFrom;
    private String cityTo;

    private Collection<Passenger> passenger;

    //----------------------------------------------------------------------------------------------------
    public Flight() {
    }

    public Flight(long id, Plane plane, Date dateFlight, String cityFrom, String cityTo, Collection<Passenger> passenger) {
        this.id = id;
        this.plane = plane;
        this.dateFlight = dateFlight;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.passenger = passenger;
    }

    //----------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public long getId() {
        return id;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "PLANE_ID")
    public Plane getPlane() {
        return plane;
    }

    @Column(name="DATE_FLIGHT")
    public Date getDateFlight() {
        return dateFlight;
    }

    @Column(name="CITY_FROM")
    public String getCityFrom() {
        return cityFrom;
    }

    @Column(name="CITY_TO")
    public String getCityTo() {
        return cityTo;
    }

    @ManyToMany (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable (name="PASSENGER_FLIGHT",
            joinColumns = @JoinColumn(name = "FLIGHT_ID"),
            inverseJoinColumns = @JoinColumn (name = "PASSENGER_ID"))
    public Collection<Passenger> getPassenger() {
        return passenger;
    }

    //----------------------------------------------------------------------------------------------------
    public void setId(long id) {
        this.id = id;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setPassenger(Collection<Passenger> passenger) {
        this.passenger = passenger;
    }

    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    //----------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", plane=" + plane +
                ", dateFlight=" + dateFlight +
                ", cityForm='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", passenger=" + passenger +
                '}';
    }
}
