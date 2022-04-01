package com.lesson6.hw2.B3_service;

import com.lesson6.hw2.B1_model.Filter;
import com.lesson6.hw2.B1_model.Flight;
import com.lesson6.hw2.B1_model.Passenger;
import com.lesson6.hw2.B1_model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FilterService {
    private FlightService flightService;
    private PlaneService planeService;
    private PassengerService passengerService;

    //---------------------------------------   SQL - запросы   --------------------------------------------------------
    @Value("${sqlExecute.sqlDateFlight}")
    private String sqlDateFlight;
    @Value("${sqlExecute.sqlDateToFrom}")
    private String sqlDateToFrom;
    @Value("${sqlExecute.sqlCityFrom}")
    private String sqlCityFrom;
    @Value("${sqlExecute.sqlCityTo}")
    private String sqlCityTo;
    @Value("${sqlExecute.sqlPlaneModel}")
    private String sqlPlaneModel;
    @Value("${sqlExecute.sqlFlightPopularTo}")
    private String  sqlFlightPopularTo;
    @Value("${sqlExecute.sqlFlightPopularFrom}")
    private String  sqlFlightPopularFrom;
    @Value("${sqlExecute.sqlPlaneOldPlanes}")
    private String  sqlPlaneOldPlanes;
    @Value("${sqlExecute.sqlPlaneRegularPlanes}")
    private String  sqlPlaneRegularPlanes;
    @Value("${sqlExecute.sqlPassengerRegularPassengers}")
    private String  sqlPassengerRegularPassengers;

    //------------------------------------------------------------------------------------------------------------------
    @Autowired
    public FilterService(FlightService flightService, PlaneService planeService, PassengerService passengerService) {
        this.flightService = flightService;
        this.planeService = planeService;
        this.passengerService = passengerService;
    }

    //---------------------------------------   распределитель   -------------------------------------------------------

    public List<Flight> flightsByDate(Filter filter) {
        List<Flight> list = null;
        if (filter.getDateFlight() != null) {
            list = filterDateFlight(filter.getDateFlight());
        } else if (filter.getDateTo() != null && filter.getDateFrom() != null) {
            list = filterDateToFrom(filter.getDateTo(), filter.getDateFrom());
        } else if (filter.getCityTo() != null) {
            list = filterCityTo(filter.getCityTo());
        } else if (filter.getCityFrom() != null) {
            list = filterCityFrom(filter.getCityFrom());
        } else if (filter.getPlaneModel() != null) {
            list = filterPlaneModel(filter.getPlaneModel());
        } else {
            System.err.println("Фильтра по такому парамметру не существует");
        }
        return list;
    }

    //---------------------------------------   полеты по фильтру   ----------------------------------------------------

    //выводить все полеты, где совпадает дата полета
    public List<Flight> filterDateFlight(Date dateFlight) {
        String dateFlights = new SimpleDateFormat("yyyy-MM-dd").format(dateFlight);
        return flightService.findBySQL(sqlDateFlight, dateFlights);
    }

    //выводить все, где совпадает промежуток времени
    public List<Flight> filterDateToFrom(Date dateTo, Date dateFrom) {
        String dateToConvert = new SimpleDateFormat("yyyy-MM-dd").format(dateTo);
        String dateFromConvert = new SimpleDateFormat("yyyy-MM-dd").format(dateFrom);
        return flightService.findBySQL(sqlDateToFrom, dateToConvert, dateFromConvert);
    }

    //выводить все полеты у кого город назначения
    public List<Flight> filterCityFrom(String cityFrom) {
        return flightService.findBySQL(sqlCityFrom, cityFrom);
    }

    //выводить все полеты у кого город отправки
    public List<Flight> filterCityTo(String cityTo){
        return flightService.findBySQL(sqlCityTo, cityTo);
    }

    //выводить все полеты у кого совпадает модель самолета
    public List<Flight> filterPlaneModel(String planeModel) {
        return flightService.findBySQL(sqlPlaneModel, planeModel);
    }

    //---------------------------------------------   полеты   ---------------------------------------------------------

    //cписок ТОП - 4 самых популярных рейсов по городам вылета
    public Map<String,Integer> mostPopularFrom() {
        return flightService.findBySQL(sqlFlightPopularFrom);
    }

    //список ТОП - 4 самых  популярных рейсов по городам назначения
    public Map<String,Integer> mostPopularTo() {
        return flightService.findBySQL(sqlFlightPopularTo);
    }

    //---------------------------------------------   cамолеты   --------------------------------------------------------

    //cписок cамолетов старше 20 лет на сегодняшний день
    public List<Plane> oldPlanes() {
        return planeService.findBySQL(sqlPlaneOldPlanes);
    }

    //cписок cамолетов, у которых больше 300 полетов за год
    public List<Plane> regularPlanes(int year) {
        return planeService.findBySQL(sqlPlaneRegularPlanes, Integer.toString(year));
    }

    //---------------------------------------------   пассажиры   ------------------------------------------------------

    //cписок пассажиров, у которых за год больше 2 полетов
    public List<Passenger> regularPassengers(int year) {
        return passengerService.findBySQL(sqlPassengerRegularPassengers, Integer.toString(year));
    }
}
