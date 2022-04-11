package com.lesson7.hw.B3_services;

import com.lesson7.hw.B1_model.Article;
import com.lesson7.hw.B4_DAO.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleService {
    private ArticleDAO articleDAO;

    @Autowired
    public ArticleService(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    //---------------------------------------------------------------------------------------------------------
    @Value("${sqlExecute.sqlAccount}")
    private String sqlAccount;

    //---------------------------------------------------------------------------------------------------------

    public Article findById(long id){
        return articleDAO.findById(id);
    }

    public Article save(Article article){
        return articleDAO.save(article);
    }

    public Article update(Article article){
        return articleDAO.update(article);
    }

    public void delete(long id){
        articleDAO.delete(id);
    }

    //---------------------------------------------------------------------------------------------------------
    public List<Article> findByAccount(long id){
        return findByFilter(sqlAccount,Long.toString(id));
    }

    public List<Article> findByFilter(String sql){
        return articleDAO.findByFilter(sql);
    }

    public List<Article> findByFilter(String sql, String searchName){
        return articleDAO.findByFilter(sql,searchName);
    }

    public List<Article> findByFilter(String sql, String firstName, String secondName){
        return articleDAO.findByFilter(sql,firstName, secondName);
    }

    public List<Article> findByFilter(String sql, String firstName, String secondName, String thirdName){
        return articleDAO.findByFilter(sql,firstName, secondName, thirdName);
    }
}
