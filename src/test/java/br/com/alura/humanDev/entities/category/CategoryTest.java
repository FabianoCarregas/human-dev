package br.com.alura.humanDev.entities.category;

import br.com.alura.humanDev.entities.Category;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    String name = "Java";
    String code = "java";
    int order = 1;
    String description = "description";
    String color = "#FFF";
    String icon = "http//";

    @Test
    void shouldCreateNewCategory() {
        assertDoesNotThrow(() -> new Category(name, code, order, description,
                true, icon, color));
    }

    @Test
    void shouldCategoryNameNotBeNull() {
        assertThrows(NullPointerException.class, () -> new Category(null, code,
                order, description,true, icon, color));
    }

    @Test
    void shouldCategoryNameNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Category("", code,
                order, description,true, icon, color));
    }

    @Test
    void shouldCategoryCodeNotBeNull() {
        assertThrows(NullPointerException.class, () -> new Category(name, null, order, code,
                        true, icon, color));
    }

    @Test
    void shouldCategoryCodeNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Category(name, "", order, code,
                        true, icon, color));
    }

    @Test
    void shouldCategoryCodeNotBeWithWhiteSpace() {
        assertThrows(IllegalArgumentException.class, () -> new Category(name, "co de", order, code,
                        true, icon, color));
    }

    @Test
    void shouldCategoryCodeNotBeWithUpperCaseCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Category(name, "CODE", order, code,
                        true, icon, color));
    }

    @Test
    void shouldCategoryCodeNotWithSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Category(name, "@cod&", order, code,
                        true, icon, color));
    }

//    @Test
//    void shouldShowActiveCategories() {
//        Category category1 = new Category(name, code, order, description, true, icon, color);
//        Category category2 =  new Category(name, code, order, description, false, icon, color);
//
//        List<Category> categoryList = List.of(category1, category2);
//        List<Category> categories = showActiveCategories(categoryList);
//
//        assertEquals(1, categories.size());
//        assertEquals(category1, categories.get(0));
//    }

}
