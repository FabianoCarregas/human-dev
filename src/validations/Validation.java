package validations;

public class Validation {

    public static void notNull(String field) {
        if (field == null) throw new IllegalArgumentException("The field name can not be null");
    }

    public static void notBlank(String field) {
        if (field.isEmpty() || field.isBlank()) throw new IllegalArgumentException("The field name can not be null");
    }

    public static void validNumberHours(int number) {
        if (number < 1 || number > 20)
            throw new IllegalArgumentException("The video can not be greater than 1 or less than 20");
    }

}
