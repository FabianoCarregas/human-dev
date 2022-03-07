package br.com.alura.humanDev.category;

import br.com.alura.humanDev.entities.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CategoryTest {

    @Test
    void shouldCreateNewCategory() {
        Category category = new Category("Php", "php", 1, "php course", true, "gdgd", "#FFF");
    assertEquals(category, category);
    }

    @Test
    void shouldCategoryNameNotBeNull() {
        assertThrows(IllegalArgumentException.class,
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
        assertThrows(IllegalArgumentException.class,
                () -> new Category(
                "Java", null, 1, "programe nas principais...",
                        true, "https://www.alura.com.br",
                        "#00c86f"));
    }

    @Test
    void shouldCategoryCodeNotBeWhiteSpace() {
        assertThrows(IllegalArgumentException.class,
                () -> new Category(
                        "Java", "ja va", 1, "programe nas principais...",
                        true, "https://www.alura.com.br",
                        "#00c86f"));
    }

    @Test
    void shouldCategoryCodeNotUpperCase() {
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

}
