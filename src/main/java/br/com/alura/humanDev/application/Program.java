package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.dto.InsertCourseDTO;
import br.com.alura.humanDev.jpa.CourseDAO;

import javax.persistence.EntityManager;
import static br.com.alura.humanDev.jpa.JPAUtil.getEntityManager;

public class Program {

    public static void main(String[] args) {

        String code = "name";

//        Category category = new Category(null, "java", "code", "desc", "guide", true, 2, "http", "#FFF");
//        Subcategory subcategory = new Subcategory(null,"name", "code", "desc", "guide", true, 3, category);
//        Course course = new Course(null,"name", "code", 1, true, "target", "inst", "desc", "skills", subcategory);

        InsertCourseDTO courseDTO = new InsertCourseDTO("curso", "code", 4, "paulo", 2);

        EntityManager em = getEntityManager();
        CourseDAO courseDAO = new CourseDAO(em);

        em.getTransaction().begin();

        //courseDAO.insert(course);
        courseDAO.deleteCourseByCode(code);
       // courseDAO.updateCourseStatusToPublic();
        em.getTransaction().commit();
        em.close();

    }
}