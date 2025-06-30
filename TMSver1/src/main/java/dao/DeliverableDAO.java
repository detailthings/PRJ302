/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import model.Deliverable;

/**
 *
 * @author admin
 */
public class DeliverableDAO extends DAO1<Deliverable> {

    
    private EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("Deliverable");
        
    @Override
    public void create(Deliverable t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean update(Deliverable t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(Deliverable t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Deliverable> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Deliverable> list = new ArrayList<>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("Select u From Deliverable u", Deliverable.class)
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
    public Deliverable readOnly(String str) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Deliverable u = em.find(Deliverable.class, str);
        em.getTransaction().commit();
        em.close();
        return u;
    }

}
