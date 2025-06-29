/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import model.Request;

/**
 *
 * @author admin
 */
public class RequestDAO extends DAO1<Request> {

    private EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("Request");
        
    @Override
    public void create(Request t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean update(Request t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(Request t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Request> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Request> list = new ArrayList<>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("Select u From Request u", Request.class)
                    .getResultList();
            em.getTransaction().commit();
        }  catch (NoResultException e) {
            list = null;
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public Request readOnly(String str) {
        EntityManager em = emf.createEntityManager();
        Request r = new Request();
        try {
            em.getTransaction().begin();
            r = em.createQuery("Select u From Request u Where u.studentID = :studentID", Request.class)
                    .setParameter("studentID", str)
                    .getSingleResult();
            em.getTransaction().commit();
        }catch (NoResultException e) {
            r = null;
        } finally {
            em.close();
        }
        return r;
    }
    public Request readOnly(int id) {
        EntityManager em = emf.createEntityManager();
        Request r = new Request();
        try {
            em.getTransaction().begin();
            r = em.createQuery("Select u From Request u Where u.Id = :Id", Request.class)
                    .setParameter("Id", id)
                    .getSingleResult();
            em.getTransaction().commit();
        }catch (NoResultException e) {
            r = null;
        } finally {
            em.close();
        }
        return r;
    }
    

}
