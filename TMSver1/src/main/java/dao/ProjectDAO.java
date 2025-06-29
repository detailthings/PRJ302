/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Project;
import model.UserAccount;

/**
 *
 * @author admin
 */
public class ProjectDAO extends DAO1<Project> {

    private EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("Project");
        
    @Override
    public void create(Project t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean update(Project t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(Project t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Project> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Project> list = new ArrayList<>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("Select u From Project u", Project.class)
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
    public Project readOnly(String str) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Project u = em.find(Project.class, str);
        em.getTransaction().commit();
        em.close();
        return u;
    }
    
    public List<Project> readAllByStuID(String studentID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Project> list = em
                .createQuery("Select u From Project u Where u.studentID = :studentID", Project.class)
                .setParameter("studentID", studentID)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }
    
    public List<Project> readAllByTeaID(String teacherID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Project> list = em
                .createQuery("Select u From Project u Where u.teacherID = :teacherID", Project.class)
                .setParameter("teacherID", teacherID)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }
    
    public int countAllProject() {
        EntityManager em = emf.createEntityManager();
        int count = 0;
        try {
            em.getTransaction().begin();
            count = em.createQuery("Select Count(u) From Project u", Long.class)
                    .getSingleResult()
                    .intValue();
            em.getTransaction().commit();
        }  catch (NoResultException e) {
            count = 0;
        } finally {
            em.close();
        }
        return count;
    }
    
}
