package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;
import br.com.alura.humanDev.readers.InstanceCategory;
import br.com.alura.humanDev.readers.InstanceCourse;
import br.com.alura.humanDev.readers.InstanceSubcategory;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

import static br.com.alura.humanDev.readers.InstanceCategory.activeCategories;
import static br.com.alura.humanDev.readers.InstanceCategory.loadCategory;
import static br.com.alura.humanDev.readers.InstanceCourse.*;
import static br.com.alura.humanDev.readers.InstanceSubcategory.*;
import static br.com.alura.humanDev.writers.Writer.writerHtml;

public class Program {

    public static void main(String[] args) throws IOException {

        ArrayList<Category> categories1 = loadCategory("/home/fabiano/Desktop/csv/Categoria.csv");

        ArrayList<Subcategory> subcategories1 = loadSubcategory(categories1, "/home/fabiano/Desktop/csv/Subcategoria.csv");

        ArrayList<Course> courses1 = loadCourses(subcategories1, "/home/fabiano/Desktop/csv/Curso.csv" );

       // writerHtml(categories1, subcategories1, courses1);
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------Third Week-----------------------------------------");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<List Of Active Categories>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        activeCategories(categories1);  //ok

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Categories with no Description>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        getCategoriesBySubWithNoDescription(subcategories1); //ok?

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Private Courses >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        isThereAnyPrivateCourses(courses1); //ok?

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Find all Instructors whith no reps >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        findAllInstructors(courses1); //ok

        System.out.println("<<<<<<<<<<<<<<<<<<<<<< Count Active Subcategories with description >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(subcategoriesActiveWithDescription(subcategories1)); //ok

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<< Instructor with quantity of Courses >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //findInstructorsWithCourses(courses1);
    }
}
