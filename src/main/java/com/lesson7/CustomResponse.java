package com.lesson7;

import java.util.Date;

public class CustomResponse {
    private Long id;
    private Long timePasse;
    private Date date;

    public CustomResponse() {
    }

    public CustomResponse(Long id, Long timePasse, Date date) {
        this.id = id;
        this.timePasse = timePasse;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getTimePasse() {
        return timePasse;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimePasse(Long timePasse) {
        this.timePasse = timePasse;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
