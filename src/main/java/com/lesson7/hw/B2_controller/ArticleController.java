package com.lesson7.hw.B2_controller;

import com.lesson7.hw.B0.ENUM.CurrencyPrice;
import com.lesson7.hw.B0.ENUM.Subcategory;
import com.lesson7.hw.B1_model.Article;
import com.lesson7.hw.B1_model.Filter;
import com.lesson7.hw.B1_model.Person;
import com.lesson7.hw.B3_services.ArticleService;
import com.lesson7.hw.B3_services.FilterService;
import com.lesson7.hw.B3_services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private ArticleService articleService;
    private PersonService personService;
    private FilterService filterService;

    @Autowired
    public ArticleController(ArticleService articleService, PersonService personService, FilterService filterService) {
        this.articleService = articleService;
        this.personService = personService;
        this.filterService = filterService;
    }

    //------------------------------------------- базовая страница  ----------------------------------------------------
    @GetMapping
    public String index(@ModelAttribute ("personEmpty") Person person, Model model) {
            model.addAttribute("filterEmpty", new Filter());
            model.addAttribute("articleAll", filterService.articleByFilter(null));
        return "lesson7.hw/index";
    }

    //-----------------------------  базовая страница после входа в аккаунт  -------------------------------------------
    @GetMapping(value = "/account/{id}")
    public String getAccount(@PathVariable ("id") long id, Model model) {
            model.addAttribute("personFull",personService.findById(id));
            model.addAttribute("articleAccount", articleService.findByAccount(id));
        return "lesson7.hw/article";
    }

    //-------------------------------------- добавление нового объявления   --------------------------------------------
    @GetMapping(value = "/add/{id}")
    public String getArticlesPerson(@ModelAttribute ("articleEmpty") Article article, @PathVariable ("id") long id, Model model) {
            model=addModel(model);
                article.setPerson(personService.findById(id));
                article.setDateFrom(conversionDate());
                article.setDateTo(conversionDate());
        return "lesson7.hw/newArticles";
    }

    @PostMapping(value = "/add/save")
    public String save(@ModelAttribute ("articleEmpty") @Valid Article article, BindingResult bindingResult, Model model){
            if(bindingResult.hasErrors()){
                model=addModel(model);
                return "lesson7.hw/newArticles";
            }
            articleService.save(article);
            model.addAttribute("id", article.getPerson().getId());
        return "redirect:/article/account/{id}";
    }

    //-------------------------------------- обновление текущего объявления   ------------------------------------------
    @GetMapping(value = "/update/{id}")
    public String getUpdatingArticle(@PathVariable("id") long id, Model model) {
            model=addModel(model);
            model.addAttribute("articleFull",articleService.findById(id));
        return "lesson7.hw/updateArticle";
    }

    @PatchMapping(value = "/update/save")
    public String update(@ModelAttribute ("articleFull") @Valid Article article, BindingResult bindingResult, Model model) {
            if(bindingResult.hasErrors()){
                model=addModel(model);
                return "lesson7.hw/updateArticle";
            }
            articleService.update(article);
            model.addAttribute("id", article.getPerson().getId());
        return "redirect:/article/account/{id}";
    }

    //---------------------------------------- удаление текущего объявления   ------------------------------------------

    @DeleteMapping(value = "/del/{id}/{idPerson}")
    public String delete(@PathVariable("id") long id, @PathVariable("idPerson") long idPerson){
                articleService.delete(id);
            return "redirect:/article/account/{idPerson}";
    }

    //-------------------------------------- добавление SELECT в MODEL  ------------------------------------------------
    public Model addModel(Model model){
            model.addAttribute("allSubcategory", Arrays.asList(Subcategory.ALL));
            model.addAttribute("allCurrencyPrice", Arrays.asList(CurrencyPrice.ALL));
        return model;
    }

    //------------------------------------------ разное   --------------------------------------------------------------
    private Date conversionDate(){
        Date date = null;
        try{
            date=new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2022");
        }catch (ParseException e){}
    return date;
    }
}
