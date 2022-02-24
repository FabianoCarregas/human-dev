package br.com.alura.humanDev.readers;

import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InstanceCourse {

    private static Scanner input;
    private static final ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> loadCourses(ArrayList<Subcategory> subcategories, String file) {

        try {
            input = new Scanner(Paths.get(file));
            input.nextLine();
            while (input.hasNext()) {
                String[] vect = input.nextLine().split(",", 9);

                Optional<Subcategory> possibleSubcategory = findSubcategoryByCode(subcategories, vect[8]);
                if (possibleSubcategory.isPresent()) {
                    Course course = new Course(
                            vect[0],
                            vect[1],
                            vect[2].equals("") ? 0 : Integer.parseInt(vect[2]),
                            vect[3].equals("PRIVADA"),
                            vect[4],
                            vect[5],
                            vect[6],
                            vect[7],
                            possibleSubcategory.get());
                    courses.add(course);
                }
            }
            System.out.println("COURSES: ");
            for (Course a: courses) {
                System.out.println(a);
            }
            input.close();
        } catch (IOException e) {
            System.out.println("err: " + e.getMessage());
        }
        return courses;

    }
    static Optional<Subcategory> findSubcategoryByCode(List<Subcategory> subcategories, String code) {
        return subcategories.stream()
                .filter(subcategory -> subcategory.getCode().equalsIgnoreCase(code))
                .findFirst();
    }
}
