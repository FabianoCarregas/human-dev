package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.readers.InstanceCategory;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        ArrayList<Category> categories = new InstanceCategory().loader("/home/fabiano/Desktop/csv/Categoria.csv");
        System.out.println(categories);

    }
}
