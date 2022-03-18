package br.com.alura.humanDev.readers;

import br.com.alura.humanDev.entities.Category;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryReader {

//    private static Scanner input;
//    private static ArrayList<Category> categories = new ArrayList<>();
//
//    public static List<Category> loadCategory(String file) {
//
//        try {
//            input = new Scanner(Paths.get(file));
//            input.nextLine();
//            while (input.hasNextLine()) {
//                String[] vect = input.nextLine().split(",");
//
//                Category category = new Category(
//                        vect[0],
//                        vect[1],
//                        vect[2].equals("") ? 0 : Integer.parseInt(vect[2]),
//                        vect[3],
//                        vect[4].equals("ATIVA"),
//                        vect[5],
//                        vect[6]);
//                categories.add(category);
//            }
//            System.out.println("CATEGORIES: ");
//            for (Category c: categories) {
//                System.out.println(c);
//            }
//            input.close();
//        } catch (Exception e) {
//            throw new IllegalArgumentException("The Document .csv is not valid");
//        }
//        return categories;
//
//    }
//    public static List<Category> showActiveCategories(List<Category> categories) {
//        return categories.stream()
//                .filter(c -> c.isActive() == true)
//                .toList();
//    }

}