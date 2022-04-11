package com.lesson7.hw.B1_model;

import com.lesson7.hw.B0.ENUM.CurrencyPrice;
import com.lesson7.hw.B0.ENUM.Subcategory;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name="ARTICLES")
public class Article {
    private long id;
    private String category;
    private Subcategory subcategory;
    private String articleName;
    @Size(min = 0, max = 200, message = "Context should be between 200 characters")
    private String context;
    private String city;
    @Size(min = 0, max = 20, message = "Telephone should be between 20 characters")
    private String telephone;
    @Min(value =0, message = "Age should be greater than 0")
    private int price;
    private CurrencyPrice currencyPrice;
    private Date dateFrom;
    private Date dateTo;

    private Person person;

    //-----------------------------------------------------------------------------------------------------------------

    public Article() {
    }

    public Article(long id, String category, Subcategory subcategory, String articleName, String context, String city, String telephone, int price, CurrencyPrice currencyPrice, Date dateFrom, Date dateTo, Person person) {
        this.id = id;
        this.category = category;
        this.subcategory = subcategory;
        this.articleName = articleName;
        this.context = context;
        this.city = city;
        this.telephone = telephone;
        this.price = price;
        this.currencyPrice = currencyPrice;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.person = person;
    }

    //-----------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public long getId() {
        return id;
    }

    @Column(name = "CATEGORY")
    public String getCategory() {
        return category;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "SUBCATEGORY")
    public Subcategory getSubcategory() {
        return subcategory;
    }

    @Column(name = "ARTICLE_NAME")
    public String getArticleName() {
        return articleName;
    }

    @Column(name = "CONTEXT")
    public String getContext() {
        return context;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    @Column(name = "TELEPHONE")
    public String getTelephone() {
        return telephone;
    }

    @Column(name = "PRICE")
    public int getPrice() {
        return price;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCY_PRICE")
    public CurrencyPrice getCurrencyPrice() {
        return currencyPrice;
    }

    @Column(name = "DATE_FROM")
    public Date getDateFrom() {
        return dateFrom;
    }

    @Column(name = "DATE_TO")
    public Date getDateTo() {
        return dateTo;
    }

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    public Person getPerson() {
        return person;
    }

    //-----------------------------------------------------------------------------------------------------------------

    public void setId(long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCurrencyPrice(CurrencyPrice currencyPrice) {
        this.currencyPrice = currencyPrice;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    //-----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", subcategory=" + subcategory +
                ", articleName='" + articleName + '\'' +
                ", context='" + context + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", price=" + price +
                ", currencyPrice=" + currencyPrice +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
