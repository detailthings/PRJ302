/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.*;
import java.util.*;
import model.*;

/**
 *
 * @author admin
 */
public class ReviewerDAO extends DAO1<Reviewer> {

    private EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("Reviewer");
    
    @Override
    public void create(Reviewer t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean update(Reviewer t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(Reviewer t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Reviewer> readAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Reviewer> list = em.createQuery("Select u From Project u", Reviewer.class)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public Reviewer readOnly(String str) {
        EntityManager em = emf.createEntityManager();
        Reviewer u = null;
        try {
            em.getTransaction().begin();
            u = em.createQuery("Select u From Reviewer u Where u.userID = :userID", Reviewer.class)
                    .setParameter("userID", str)
                    .getSingleResult();
            em.getTransaction().commit();
        }  catch (NoResultException e) {
            u = null;
        } finally {
            em.close();
        }
        return u;
    }
}
