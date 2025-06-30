/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import model.Project;

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
    
    
    //Find the number of all Project in all Semester
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
    
    
    //Find the number of Project in newest Semester(not now semester)
    public int countAllProjectInNewestSemester(String newestSemester) {
        EntityManager em = emf.createEntityManager();
        int count = 0;
        try {
            em.getTransaction().begin();
            count = em.createQuery("Select Count(u) From Project u Where u.semesterID = :semesterID", Long.class)
                    .setParameter("semesterID", newestSemester)
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
    
    public String findNewestSemester() {
        EntityManager em = emf.createEntityManager();
        String newestSemester = null;
        try {
            em.getTransaction().begin();
            newestSemester = em.createQuery(
                "SELECT s.semesterID FROM Semester s " +
                "WHERE s.endDate < CURRENT_DATE " +
                "ORDER BY s.endDate DESC", String.class)
                .setMaxResults(1)
                .getSingleResult();
            em.getTransaction().commit();
        }  catch (NoResultException e) {
            newestSemester = null;
        } finally {
            em.close();
        }
        return newestSemester;
    }
    
    public int countNumerOfGoodProject(String newestSemester) {
        EntityManager em = emf.createEntityManager();
        int count = 0;
        try {
            em.getTransaction().begin();
            count = em.createQuery("Select Count(u) From Project u Where u.scorce >= 8.0 and u.scorce < 9.0 and u.semesterID = :semesterID", Long.class)
                    .setParameter("semesterID", newestSemester)
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
    
    public static void main(String[] args) {
        ProjectDAO p = new ProjectDAO();
        int numOfProject = p.countAllProject();
        String newestSemester = p.findNewestSemester();
        int numOfProjectInNewestSemester = p.countAllProjectInNewestSemester(newestSemester);
        int numOfGoodProject = p.countNumerOfGoodProject(newestSemester);
        System.out.println(numOfGoodProject);
    }
    
}
