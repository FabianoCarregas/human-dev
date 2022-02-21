package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Subcategory;
import br.com.alura.humanDev.readers.InstanceCategory;
import br.com.alura.humanDev.readers.InstanceSubcategory;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        ArrayList<Category> categories = new InstanceCategory().loadCategory("/home/fabiano/Desktop/csv/Categoria.csv");

        ArrayList<Subcategory> subcategories = new InstanceSubcategory().loader("/home/fabiano/Desktop/csv/Subcategoria.csv");



    }
}
