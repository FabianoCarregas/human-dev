package br.com.alura.humanDev.course;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static br.com.alura.humanDev.readers.CourseReader.showAllInstructors;
import static br.com.alura.humanDev.readers.CourseReader.showAnyPrivateCourses;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    String name = "Java";
    String code = "java";
    String instructor = "Paulo";
    int order = 1;
    int hours = 10;
    String skills = "development";
    String icon = "http://";
    String audience = "developers";
    String description = "description";
    String color = "#FFF";

    Category category = new Category(name, code, order, description, false, icon, color);
    Subcategory subcategory = new Subcategory(name, code, order, description, true, category);

    @Test
    void shouldCreateNewCourse() {
        assertDoesNotThrow(() -> new Course(name, code, hours, true, audience,
                instructor, description, skills, subcategory));
    }

    @Test
    void shouldCourseNameNotBeNull() {
        assertThrows(NullPointerException.class,() -> new Course(null, code, hours, true,audience,
                instructor,description, skills, subcategory));
    }

    @Test
    void shouldCourseNameNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,() -> new Course("", code, hours, true, audience,
                instructor, description, skills, subcategory));
    }

    @Test
    void shouldCourseCodeNotBeNull() {
        assertThrows(NullPointerException.class,() -> new Course(name, null, hours, true, audience,
                instructor, description, skills, subcategory));
    }

    @Test
    void shouldCourseCodeNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,() -> new Course(name, "", hours, true, audience,
                instructor, description, skills, subcategory));
    }

    @Test
    void shouldCourseCodeBeWithSpaces() {
        assertThrows(IllegalArgumentException.class,() -> new Course(name, "co de", hours, true,
                audience, instructor, description, skills, subcategory));
    }

    @Test
    void shouldCourseCodeBeWithSpecialCharacters() {
        assertThrows(IllegalArgumentException.class,() -> new Course(name, "cod&", hours, true,
                audience, instructor, description, skills, subcategory));
    }

    @Test
    void shouldCourseCodeBeWithUppercaseCharacters() {
        assertThrows(IllegalArgumentException.class,() -> new Course(name, "CodE", hours, true,
                audience, instructor, description, skills, subcategory));
    }

    @Test
    void shouldCourseTimeNotBeGreaterThanTwentyHours() {
        assertThrows(IllegalArgumentException.class,() -> new Course(name, code, 22, true, audience,
                instructor, description, skills, subcategory));
    }

    @Test
    void shouldCourseTimeNotBeLessThanOneHour() {
        assertThrows(IllegalArgumentException.class,() -> new Course(name, code, 0, true, audience,
                instructor, description, skills, subcategory));
    }

    @Test
    void shouldCourseInstructorNotBeNull() {
        assertThrows(NullPointerException.class,() -> new Course(name, code, hours, true, audience,
                null, description, skills, subcategory));
    }

    @Test
    void shouldCourseInstructorNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,() -> new Course(name, code, hours, true, audience,
                "", description, skills, subcategory));
    }

    @Test
    void shouldShowAnyPrivateCourses() {
        Course course1 = new Course(name, code, hours, true, audience,
                instructor, description, skills, subcategory);
        Course course2 = new Course(name, code, hours, false, audience,
                instructor, description, skills, subcategory);

        List<Course> courseList = List.of(course1, course2);
        List<Course> courses = showAnyPrivateCourses(courseList);

        assertEquals(1, courses.size());
        assertEquals(course1, courses.get(0));
    }

    @Test
    void shouldShowAllInstructors() {
        Course course1 = new Course(name, code, hours, true, audience,
                instructor, description, skills, subcategory);

        List<Course> courseList = List.of(course1);
        List<String> courses = showAllInstructors(courseList);

        assertEquals(1, courses.size());
        assertEquals(course1.getInstructor(), courses.get(0));
    }

}