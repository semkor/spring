package com.lesson6.hw1;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ITEM2")
public class Item implements Serializable {
    private Long id;
    private String name;
    private Date dateCreated;
    private Date lastUpdatedDate;
    private String description;

    public Item() {
    }

    public Item(Long id, String name, Date dateCreated, Date lastUpdatedDate, String description) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.lastUpdatedDate = lastUpdatedDate;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    @Column(name="DATE_CREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    @Column(name="LAST_UPDATE_DATE")
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", description='" + description + '\'' +
                '}';
    }
}
