package br.com.alura.humanDev.jpa;

import br.com.alura.humanDev.entities.Course;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDAO {

    private EntityManager em;

    public CourseDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Course course) {
        this.em.persist(course);
        Long id = course.getId();
        System.out.println("Course Id:" + id + " Created");
    }

    public void deleteCourseByCode(String code) {
        String jpql = "SELECT c FROM Course c WHERE c.code= :code";
        Course course = this.em.createQuery(jpql, Course.class)
                .setParameter("code", code)
                .getSingleResult();
        this.em.merge(course);
        this.em.remove(course);
    }

    public void updateCourseStatusToPublic() {
        String jpql = "UPDATE FROM Course c Set c.status = 0 where c.status = 1";
        em.createQuery(jpql).executeUpdate();
        System.out.println("updated");
    }

    public List<Course> showPublicCourses() {
        String jpql = "SELECT c FROM Course c WHERE c.status = 1";
        return em.createQuery(jpql, Course.class)
                .getResultList();
    }

    public List<Course> findAllCourses() {
        String jpql = "SELECT c from Course c";
        return em.createQuery(jpql, Course.class)
                .getResultList();
    }

}
