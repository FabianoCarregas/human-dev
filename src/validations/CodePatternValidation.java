package validations;

public class CodePatternValidation {

    public static void isValidUrl(String url, String error) {
        if (!url.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException(error);
        }
    }
}
