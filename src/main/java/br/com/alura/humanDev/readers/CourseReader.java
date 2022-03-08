package br.com.alura.humanDev.readers;

import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseReader {

    private static Scanner input;
    private static ArrayList<Course> courses = new ArrayList<>();

    public static List<Course> loadCourses(List<Subcategory> subcategories, String file) {

        try {
            input = new Scanner(Paths.get(file));
            input.nextLine();
            while (input.hasNext()) {
                String[] vect = input.nextLine().split(",");
                if (vect.length == 9) {
                    Course course = new Course(
                            vect[0],
                            vect[1],
                            vect[2].equals("") ? 0 : Integer.parseInt(vect[2]),
                            vect[3].equals("PRIVADA"),
                            vect[4],
                            vect[5],
                            vect[6],
                            vect[7],
                            findSubcategoryByCode(subcategories, vect[8]));
                    courses.add(course);
                }
            }
            System.out.println("COURSES: ");
            for (Course a: courses) {
                System.out.println(a);
            }
            input.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("The Document .csv is not valid");
        }
        return courses;

    }
    static Subcategory findSubcategoryByCode(List<Subcategory> subcategories, String code) {
        return subcategories.stream()
                .filter(subcategory -> subcategory.getCode().equalsIgnoreCase(code))
                .findFirst().orElse(null);
    }

    public static List<Course> showAnyPrivateCourses(List<Course> courses) {
        return courses.stream()
                .filter(c -> c.isStatus() == true)
                .toList();
    }

    public static List<String> showAllInstructors(List<Course> courses) {
        return courses.stream()
                .filter(c -> c.getInstructor() != "")
                .map(s -> s.getInstructor()).distinct()
                .toList();
    }

    public static void showInstructorsWithCourses(List<Course> courses) {
        courses.stream().map(c -> c.getInstructor()).distinct()
                .forEach(i -> {
                            Long number = courses.stream().filter(c -> c.getInstructor().equals(i)).count();
                            System.out.println("instructor: "+ i + " has " + number + " course");
                        }
                );

    }
}

