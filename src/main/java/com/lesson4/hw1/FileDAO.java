package com.lesson4.hw1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("fileDAO")
public class FileDAO implements FileDAOConnector {
    private SessionFactory sessionFactory;
    private Session session = null;
    private Transaction tr = null;

    public File save(File file){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
                session.save(file);
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
        return file;
    }

    public File update(File file){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
                session.update(file);
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
        return file;
    }

    public List<File> update(List<File> files){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            for(File el: files)
                session.update(el);
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
        return files;
    }

    public List<File> findByStorageId(long storageId) {
        List<File> files = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
                NativeQuery nq = session.createNativeQuery("SELECT * FROM FILETWO WHERE STORAGE_ID = ?", File.class);
                nq.setParameter(1, storageId);
                files = nq.getResultList();
            tr.commit();
            System.out.println("Find by name done");
        } catch (HibernateException e) {
            System.err.println("Find by name is failed");
            System.out.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return files;
    }

    public File findById(long id){
        File file=null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            file = (File) session.load(File.class,id);
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
        return file;
    }


    public void delete(long id){
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            File file = (File) session.get(File.class,id);
            if (file != null)
                session.delete(file);
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
