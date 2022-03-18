package br.com.alura.humanDev.jpa;

import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import javax.persistence.EntityManager;

public class SubcategoryDAO {

    private EntityManager em;

    public SubcategoryDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Subcategory subcategory) {
        this.em.persist(subcategory);
    }
}
