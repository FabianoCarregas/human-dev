package br.com.alura.humanDev.jpa;

import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.dto.InsertCourseDTO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CourseDAO {

    private EntityManager em;

    public CourseDAO(EntityManager em) {
        this.em = em;
    }
//
//    public void insert(Course course) {
//        String jpql = ""
//    }

    public void updateCourseStatusToPublic() {
        String jpql = "UPDATE FROM Course c Set c.status = 0 where c.status = 1";
        em.createQuery(jpql).executeUpdate();
        System.out.println("updated");
    }

    public void deleteCourseByCode(String code) {
       String jpql = "DELETE FROM Course c WHERE c.code_url = :code_url";
       em.createQuery(jpql).setParameter(code, "code_url").executeUpdate();
    }

}
