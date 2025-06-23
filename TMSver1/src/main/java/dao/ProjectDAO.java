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
        em.getTransaction().begin();
        List<Project> list = em.createQuery("Select u From Project u", Project.class)
                .getResultList();
        em.getTransaction().commit();
        em.close();
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
    
    public static void main(String[] args) {
        ProjectDAO p = new ProjectDAO();
        List<Project> l =  p.readAllByStuID("he190177");
        if(l.isEmpty()) {
            System.out.println("Em");
        } else {
            System.out.println(l.get(0));
        }
    }
    
}
