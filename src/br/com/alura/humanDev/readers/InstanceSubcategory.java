package br.com.alura.humanDev.readers;

import br.com.alura.humanDev.entities.Subcategory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class InstanceSubcategory {

    private static Scanner input;
    private static ArrayList<Subcategory> subcategories = new ArrayList<>();

    public ArrayList<Subcategory> loader(String file) {

        try {
            input = new Scanner(Paths.get(file));
            input.nextLine();
            while (input.hasNext()) {
                String[] vect =input.nextLine().split(",");

                Subcategory subcategory = new Subcategory(
                        vect[0],
                        vect[1],
                        vect[2].equals("")?0:Integer.parseInt(vect[2]),
                        vect[3],
                        Boolean.parseBoolean(vect[4]),
                        vect[5]);
                subcategories.add(subcategory);
            }
            System.out.println("SUBCATEGORIES: ");
            for (Subcategory s: subcategories) {
                System.out.println(s);
            }

        }catch (Exception e) {
            System.out.println("err: " + e.getMessage());
        }
        return null;

    }

}
