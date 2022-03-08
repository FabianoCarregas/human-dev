package br.com.alura.humanDev.course;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.alura.humanDev.readers.CourseReader.showAllInstructors;
import static br.com.alura.humanDev.readers.CourseReader.showAnyPrivateCourses;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    Category category = new Category("Programacao", "programacao", 1, "Programas...", true, "http://", "#00c86f");
    Subcategory subcategory = new Subcategory("Java", "java", 1, "curso", true, category);

    @Test
    void shouldCreateNewCourse() {
        assertDoesNotThrow(
                () -> new Course("Java", "http", 10, true, "programacao",
                "Paulo", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseNameNotBeNull() {
        assertThrows(NullPointerException.class,
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
        assertThrows(NullPointerException.class,
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
    void shouldCourseCodeBeWithSpaces() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "co de", 10, true, "programacao",
                        "Paulo", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseCodeBeWithSpecialCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "co&%de", 10, true, "programacao",
                        "Paulo", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseCodeBeWithUppercaseCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "coDE", 10, true, "programacao",
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
        assertThrows(NullPointerException.class,
                () -> new Course("Java", "http", 2, true, "programacao",
                        null, "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseInstructorNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "http", 3, true, "programacao",
                        "", "Java jr", "OO", subcategory));
    }

    @Test
    void shouldCourseSubcategoryNotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", "http", 3, true, "programacao",
                        "", "Java jr", "OO", null));
    }

    @Test
    void shouldShowAnyPrivateCourses() throws Exception {
        List<Course> courses = new ArrayList<>();
        List<Course> rightCourse = new ArrayList<>();

        Course course = new Course("Java", "http", 2, true, "programacao",
                "Paulo", "Java jr", "OO", subcategory);
        Course course1 = new Course("PHP", "http", 2, true, "programacao",
                "Paulinho", "php", "OO", subcategory);

        courses.add(course);
        rightCourse.add(course);

        assertEquals(rightCourse, showAnyPrivateCourses(courses));
    }

    @Test
    void shouldShowAllInstructors() throws Exception {
        List<Course> courses = new ArrayList<>();
        List<String> rightCourse = new ArrayList<>();

        Course course = new Course("Java", "http", 2, true, "programacao",
                "Paulo", "Java jr", "OO", subcategory);
        Course course1 = new Course("PHP", "http", 2, true, "programacao",
                "Mario", "php", "OO", subcategory);

        courses.add(course);
        courses.add(course1);
        rightCourse.add(course.getInstructor());
        rightCourse.add(course1.getInstructor());

        assertEquals(rightCourse, showAllInstructors(courses));
    }

}