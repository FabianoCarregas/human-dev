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

    public List<Category> findAllCategories() {
        String jpql = "SELECT a FROM Category a";
        List<Category> categories = em.createQuery(jpql, Category.class)
                .getResultList();
        return categories;
    }

    public List<Category> showActiveCategoriesByOrder() {
            String jpql = "SELECT c FROM Category c WHERE c.active = true ORDER BY c.ordination";
            List<Category> categories = em.createQuery(jpql, Category.class)
                    .getResultList();
        return categories;
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

    public Category findCategoryById(Long id) {
        return em.find(Category.class, id);
    }

    public void update(Category category) {
        try {
            em.getTransaction().begin();
            this.em.merge(category);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
