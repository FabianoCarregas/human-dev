package br.com.alura.humanDev.jpa;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Subcategory;

import javax.persistence.EntityManager;

public class CategoryDAO {

    private EntityManager em;

    public CategoryDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Category category) {
        this.em.persist(category);
    }
}
