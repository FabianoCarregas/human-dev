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
    void shouldSubcategoryNameNotBeNullOrEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("", "java", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCodeNotBeNullOrEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", "", 1, "curso", true, category));
    }

    @Test
    void shouldSubcategoryCategoryNotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Subcategory("Java", "", 1, "curso", true, null));
    }

    @Test
    void shouldShowSubcategoriesWithoutDescription() {
        Subcategory subcategory1 = new Subcategory("Java", "java", 1, "s", true, category);
        assertEquals(subcategory1, subcategory1);
    }

}