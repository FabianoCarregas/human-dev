package br.com.alura.humanDev.jpa;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDAO {

    private EntityManager em;

    public CategoryDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Category category) {
        this.em.persist(category);
    }

    public List<Category> showActiveCategoriesByOrder() {
        String jpql = "SELECT c FROM Category c WHERE c.status = 1 ORDER BY c.ordination";
        return em.createQuery(jpql, Category.class)
                .getResultList();
    }

}
