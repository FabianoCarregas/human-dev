package br.com.alura.humanDev.writers.filter;

import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import java.util.List;
import java.util.stream.Collectors;

public class WriterFilters {

    public static int numberOfCoursesInCategory(List<Course> courses, String categoryCode) {
        return (int) courses.stream()
                .filter(course -> course.getSubcategory().getCategory().getCode().equals(categoryCode)).count();
    }

    public static int totalHours(List<Course> courses, String categoryCode) {
        return courses.stream()
                .filter(course -> course.getSubcategory().getCategory().getCode().equals(categoryCode))
                .mapToInt(Course::getCourseTimeHours).sum();
    }

    public static List<Subcategory> filterSubCategoryByCategory(List<Subcategory> subcategories, String categoryCode) {
        List<Subcategory> subcategoryList = subcategories.stream()
                .filter(subcategory -> subcategory.getCategory().getCode().equals(categoryCode)).toList();
        return subcategoryList;
    }

    public static String findCoursesNamesForSubcategory(List<Course> courses, Subcategory subcategory) {
        return courses.stream()
                .filter(course -> course.getSubcategory().equals(subcategory))
                .map(Course::getName)
                .collect(Collectors.joining(", "));
    }
}
