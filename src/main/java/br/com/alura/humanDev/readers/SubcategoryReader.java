package br.com.alura.humanDev.readers;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Subcategory;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubcategoryReader {

    private static Scanner input;
    private static ArrayList<Subcategory> subcategories = new ArrayList<>();

    public static List<Subcategory> loadSubcategory(List<Category> category, String file) {

        try {
            input = new Scanner(Paths.get(file));
            input.nextLine();
            while (input.hasNext()) {
                String[] vect =input.nextLine().split(",");

                Subcategory subcategory = new Subcategory(
                        vect[0],
                        vect[1],
                        vect[2].equals("") ? 0 : Integer.parseInt(vect[2]),
                        vect[3],
                        vect[4].equals("ATIVA"),
                        findCategoryByCode(category, vect[5]));
                subcategories.add(subcategory);
            }
            System.out.println("SUBCATEGORIES: ");
            for (Subcategory s: subcategories) {
                System.out.println(s);
            }
            input.close();
        }catch (Exception e) {
            throw new IllegalArgumentException("The Document .csv is not valid");
        }
        return subcategories;

    }

    public static void showSubcategoriesWithoutDescription(List<Subcategory> subcategories) {
        List<Subcategory> sub =  subcategories.stream()
                .filter(s -> s.getSubcategoryDescription().equals(""))
                .collect(Collectors.toList());
        System.out.println(sub);
    }

    static Category findCategoryByCode(List<Category> categories, String code) {
        return categories.stream()
               .filter(category -> category.getCode().equalsIgnoreCase(code))
               .findFirst().orElse(null);
    }

    public static Long showSubcategoriesActiveWithDescription(List<Subcategory> subcat) {
        return subcat.stream()
                .filter(s -> s.isActive() == true)
                .filter(s -> s.getSubcategoryDescription() != "")
                .count();
    }

}