/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dificuldadezero.management.dao;

import br.com.dificuldadezero.management.dto.Product;
import java.util.List;
  
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
  
public class ProductDAO {
  
         private static ProductDAO instance;
         protected EntityManager entityManager;
          
         public static ProductDAO getInstance(){
                   if (instance == null){
                            instance = new ProductDAO();
                   }
                    
                   return instance;
         }
  
         private ProductDAO() {
                   entityManager = getEntityManager();
         }
  
         private EntityManager getEntityManager() {
                   EntityManagerFactory factory = Persistence.createEntityManagerFactory("product_management");
                   if (entityManager == null) {
                            entityManager = factory.createEntityManager();
                   }
  
                   return entityManager;
         }
  
         public Product getById(final long id) {
                   return entityManager.find(Product.class, id);
         }
  
         @SuppressWarnings("unchecked")
         public List<Product> findAll() {
                   return entityManager.createQuery("FROM " + Product.class.getName()).getResultList();
         }
  
         public void persist(Product product) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.persist(product);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
  
         public void merge(Product product) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.merge(product);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
  
         public void remove(Product product) {
                   try {
                            entityManager.getTransaction().begin();
                            product = entityManager.find(Product.class, product.getId_produto());
                            entityManager.remove(product);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
  
         public void removeById(final long id) {
                   try {
                            Product product = getById(id);
                            remove(product);
                   } catch (Exception ex) {
                            ex.printStackTrace();
                   }
         }
  
}
