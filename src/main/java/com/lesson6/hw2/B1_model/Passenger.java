package com.lesson6.hw2.B1_model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="PASSENGER")
public class Passenger {
    private long id;
    private String lastName;
    private String nationality;
    private Date dateOfBirth;
    private String passportCode;

    private Collection<Flight> flight;

    //----------------------------------------------------------------------------------------------------
    public Passenger() {
    }

    public Passenger(long id, String lastName, String nationality, Date dateOfBirth, String passportCode, Collection<Flight> flight) {
        this.id = id;
        this.lastName = lastName;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.passportCode = passportCode;
        this.flight = flight;
    }

    //----------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public long getId() {
        return id;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @Column(name="NATIONALITY")
    public String getNationality() {
        return nationality;
    }

    @Column(name="DATE_OF_BIRTH")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Column(name="PASSPORT_CODE")
    public String getPassportCode() {
        return passportCode;
    }

//    @ManyToMany (mappedBy = "passenger")
    @ManyToMany (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable (name="PASSENGER_FLIGHT",
                joinColumns = @JoinColumn(name = "PASSENGER_ID"),
                inverseJoinColumns = @JoinColumn (name = "FLIGHT_ID"))
    public Collection<Flight> getFlight() {
        return flight;
    }

    //----------------------------------------------------------------------------------------------------
    public void setId(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassportCode(String passportCode) {
        this.passportCode = passportCode;
    }

    public void setFlight(Collection<Flight> flight) {
        this.flight = flight;
    }

    //----------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportCode='" + passportCode + '\'' +
                '}';
    }
}
