package br.com.alura.humanDev.Subcategory;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Subcategory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.alura.humanDev.readers.SubcategoryReader.showSubcategoriesActiveWithDescription;
import static br.com.alura.humanDev.readers.SubcategoryReader.showSubcategoriesWithoutDescription;
import static org.junit.jupiter.api.Assertions.*;

public class SubcategoryTest {

    String name = "Java";
    String code = "java";
    String spaceBetween = "ja va";
    String specialCharacters = "%&*";
    int order = 1;
    String description = "programe nas principais...";
    String color = "#FFF";

    Category category = new Category(name, code, order, description, true, code, color);

    @Test
    void shouldCreateNewSubcategory() {
        assertDoesNotThrow(() -> new Subcategory(name, code, order, description, true, category));
    }

    @Test
    void shouldSubcategoryNameNotBeNull() {
        assertThrows(NullPointerException.class, () -> new Subcategory(null, code, order, description,
                true, category));
    }

    @Test
    void shouldSubcategoryNameNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Subcategory("", code, order, description,
                true, category));
    }

    @Test
    void shouldSubcategoryCodeNotBeNull() {
        assertThrows(NullPointerException.class, () -> new Subcategory(name, null, order, description,
                true, category));
    }

    @Test
    void shouldSubcategoryCodeNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Subcategory(name, "", order, description,
                true, category));
    }

    @Test
    void shouldSubcategoryCodeNotBeUppercase() {
        assertThrows(IllegalArgumentException.class, () -> new Subcategory(name, "CODE", order, description,
                true, category));
    }

    @Test
    void shouldSubcategoryCodeNotHaveSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Subcategory(name, specialCharacters, order, description,
                true, category));
    }

    @Test
    void shouldSubcategoryCodeNotHaveSpace() {
        assertThrows(IllegalArgumentException.class, () -> new Subcategory(name, spaceBetween, order, description,
                true, category));
    }

    @Test
    void shouldShowSubcategoriesWithoutDescription() {
        Subcategory subcategory1 = new Subcategory(name, code, order, "", true, category);
        Subcategory subcategory2 = new Subcategory(name, code, order, description, true, category);

        List<Subcategory> subcategoriesList = List.of(subcategory1, subcategory2);
        List<Subcategory> subcategories = showSubcategoriesWithoutDescription(subcategoriesList);

        assertEquals(1, subcategories.size());
        assertEquals(subcategory1, subcategories.get(0));
    }

    @Test
    void shouldShowSubcategoriesActiveWithDescription() {
        List<Subcategory> allSubcategories = new ArrayList<>();

        Subcategory subcategory1 = new Subcategory(name, code, order, description, true, category);
        Subcategory subcategory2 = new Subcategory(name, code, order, "", false, category);

        List<Subcategory> subcategoriesList = List.of(subcategory1, subcategory2);
        Long subcategories = showSubcategoriesActiveWithDescription(subcategoriesList);

        assertEquals(1L, subcategories);
    }

}