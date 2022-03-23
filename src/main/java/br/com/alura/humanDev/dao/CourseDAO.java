package br.com.alura.humanDev.dao;

import br.com.alura.humanDev.entities.Course;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDAO {

    private EntityManager em;

    public CourseDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Course course) {
        this.em.getTransaction().begin();
        this.em.persist(course);
        this.em.getTransaction().commit();
        Long id = course.getId();
        System.out.println("Course Id:" + id + " Created");
    }

    public void deleteCourseByCode(String code) {
        this.em.getTransaction().begin();
        String jpql = "SELECT c FROM Course c WHERE c.code= :code";
        Course course = this.em.createQuery(jpql, Course.class)
                .setParameter("code", code)
                .getSingleResult();
        this.em.merge(course);
        this.em.remove(course);
        this.em.getTransaction().commit();
    }

    public List<Course> updateCourseStatusToPublic() {
        this.em.getTransaction().begin();
        String jpql = "UPDATE FROM Course c Set c.status = 1 where c.status = 0";
        em.createQuery(jpql).executeUpdate();
        this.em.getTransaction().commit();
        System.out.println("Course updated to Public");
        return findAllCourses();
    }

    public List<Course> showPublicCourses() {
        this.em.getTransaction().begin();
        String jpql = "SELECT c FROM Course c WHERE c.status = 1";
        List<Course> courses = em.createQuery(jpql, Course.class)
                .getResultList();
        this.em.getTransaction().commit();
        return courses;

    }

    public List<Course> findAllCourses() {
        this.em.getTransaction().begin();
        String jpql = "SELECT c from Course c";
        List<Course> courses = em.createQuery(jpql, Course.class)
                .getResultList();
        this.em.getTransaction().commit();
        return courses;
    }

    public void removeAllCourses() {
        String jpql = "DELETE FROM Courses";
        try {
            em.getTransaction().begin();
            em.createQuery(jpql).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
