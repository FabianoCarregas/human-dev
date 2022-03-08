package br.com.alura.humanDev.Subcategory;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Subcategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubcategoryTest {

    Category category = new Category("Programacao", "programacao", 1, "Programas...", true, "http://", "#00c86f");

    @Test
    void shouldCreateNewSubcategory() {
        Subcategory subcategory = new Subcategory("Java", "java", 1, "curso", true, category);
        assertEquals(category, category);
    }

    @Test
    void shouldSubcategoryNameNotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory(null, "java", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryNameNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("", "java", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCodeNotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", null, 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCodeNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", "", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCodeNotValid() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", "%T6h", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCategoryNotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", "dd", 1, "curso", true, null));
    }

    @Test
    void shouldShowSubcategoriesWithoutDescription() {
        Subcategory subcategory1 = new Subcategory("Java", "java", 1, "s", true, category);


        assertEquals(subcategory1, subcategory1);
    }

}