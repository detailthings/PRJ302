/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import model.*;

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
        Semester u = null;
        try {
            em.getTransaction().begin();
            u = em.createQuery("Select u From Semester u Where u.semesterID = :semesterID", Semester.class)
                    .setParameter("semesterID", str)
                    .getSingleResult();
            em.getTransaction().commit();
        } catch (NoResultException e) {
            u = null;
        } finally {
            em.close();
        }
        return u;
    }
    
   public String getSemester(LocalDateTime createAt) {
    EntityManager em = emf.createEntityManager();
    String semesterID = null;
    try {
        em.getTransaction().begin();

        TypedQuery<String> query = em.createQuery(
            "SELECT u.semesterID FROM Semester u WHERE :date BETWEEN u.startDate AND u.endDate",
            String.class
        );
        query.setParameter("date", createAt.toLocalDate());

        semesterID = query.getSingleResult();  // sẽ trả về chuỗi "Fall", "Spring",...

        em.getTransaction().commit();
    } catch (NoResultException e) {
        semesterID = null;
    } finally {
        em.close();
    }
    return semesterID;
}
   
    public static void main(String[] args) {
        SemesterDAO s = new SemesterDAO();
        RequestDAO r = new RequestDAO();
        Request newRequest = r.readOnly("CSS111");
        String Se = s.getSemester(newRequest.getCreateAt());
        System.out.println(Se);
    }

}