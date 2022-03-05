package com.lesson3.hw1;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "FILETWO")
public class File implements Serializable {
    private long id;
    private String name;
    private String format;
    private long size;
    private Storage storage;

    public File() {
    }

    public File(long id, String name, String format, long size, Storage storage) {
        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;
        this.storage = storage;
    }

    //--------------------------------------------- GET----------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public long getId() {
        return id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    @Column(name="FORMAT")
    public String getFormat() {
        return format;
    }

    @Column(name="SIZE")
    public long getSize() {
        return size;
    }

    @ManyToOne
    @JoinColumn(name = "STORAGE_ID")
    public Storage getStorage() {
        return storage;
    }

    //--------------------------------------------- SET----------------------------------------
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
