/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.*;
import java.util.*;
import model.UserAccount;

/**
 *
 * @author admin
 */
public class UserAccDAO extends DAO1<UserAccount> {
    
    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("UserAccount");

    @Override
    public void create(UserAccount t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean update(UserAccount t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(UserAccount t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<UserAccount> readAll() {
        EntityManager em = emf.createEntityManager();
        List<UserAccount> list = new ArrayList<>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("Select u From UserAccount u", UserAccount.class)
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
    public UserAccount readOnly(String str) {
        EntityManager em = emf.createEntityManager();
        UserAccount u = null;
        try {
            em.getTransaction().begin();
            u = em.createQuery("Select u From UserAccount u Where u.userID = :userID", UserAccount.class)
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
    
//    public UserAccount getUserBy(String user, String pass) {
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        UserAccount u = em
//                .createQuery("Select u From UserAccount u Where (u.userID = :userID Or u.email = :email) And u.passWord = :passWord", UserAccount.class)
//                .setParameter("userID", user)
//                .setParameter("email", user)
//                .setParameter("passWord", pass)
//                .getSingleResult();
//        em.getTransaction().commit();
//        em.close();
//        return u;
//    }
  
    
    public UserAccount getUserBy(String user, String pass) {
        EntityManager em = emf.createEntityManager();
        UserAccount u = null;

        try {
            u = em.createQuery("SELECT u FROM UserAccount u WHERE (u.userID = :userID OR u.email = :email) AND u.passWord = :passWord", UserAccount.class)
                    .setParameter("userID", user)
                    .setParameter("email", user)
                    .setParameter("passWord", pass)
                    .getSingleResult();
        } catch (NoResultException e) {
            u = null;
        } finally {
            em.close();
        }

        return u;
    }
    //thì nếu truy vấn không ra kết quả, nó sẽ ném ra ngoại lệ NoResultException, chứ không trả về null.

}
