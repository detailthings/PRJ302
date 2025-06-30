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
import java.util.List;
import model.Request;

/**
 *
 * @author admin
 */
public class RequestDAO extends DAO1<Request> {

    private EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("Request");
        
    @Override
    public void create(Request t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);  
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean update(Request t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(Request t) {
            EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Gắn lại entity bị detached
            Request attached = em.merge(t);

            // Xóa entity đã gắn
            em.remove(attached);

            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Request> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Request> list = new ArrayList<>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("Select u From Request u", Request.class)
                    .getResultList();
            em.getTransaction().commit();
        }  catch (NoResultException e) {
            list = null;
        } finally {
            em.close();
        }
        return list;
    }
    
    public List<Request> readAllNone() {
        EntityManager em = emf.createEntityManager();
        List<Request> list = new ArrayList<>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("Select u From Request u Where u.status = 'None'", Request.class)
                    .getResultList();
            em.getTransaction().commit();
        }  catch (NoResultException e) {
            list = null;
        } finally {
            em.close();
        }
        return list;
    }
    
    public List<Request> readAllTeacher(String str) {
        EntityManager em = emf.createEntityManager();
        List<Request> list = new ArrayList<>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("Select u From Request u Where u.teacherID = :teacherID And u.status = 'Reject' And u.status != 'Accept'", Request.class)
                    .setParameter("teacherID", str)
                    .getResultList();
            em.getTransaction().commit();
        }  catch (NoResultException e) {
            list = null;
        } finally {
            em.close();
        }
        return list;
    }
    
    public List<Request> readAllStudentApply(String str) {
        EntityManager em = emf.createEntityManager();
        List<Request> list = new ArrayList<>();
        try {
            em.getTransaction().begin(); // cũng có thể truy vấn với status = processing
            list = em.createQuery("Select u From Request u Where u.studentID IS NOT NULL And u.teacherID = :teacherID And u.status != 'Reject' And u.status != 'Accept'", Request.class)
                    .setParameter("teacherID", str)
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
    public Request readOnly(String str) {
        EntityManager em = emf.createEntityManager();
        Request r = new Request();
        try {
            em.getTransaction().begin();
            r = em.createQuery("Select u From Request u Where u.studentID = :studentID Or u.Id = :Id", Request.class)
                    .setParameter("studentID", str)
                    .setParameter("Id", str)
                    .getSingleResult();
            em.getTransaction().commit();
        }catch (NoResultException e) {
            r = null;
        } finally {
            em.close();
        }
        return r;
    }
    
    public Request readOnlyTeacher(String str) {
        EntityManager em = emf.createEntityManager();
        Request r = new Request();
        try {
            em.getTransaction().begin();
            r = em.createQuery("Select u From Request u Where u.teacherID = :teacherID", Request.class)
                    .setParameter("teacherID", str)
                    .getSingleResult();
            em.getTransaction().commit();
        }catch (NoResultException e) {
            r = null;
        } finally {
            em.close();
        }
        return r;
    }
   
    
    public static void main(String[] args) {
        RequestDAO r = new RequestDAO();
        List<Request> list = r.readAllTeacher("gv001");
        System.out.println(list.get(0));
    }

}
