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
 * @param <Teacher>
 */
public class TeacherDAO extends DAO1<Teacher> {

    private EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("Teacher");
    
    @Override
    public void create(Teacher t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean update(Teacher t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(Teacher t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Teacher> readAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Teacher> list = em.createQuery("Select u From Project u", Teacher.class)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public Teacher readOnly(String str) {
        EntityManager em = emf.createEntityManager();
        Teacher u = null;
        try {
            em.getTransaction().begin();
            u = em.createQuery("Select u From Teacher u Where u.userID = :userID", Teacher.class)
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
    
    
    public static void main(String[] args) {
        TeacherDAO a = new TeacherDAO();
        Teacher b = a.readOnly("gv001");
        System.out.println(b.getUserID());
        System.out.println(b.getId());
        System.out.println(b.getDepartment());
    }
    
}
