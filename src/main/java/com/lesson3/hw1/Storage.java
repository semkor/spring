package com.lesson3.hw1;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "STORAGETWO")
public class Storage implements Serializable {
    private long id;
    private String formatsSupported;
    private String storageCountry;
    private long storageMaxSize;
    private List<File> file;

    public Storage() {
    }

    public Storage(long id, String formatsSupported, String storageCountry, long storageMaxSize) {
        this.id = id;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageMaxSize = storageMaxSize;
    }

    //--------------------------------------------- GET----------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public long getId() {
        return id;
    }

    @Column(name="FORMAT_SUPPORTED")
    public String getFormatsSupported() {
        return formatsSupported;
    }

    @Column(name="STORAGE_COUNTRY")
    public String getStorageCountry() {
        return storageCountry;
    }

    @Column(name="MAX_SIZE")
    public long getStorageMaxSize() {
        return storageMaxSize;
    }

    @OneToMany (mappedBy = "storage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    public List<File> getFile() {
        return file;
    }

    //--------------------------------------------- SET----------------------------------------
    public void setId(long id) {
        this.id = id;
    }

    public void setFormatsSupported(String formatsSupported) {
        this.formatsSupported = formatsSupported;
    }

    public void setStorageCountry(String storageCountry) {
        this.storageCountry = storageCountry;
    }

    public void setStorageMaxSize(long storageMaxSize) {
        this.storageMaxSize = storageMaxSize;
    }

    public void setFile(List<File> file) {
        this.file = file;
    }
}
