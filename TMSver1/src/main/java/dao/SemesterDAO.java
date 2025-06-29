/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import model.Semester;

/**
 *
 * @author admin
 */
public class SemesterDAO extends DAO1<Semester> {

    
    private EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("Semester");
        
    @Override
    public void create(Semester t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean update(Semester t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(Semester t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Semester> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Semester> list = new ArrayList<>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("Select u From Semester u", Semester.class)
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
    public Semester readOnly(String str) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Semester u = em.find(Semester.class, str);
        em.getTransaction().commit();
        em.close();
        return u;
    }

}