package br.com.alura.humanDev.application;

import br.com.alura.humanDev.readers.InstanceCategory;
import br.com.alura.humanDev.readers.InstanceCourse;
import br.com.alura.humanDev.readers.InstanceSubcategory;

import java.io.IOException;
import java.util.ArrayList;

import static br.com.alura.humanDev.writers.Writer.writerHtml;

public class Program {

    public static void main(String[] args) throws IOException {

        ArrayList categories1 = new InstanceCategory().loadCategory("/home/fabiano/Desktop/csv/Categoria.csv");

        ArrayList subcategories1 = new InstanceSubcategory().loadSubcategory(categories1, "/home/fabiano/Desktop/csv/Subcategoria.csv");

        ArrayList courses1 = new InstanceCourse().loadCourses(subcategories1, "/home/fabiano/Desktop/csv/Curso.csv");

        //ArrayList<Course> courses = new InstanceCourse().loadCourses("/home/fabiano/Desktop/csv/Curso.csv")

        /////////////////////////////////////////////////////////////////////////////////////////////////////

        writerHtml(categories1, subcategories1, courses1);

    }
}
