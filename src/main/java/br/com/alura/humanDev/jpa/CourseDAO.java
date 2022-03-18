package br.com.alura.humanDev.jpa;

import br.com.alura.humanDev.entities.Course;

import javax.persistence.EntityManager;

public class CourseDAO {

    private EntityManager em;

    public CourseDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Course course) {
        this.em.persist(course);
    }
}
