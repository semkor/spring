package com.lesson7.hw.B3_services;

import com.lesson7.hw.B1_model.Article;
import com.lesson7.hw.B1_model.Person;
import com.lesson7.hw.B4_DAO.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonDAO personDAO;

    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    //---------------------------------------------------------------------------------------------------------
    @Value("${sqlExecute.sqlLogin}")
    private String sqlLogin;


    //---------------------------------------------------------------------------------------------------------
    public Person findById(long id){
        return personDAO.findById(id);
    }

    public Person save(Person person){
        return personDAO.save(person);
    }

    public Person update(Person person){
        return personDAO.update(person);
    }

    public void delete(long id){
        personDAO.delete(id);
    }

    //---------------------------------------------------------------------------------------------------------

    public Person examLogin(String login,String password){
        return personDAO.examLogin(sqlLogin, login, password);
    }
}
