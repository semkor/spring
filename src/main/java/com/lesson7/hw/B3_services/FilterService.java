package com.lesson7.hw.B3_services;

import com.lesson7.hw.B1_model.Article;
import com.lesson7.hw.B1_model.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterService {
    private ArticleService as;

    @Autowired
    public FilterService(ArticleService as) {
        this.as = as;
    }

    //---------------------------------------   SQL - запросы   --------------------------------------------------------
    @Value("${sqlExecute.sqlFirstAll}")
    private String sqlFirstAll;
    @Value("${sqlExecute.sqlAll}")
    private String sqlAll;
    @Value("${sqlExecute.sqlCategoryCity}")
    private String sqlCategoryCity;
    @Value("${sqlExecute.sqlCityContext}")
    private String sqlCityContext;
    @Value("${sqlExecute.sqlCategoryContext}")
    private String sqlCategoryContext;
    @Value("${sqlExecute.sqlCity}")
    private String sqlCity;
    @Value("${sqlExecute.sqlCategory}")
    private String sqlCategory;
    @Value("${sqlExecute.sqlContext}")
    private String sqlContext;

    //---------------------------------------   распределитель   -------------------------------------------------------
    public List<Article> articleByFilter(Filter filter) {
        List<Article> list = null;
            if (filter == null || (filter.getCategory().isEmpty() && filter.getCity().isEmpty() && filter.getContext().isEmpty()))
                return as.findByFilter(sqlFirstAll);

            boolean category = filter.getCategory().isEmpty();
            boolean city = filter.getCity().isEmpty();
            boolean contexts = filter.getContext().isEmpty();
            String context = "%" + filter.getContext() + "%";

            if (!category && !city && !contexts)
                    list = as.findByFilter(sqlAll, filter.getCategory(), filter.getCity(), context);
        else if (!category && !city && contexts)
                    list = as.findByFilter(sqlCategoryCity, filter.getCategory(), filter.getCity());
        else if (category && !city && !contexts)
                    list = as.findByFilter(sqlCityContext, filter.getCity(), context);
        else if (!category && city && !contexts)
                    list = as.findByFilter(sqlCategoryContext, filter.getCategory(), context);
        else if (!category)
                    list = as.findByFilter(sqlCategory, filter.getCategory());
        else if (!city)
                    list = as.findByFilter(sqlCity, filter.getCity());
        else if (!contexts)
                    list = as.findByFilter(sqlContext, context);
        return list;
    }
}
