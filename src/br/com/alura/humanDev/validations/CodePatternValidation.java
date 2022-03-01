package br.com.alura.humanDev.validations;

public class CodePatternValidation {

    public static void validUrl(String url) {
        if (!url.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("The code pattern accept only low case characters, numbers and hyphen");
        }
    }

    public static void validColor(String color) {
        if (!color.matches("^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$")) {
            throw new IllegalArgumentException("The code pattern accept only Hexadecimal colour characters");
        }
    }
}
