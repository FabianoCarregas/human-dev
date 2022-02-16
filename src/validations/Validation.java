package validations;

public class Validation {

    public static void notNull(String field, String error) {
        if (field == null)
            throw new IllegalArgumentException(error);
    }

    public static void notBlank(String field, String error) {
        if (field.isEmpty() || field.isBlank())
            throw new IllegalArgumentException(error);
    }

    public static void isValidNumberHours(int number, String error) {
        if (number <= 1 || number > 20)
            throw new IllegalArgumentException(error);
    }

}
