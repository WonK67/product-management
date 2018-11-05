package br.com.dificuldadezero.management.dao;

import br.com.dificuldadezero.management.dto.Log;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author wonk
 */
public class LogDAO {

    private static LogDAO instance;
    protected EntityManager entityManager;

    public static LogDAO getInstance() {
        if (instance == null) {
            instance = new LogDAO();
        }

        return instance;
    }

    private LogDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("product_management");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public List<Log> findRecentLogs(long id_log) {
        String hql = "FROM Log log WHERE log.id_log > " + id_log;
        return entityManager.createQuery(hql).getResultList();
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
