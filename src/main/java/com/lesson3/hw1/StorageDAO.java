package com.lesson3.hw1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Component ("storagesDAO")
public class StorageDAO implements StorageDAOConnector{
    private SessionFactory sessionFactory;
    private Session session = null;
    private Transaction tr = null;

    public Storage save(Storage storage){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
                session.save(storage);
            tr.commit();
            System.out.println("Save is done");
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.out.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return storage;
    }

    public Storage update(Storage storage){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
                session.update(storage);
            tr.commit();
            System.out.println("Update is done");
        } catch (HibernateException e) {
            System.err.println("Update is failed");
            System.out.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return storage;
    }

    public Storage findById(long id){
        Storage storage=null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
                storage = (Storage) session.load(Storage.class,id);
            tr.commit();
            System.out.println("Find By ID is done");
        } catch (HibernateException | NoResultException e) {
            System.err.println("Find By ID is failed");
            System.out.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return storage;
    }

    public void delete(long id){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Storage storage = (Storage) session.load(Storage.class,id);
            if (storage != null)
                session.delete(storage);
            tr.commit();
            System.out.println("Delete is done");
        } catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.out.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    //---------------------------------------------------------------------------------------------------------------------
    public SessionFactory createSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
