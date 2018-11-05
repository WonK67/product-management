/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dificuldadezero.management.dao;

import br.com.dificuldadezero.management.dto.Log;
import br.com.dificuldadezero.management.dto.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author wonk
 */
public class LogHibernateDAO {

    private static LogHibernateDAO instance;
    protected EntityManager entityManager;

    public static LogHibernateDAO getInstance() {
        if (instance == null) {
            instance = new LogHibernateDAO();
        }

        return instance;
    }

    private LogHibernateDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("product_management");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        return entityManager.createQuery("FROM " + Product.class.getName()).getResultList();
    }

    public void persist(Log log) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(log);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
