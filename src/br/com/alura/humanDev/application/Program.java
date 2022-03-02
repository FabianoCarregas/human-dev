package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import java.io.IOException;
import java.util.List;

import static br.com.alura.humanDev.readers.CategoryReader.loadCategory;
import static br.com.alura.humanDev.readers.CategoryReader.showActiveCategories;
import static br.com.alura.humanDev.readers.CourseReader.*;
import static br.com.alura.humanDev.readers.SubcategoryReader.*;

public class Program {

    public static void main(String[] args) throws IOException {

        List<Category> categories1 = loadCategory("/home/fabiano/Desktop/csv/Categoria.csv");

        List<Subcategory> subcategories1 = loadSubcategory(categories1, "/home/fabiano/Desktop/csv/Subcategoria.csv");

        List<Course> courses1 = loadCourses(subcategories1, "/home/fabiano/Desktop/csv/Curso.csv");

        //writerHtml(categories1, subcategories1, courses1);
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------Third Week-----------------------------------------");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<List Of Active Categories>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        showActiveCategories(categories1);  //ok

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Subcategories with no Description>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        showSubcategoriesWithoutDescription(subcategories1); //ok?

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Private Courses >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        showAnyPrivateCourses(courses1); //ok?

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Find all Instructors whith no reps >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        showAllInstructors(courses1); //ok

        System.out.println("<<<<<<<<<<<<<<<<<<<<<< Count Active Subcategories with description >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(showSubcategoriesActiveWithDescription(subcategories1)); //ok

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<< Instructor with quantity of Courses >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        showInstructorsWithCourses(courses1);

    }
}
