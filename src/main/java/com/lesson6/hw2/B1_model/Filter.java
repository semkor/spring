package com.lesson6.hw2.B1_model;

import java.util.Date;

public class Filter {
    private Date dateFlight;
    private Date dateTo;
    private Date dateFrom;
    private String cityTo;
    private String cityFrom;
    private String planeModel;

    //------------------------------------------------------------------------------------------------------------------

    public Filter() {
    }

    public Filter(Date dateFlight, Date dateTo, Date dateFrom, String cityTo, String cityFrom, String planeModel) {
        this.dateFlight = dateFlight;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;
        this.cityTo = cityTo;
        this.cityFrom = cityFrom;
        this.planeModel = planeModel;
    }

    //------------------------------------------------------------------------------------------------------------------

    public Date getDateFlight() {
        return dateFlight;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public String getPlaneModel() {
        return planeModel;
    }


    //------------------------------------------------------------------------------------------------------------------

    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public void setCityForm(String cityForm) {
        this.cityFrom = cityFrom;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Filter{" +
                "dateFlight=" + dateFlight +
                ", dateTo=" + dateTo +
                ", dateFrom=" + dateFrom +
                ", cityTo='" + cityTo + '\'' +
                ", cityFrom='" + cityFrom + '\'' +
                ", planeModel=" + planeModel +
                '}';
    }
}
