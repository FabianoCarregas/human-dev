package validations;

public class CodePatternValidation {

    public static void isValidUrl(String url, String error) {

        if (!url.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException(error);
        }
    }

    public static void isValidColor(String color, String error) {

        if (!color.matches("^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$")) {
            throw new IllegalArgumentException(error);
        }
    }
}
