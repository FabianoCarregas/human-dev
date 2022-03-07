package br.com.alura.humanDev.validations;

import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

public class CodePatternValidation {

    public static void validUrl(String url) {
        notBlankOrNull(url);
        if (!url.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("The code pattern accept only low case characters, numbers and hyphen");
        }
    }

    public static void validColor(String color) {
        notBlankOrNull(color);
        if (!color.matches("^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$")) {
            throw new IllegalArgumentException("The code pattern accept only Hexadecimal colour characters");
        }
    }
}
