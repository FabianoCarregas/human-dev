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
        try {
            this.em.getTransaction().begin();
            this.em.persist(course);
            this.em.getTransaction().commit();
            Long id = course.getId();
            System.out.println("Course Id:" + id + " Created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourseByCode(String code) {
        try {
            this.em.getTransaction().begin();
            String jpql = "SELECT c FROM Course c WHERE c.code= :code";
            Course course = this.em.createQuery(jpql, Course.class)
                    .setParameter("code", code)
                    .getSingleResult();
            this.em.merge(course);
            this.em.remove(course);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Course> updateAllCourseStatusToPublic() {
        try {
            this.em.getTransaction().begin();
            String jpql = "UPDATE Course c Set c.status = 0";
            em.createQuery(jpql).executeUpdate();
            this.em.getTransaction().commit();
            System.out.println("Course updated to Public");
            return findAllCourses();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Course> showPublicCourses() {
        try {
            this.em.getTransaction().begin();
            String jpql = "SELECT c FROM Course c WHERE c.status = :true";
            List<Course> courses = em.createQuery(jpql, Course.class)
                    .getResultList();
            this.em.getTransaction().commit();
            return courses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Course> findAllCourses() {
        try {
            this.em.getTransaction().begin();
            String jpql = "SELECT c from Course c";
            List<Course> courses = em.createQuery(jpql, Course.class)
                    .getResultList();
            this.em.getTransaction().commit();
            return courses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeAllCourses() {
        String jpql = "DELETE FROM Course";
        try {
            em.getTransaction().begin();
            em.createQuery(jpql).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
