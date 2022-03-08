package br.com.alura.humanDev.course;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseTest {

    Category category = new Category("Programacao", "programacao", 1, "Programas...", true, "http://", "#00c86f");
    Subcategory subcategory = new Subcategory("Java", "java", 1, "curso", true, category);

    @Test
    void shouldCreateNewCourse() {
        Course course = new Course("Java", "http", 10, true, "programacao",
                "Paulo", "Java jr", "OO", subcategory);
        assertEquals(course, course);
    }

    @Test
    void shouldCourseNameNotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course(null, "java", 10, true, "programacao",
                        "Paulo", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseNameNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("", "java", 10, true, "programacao",
                        "Paulo", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseCodeNotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", null, 10, true, "programacao",
                        "Paulo", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseCodeNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "", 10, true, "programacao",
                        "Paulo", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseCodeBeValid() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "Qa8$", 10, true, "programacao",
                        "Paulo", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseTimeNotBeGreaterThanTwentyHours() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "http", 22, true, "programacao",
                        "Paulo", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseTimeNotBeLessThanOneHour() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "http", 0, true, "programacao",
                        "Paulo", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseInstructorNotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "http", 2, true, "programacao",
                        null, "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseInstructorNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "http", 3, true, "programacao",
                        "", "Java jr", "OO", subcategory));
    }

}