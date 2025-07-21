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
import java.util.Collections;
import java.util.List;
import model.DaSaP;
import model.Deliverable;
import model.Project;
import model.Submission;

/**
 *
 * @author admin
 */
public class SubmissionDAO extends DAO1<Submission> {

    private EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("Submission");
        
    @Override
    public void create(Submission t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean update(Submission t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(Submission t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Submission> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Submission> list = new ArrayList<>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("Select u From Submission u", Submission.class)
                    .getResultList();
            em.getTransaction().commit();
        }  catch (NoResultException e) {
            list = null;
        } finally {
            em.close();
        }
        return list;
    }
    
    
    public List<DaSaP> readAllByStuID(String studentID) {
        EntityManager em = emf.createEntityManager();
        List<DaSaP> result = new ArrayList<>();

        //truy vấn đang sai
        try {
            em.getTransaction().begin();

            List<Object[]> rows = em.createQuery(
                    "SELECT s, d, p "
                    + "FROM Submission s "
                    + "JOIN s.deliverable d "
                    + "JOIN s.project p "
                    + "WHERE p.studentID = :studentID", Object[].class)
                    .setParameter("studentID", studentID)
                    .getResultList();

            for (Object[] row : rows) {
                Submission s = (Submission) row[0];
                Deliverable d = (Deliverable) row[1];
                Project p = (Project) row[2];
                result.add(new DaSaP(d, s, p));
            }

            em.getTransaction().commit();
        } catch (NoResultException e) {
            // Không có kết quả: giữ result là rỗng
            em.getTransaction().rollback();  // rollback an toàn
        } catch (Exception e) {
            em.getTransaction().rollback();  // rollback nếu lỗi
            e.printStackTrace();
        } finally {
            em.close();
        }

        return result;
    }

    @Override
    public Submission readOnly(String str) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Submission u = em.find(Submission.class, str);
        em.getTransaction().commit();
        em.close();
        return u;
    }
    
    public Submission readOnlyByID( int id) {
        EntityManager em = emf.createEntityManager();
        Submission de = new Submission();
        try {
            em.getTransaction().begin();
            de = em.createQuery("Select u From Submission u Where u.submissionID = :submissionID", Submission.class)
                    .setParameter("submissionID", id)
                    .getSingleResult();
            em.getTransaction().commit();
        }  catch (NoResultException e) {
            de = null;
        } finally {
            em.close();
        }
        return de;
    }
    
    public static void main(String[] args) {
        SubmissionDAO d = new SubmissionDAO();
        System.out.println(d.readAll().size());
        List<DaSaP> x = d.readAllByStuID("he000001");
        System.out.println(x.get(0).getDeliverable().getTitle());
        System.out.println(d.readAllByStuID("he000001").get(0).getDeliverable().getTitle());
        System.out.println(d.readAllByStuID("he000001").get(0).getProject().getTitle());
        System.out.println(d.readOnlyByID(2).getSubmissionID());
    }
    
}
