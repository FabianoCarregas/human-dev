package br.com.alura.humanDev.readers;

import br.com.alura.humanDev.entities.Category;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class InstanceCategory {

    private static Scanner input;
    private static ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> loadCategory(String file) {

        try {
            input = new Scanner(Paths.get(file));
            input.nextLine();
            while (input.hasNextLine()) {

                String[] vect = input.nextLine().split(",");

                Category category = new Category(
                        vect[0],
                        vect[1],
                        vect[2].equals("")?0:Integer.parseInt(vect[2]),
                        vect[3],
                        Boolean.parseBoolean(vect[4]),
                        vect[5],
                        vect[6]);
                categories.add(category);
            }
            System.out.println("CATEGORIES: ");
            for (Category c: categories) {
                System.out.println(c);
            }
            input.close();
        }catch (Exception e) {
            System.out.println("err: " + e.getMessage());
        }
        return categories;

    }

}