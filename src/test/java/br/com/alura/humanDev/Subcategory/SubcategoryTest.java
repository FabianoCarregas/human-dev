package br.com.alura.humanDev.Subcategory;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Subcategory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.alura.humanDev.readers.SubcategoryReader.*;
import static org.junit.jupiter.api.Assertions.*;

public class SubcategoryTest {

    Category category = new Category("Programacao", "programacao", 1, "Programas...", true, "http://", "#00c86f");

    @Test
    void shouldCreateNewSubcategory() {
        assertDoesNotThrow(
                () -> new Subcategory("Java", "java", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryNameNotBeNull() {
        assertThrows(NullPointerException.class,
                () -> new Subcategory(null, "java", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryNameNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("", "java", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCodeNotBeNull() {
        assertThrows(NullPointerException.class,
                () -> new Subcategory("Java", null, 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCodeNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", "", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCodeNotBeUppercase() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", "COde", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCodeNotHaveSpecialCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", "&$de", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCodeNotHaveSpace() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", "co de", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCategoryNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", "co de", 1, "curso", true, null));
    }

    @Test
    void shouldShowSubcategoriesWithoutDescription() throws Exception {
        List<Subcategory> subcategories = new ArrayList<>();
        List<Subcategory> subcat2 = new ArrayList<>();

        Subcategory sub1 = new Subcategory("Java", "java", 1, "curso java", true, category);
        Subcategory sub2 = new Subcategory("Php", "php", 1, "curso php", true, category);

        subcategories.add(sub1);
        subcategories.add(sub2);
        subcat2.add(sub1);

        assertEquals(subcat2, showSubcategoriesWithoutDescription(subcategories));
    }

    @Test
    void shouldshowSubcategoriesActiveWithDescription() throws Exception {
        List<Subcategory> allSubcategories = new ArrayList<>();

        Subcategory sub1 = new Subcategory("Java", "java", 1, "curso java", true, category);
        Subcategory sub2 = new Subcategory("PHP", "php", 1, "curso php", false, category);

        allSubcategories.add(sub1);
        allSubcategories.add(sub2);

        assertEquals(1L, showSubcategoriesActiveWithDescription(allSubcategories));
    }

}