package br.com.alura.humanDev.dao;

import br.com.alura.humanDev.entities.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDAO {

    private EntityManager em;

    public CategoryDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Category category) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(category);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Category> showActiveCategoriesByOrder() {
        try {
            this.em.getTransaction().begin();
            String jpql = "SELECT c FROM Category c WHERE c.active = true ORDER BY c.ordination";
            List<Category> categories = em.createQuery(jpql, Category.class)
                    .getResultList();
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeAllCategories() {
        String jpql = "DELETE FROM Category";
        try {
            em.getTransaction().begin();
            em.createQuery(jpql).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}