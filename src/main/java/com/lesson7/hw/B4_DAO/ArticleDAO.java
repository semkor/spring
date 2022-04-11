package com.lesson7.hw.B4_DAO;

import com.lesson7.hw.B1_model.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    //---------------------------------------------------------------------------------------------------------
    public Article findById(long id) {
        return entityManager.find(Article.class, new Long(id));
    }

    public Article save(Article article) {
        entityManager.persist(article);
        entityManager.flush();
        return article;
    }

    public Article update(Article article) {
        entityManager.merge(article);
        return article;
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    //---------------------------------------------------------------------------------------------------------
    public List<Article> findByFilter(String sql) {
        return entityManager.createNativeQuery(sql,Article.class).getResultList();
    }

    public List<Article> findByFilter(String sql, String searchName) {
        return entityManager.createNativeQuery(sql,Article.class)
                .setParameter(1,searchName)
                .getResultList();
    }

    public List<Article> findByFilter(String sql, String firstName, String secondName) {
        return entityManager.createNativeQuery(sql,Article.class)
                .setParameter(1,firstName)
                .setParameter(2,secondName)
                .getResultList();
    }

    public List<Article> findByFilter(String sql, String firstName, String secondName, String thirdName) {
        return entityManager.createNativeQuery(sql,Article.class)
                .setParameter(1,firstName)
                .setParameter(2,secondName)
                .setParameter(3,thirdName)
                .getResultList();
    }
}
