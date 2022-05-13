package br.com.alura.humandev.repositories;

import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.projections.InstructorProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CourseRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private  CourseRepository repository;

    private final String cssCode = "css-code";
    private final String javaCode = "java-code";
    private final String awsCode = "aws-code";
    private final String devopsCode = "devops-code";
    private final String frontendCode = "frontend-code";
    private final String githubCode = "github-code";
    private final String instructorBack = "João";
    private final String instructorFront = "Maria";

    @Test
    public void findInstructor__should_return_an_instructor_with_number_of_courses() {
        Category categoryJava = createCategory(javaCode, true);
        Subcategory subcategoryAws = createSubcategory(categoryJava, true, awsCode);
        Course courseCss = createCourse(subcategoryAws, true, cssCode, instructorFront);

        InstructorProjection instructorFound = repository.findInstructor();
        assertEquals(1, instructorFound.getCoursesNumber());
        assertEquals(instructorFront, instructorFound.getInstructor());
    }

    @Test
    public void findInstructor__should_return_an_instructor_whith_the_higher_number_of_courses() {
        Category categoryJava = createCategory(javaCode, true);
        Subcategory subcategoryCss = createSubcategory(categoryJava, true, cssCode);
        Course courseAws = createCourse(subcategoryCss, true, awsCode, instructorBack);
        Course courseFrontend = createCourse(subcategoryCss, true, frontendCode, instructorBack);

        Category categoryCss = createCategory(cssCode, true);
        Subcategory subcategoryDevops = createSubcategory(categoryCss, true, devopsCode);
        Course courseGithub = createCourse(subcategoryDevops, true, githubCode, instructorFront);

        InstructorProjection instructorFound = repository.findInstructor();
        assertEquals(2, instructorFound.getCoursesNumber());
        assertEquals(instructorBack, instructorFound.getInstructor());
        assertNotEquals(instructorFront, instructorFound.getInstructor());
    }

    private Category createCategory(String code, boolean active) {
        Category category = Category.builder()
                .name("name")
                .code(code)
                .ordination(4)
                .categoryDescription("course")
                .active(active)
                .icon("http")
                .hexaColor("#FFF")
                .build();
        em.persist(category);
        return category;
    }

    private Subcategory createSubcategory(Category category, boolean active, String code) {
        Subcategory subcategory = Subcategory.builder()
                .name("java")
                .code(code)
                .ordination(1)
                .subcategoryDescription("desc")
                .active(active)
                .category(category)
                .build();
        em.persist(subcategory);
        return subcategory;
    }

    private Course createCourse(Subcategory subcategory, boolean active, String code, String instructor) {
        Course course = Course.builder()
                .name("java")
                .code(code)
                .courseTimeHours(1)
                .active(active)
                .targetAudience("")
                .instructor(instructor)
                .courseDescription("")
                .developedSkills("")
                .subcategory(subcategory)
                .build();
        em.persist(course);
        return course;
    }
}