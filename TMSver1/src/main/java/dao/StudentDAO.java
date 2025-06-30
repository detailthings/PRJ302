/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.*;
import java.util.List;
import model.Student;

/**
 *
 * @author admin
 * @param <Student>
 */
public class StudentDAO extends DAO1<Student>{

    private EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("Student");
    
    @Override
    public void create(Student t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean update(Student t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(Student t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Student> readAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Student> list = em.createQuery("Select u From Project u", Student.class)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public Student readOnly(String str) {
        EntityManager em = emf.createEntityManager();
        Student u = null;
        try {
            em.getTransaction().begin();
            u = em.createQuery("Select u From Student u Where u.userID = :userID", Student.class)
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
