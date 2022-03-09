package br.com.alura.humanDev.category;

import br.com.alura.humanDev.entities.Category;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.alura.humanDev.readers.CategoryReader.showActiveCategories;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    void shouldCreateNewCategory() {
        assertDoesNotThrow(
                () -> new Category("Php", "php", 1, "php course", true, "gdgd", "#FFF"));
    }

    @Test
    void shouldCategoryNameNotBeNull() {
        assertThrows(NullPointerException.class,
                () -> new Category(
                null, "programacao", 1, "programe nas principais...",
                true, "https://www.alura.com.br",
                "#00c86f"));
    }

    @Test
    void shouldCategoryNameNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Category(
                        "", "progra-macao", 1, "programe nas principais...",
                        true, "https://www.alura.com.br",
                        "#00c86f"));
    }

    @Test
    void shouldCategoryCodeNotBeNull() {
        assertThrows(NullPointerException.class,
                () -> new Category(
                "Java", null, 1, "programe nas principais...",
                        true, "https://www.alura.com.br",
                        "#00c86f"));
    }

    @Test
    void shouldCategoryCodeNotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Category(
                        "Java", "", 1, "programe nas principais...",
                        true, "https://www.alura.com.br",
                        "#00c86f"));
    }

    @Test
    void shouldCategoryCodeNotBeWithWhiteSpace() {
        assertThrows(IllegalArgumentException.class,
                () -> new Category(
                        "Java", "ja va", 1, "programe nas principais...",
                        true, "https://www.alura.com.br",
                        "#00c86f"));
    }

    @Test
    void shouldCategoryCodeNotBeWithUpperCaseCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> new Category(
                        "Java", "JAva", 1, "programe nas principais...",
                        true, "https://www.alura.com.br",
                        "#00c86f"));
    }

    @Test
    void shouldCategoryCodeNotWithSpecialCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> new Category(
                        "Java", "java%$", 1, "programe nas principais...",
                        true, "https://www.alura.com.br",
                        "#00c86f"));
    }

    @Test
    void shouldShowActiveCategories() throws Exception {
        List<Category> categoryList = new ArrayList<>();
        List<Category> categoryReturn = new ArrayList<>();

        Category category = new Category("Java", "java", 1, "java course", true, "http", "#FFF");
        Category category1 = new Category("Php", "php", 1, "php course", false, "http", "#FFF");

        categoryList.add(category);
        categoryList.add(category1);
        categoryReturn.add(category);

        assertEquals(categoryReturn, showActiveCategories(categoryList));
    }

}
