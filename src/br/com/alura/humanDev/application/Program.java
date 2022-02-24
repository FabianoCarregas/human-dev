package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import java.io.IOException;
import java.util.ArrayList;

import static br.com.alura.humanDev.readers.InstanceCategory.loadCategory;
import static br.com.alura.humanDev.readers.InstanceCourse.loadCourses;
import static br.com.alura.humanDev.readers.InstanceSubcategory.loadSubcategory;
import static br.com.alura.humanDev.writers.Writer.writerHtml;

public class Program {

    public static void main(String[] args) throws IOException {

        ArrayList<Category> categories1 = loadCategory("/home/fabiano/Desktop/csv/Categoria.csv");

        ArrayList<Subcategory> subcategories1 = loadSubcategory(categories1, "/home/fabiano/Desktop/csv/Subcategoria.csv");

        ArrayList<Course> courses1 = loadCourses(subcategories1, "/home/fabiano/Desktop/csv/Curso.csv" );

        /////////////////////////////////////////////////////////////////////////////////////////////////////

        writerHtml(categories1, subcategories1, courses1);

    }
}
