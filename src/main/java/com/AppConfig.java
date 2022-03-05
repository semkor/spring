package com;

import com.lesson2.OrderDAO;
import com.lesson2.OrderService;
import com.lesson2.hw1.Route;
import com.lesson2.hw1.Service;
import com.lesson2.hw1.Step;
import com.lesson2.hw2.ItemDAO;
import com.lesson2.hw2.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class AppConfig {

    @Bean //для создания при работе с entityManager - связка Spring - Hibernate
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(dataSource());
            em.setPackagesToScan(new String[]{"com"});                      //где будет искать

        JpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();     //можем проставлять property
        em.setJpaVendorAdapter(vendorAdapter);
        //  em.setJpaProperties(additionalProperties());
        return em;
    }

//        Properties additionalProperties(){
//        Properties properties=new Properties();
//        properties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
//        return properties;
//    }

    @Bean   //ccылка на БД
    public DriverManagerDataSource dataSource(){
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://database-1.c0nqcnerv9wp.us-east-1.rds.amazonaws.com:3306/database_name");
            dataSource.setUsername("maven");
            dataSource.setPassword("1291328diMA");
        return dataSource;
    }

//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }

//-------------------------------стандартные - работает с транзакциями ---------------------------------
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }


//--------------------------------------------------------------------------------------------------------------------
// -------------------------------------------  данные из lesson4.hw2 ------------------------------------------------
    @Bean (name = "orderService")
    public OrderService getOrderService(){
        return new OrderService();
    }

    @Bean (name = "orderDAO")
    public OrderDAO getOrderDAO(){
        return new OrderDAO();
    }
    //-----------------------------------------------------------------------------------------------------
    @Bean (name = "service")
    public Service getService(){
        List<String> params=new ArrayList<>();
        params.add("one");
        return new Service(1,"some",params);
    }

    @Bean (name = "step")
    public Step getStep(){
        return new Step(1, getService(), getService(), new TreeMap<>(),new TreeMap<>());
    }

    @Bean (name = "route")
    public Route getRoute(){
        List<Step> listStep=new ArrayList<>();
        listStep.add(getStep());
        return new Route("1",  listStep);
    }

    //-----------------------------------------------------------------------------------------------------
    @Bean (name = "itemService")
    public ItemService getItemService(){
        return new ItemService();
    }

    @Bean (name = "itemDAO")
    public ItemDAO getItemDAO(){
        return new ItemDAO();
    }
}
