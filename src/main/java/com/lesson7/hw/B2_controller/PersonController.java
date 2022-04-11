package com.lesson7.hw.B2_controller;

import com.lesson7.hw.B0.ENUM.Sex;
import com.lesson7.hw.B1_model.Person;
import com.lesson7.hw.B3_services.FilterService;
import com.lesson7.hw.B3_services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;
    private ArticleController articleController;

    @Autowired
    public PersonController(PersonService personService, FilterService filterService, ArticleController articleController) {
        this.personService = personService;
        this.articleController = articleController;
    }

    //-----------------------------  форма  для создания аккаунта ------------------------------------------------------
    @GetMapping(value = "/new")
    public String newPerson(@ModelAttribute ("personEmpty") Person person, Model model) {
            model.addAttribute("allTypes", Arrays.asList(Sex.ALL));
        return "lesson7.hw/newPerson";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute ("personEmpty") @Valid Person person, BindingResult bindingResult, Model model){
             if(bindingResult.hasErrors()){
                 model.addAttribute("allTypes", Arrays.asList(Sex.ALL));
                 return "lesson7.hw/newPerson";
             }
            personService.save(person);
        return "redirect:/article";
    }

    //-----------------------------  проверка пароля и вход в аккаунт --------------------------------------------------
    @PostMapping(value = "/account")
    public String account(@ModelAttribute ("personEmpty") Person person, Model model){
        if (person.getLogin().isEmpty() || person.getPassword().isEmpty()) {
                //TODO проверку наверное нужно делать через AOP
                System.err.println("Не правильно заполнено поле login или password");
                return "redirect:/article";
        }

        Person personBase = personService.examLogin (person.getLogin(),person.getPassword());
        if(personBase != null){
                model.addAttribute("id", personBase.getId());
            return "redirect:/article/account/{id}";
        }

            //TODO не знаю, как вывести ошибку и совместно страницу для пользователя
            System.err.println("Такого пользователя нет");
        return "redirect:/article";
    }

    //------------------------------------------------------------------------------------------------------------------
    @GetMapping(value = "/find")
    public @ResponseBody String findBy(@RequestParam(value = "param") long id) {
        System.out.println(personService.findById(id));
        return "FindById  Passenger - OK";
    }

    @DeleteMapping(value = "/del")
    public @ResponseBody String delete(@RequestParam(value = "id") long id){
            personService.delete(id);
        return "DELETE Passenger - OK";
    }
}
