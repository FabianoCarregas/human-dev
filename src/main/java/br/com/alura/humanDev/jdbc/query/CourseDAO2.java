package br.com.alura.humanDev.jdbc.query;

import br.com.alura.humanDev.entities.Course;

import javax.persistence.EntityManager;

public class CourseDAO2 {

    private EntityManager em;

    public CourseDAO2(EntityManager em) {
        this.em = em;
    }

    public void insert(Course course) {
        this.em.persist(course);
    }
}
