package com.lesson7.hw.B1_model;

public class Filter {
    private String category;
    private String city;
    private String context;

    //-----------------------------------------------------------------------------------------------------------------

    public Filter() {
    }

    public Filter(String category, String city, String context) {
        this.category = category;
        this.city = city;
        this.context = context;
    }

//-----------------------------------------------------------------------------------------------------------------

    public String getCategory() { return category; }

    public String getCity() {
        return city;
    }

    public String getContext() {
        return context;
    }

//-----------------------------------------------------------------------------------------------------------------

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "category='" + category + '\'' +
                ", city='" + city + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
