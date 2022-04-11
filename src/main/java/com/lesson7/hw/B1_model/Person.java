package com.lesson7.hw.B1_model;

import com.lesson7.hw.B0.ENUM.Sex;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name="PERSON")
public class Person {
    private long id;
    @NotEmpty (message = "Name should not be empty")
    private String name;
    @NotEmpty (message = "LastName should not be empty")
    private String lastName;
    private Sex sex;
    @NotEmpty (message = "Login should not be empty")
    private String login;
    @NotEmpty (message = "Password should not be empty")
    @Size(min = 4, max = 20, message = "Password should be between 4 and 20 characters")
    private String password;

    private Collection<Article> article;

    //-----------------------------------------------------------------------------------------------------------------
    public Person() {
    }

    public Person(long id, String name, String lastName, Sex sex, String login, String password, Collection<Article> article) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.login = login;
        this.password = password;
        this.article = article;
    }

    //-----------------------------------------------------------------------------------------------------------------
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

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "SEX")
    public Sex getSex() {
        return sex;
    }

    @Column(name="LOGIN")
    public String getLogin() {
        return login;
    }

    @Column(name="PASSWORD")
    public String getPassword() {
        return password;
    }

    @OneToMany (mappedBy = "person", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    public Collection<Article> getArticle() {
        return article;
    }

    //-----------------------------------------------------------------------------------------------------------------

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setArticle(Collection<Article> article) {
        this.article = article;
    }

    //-----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", article=" + article +
                '}';
    }
}
