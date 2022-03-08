package br.com.alura.humanDev.validations;

public class Validation {

    public static void notNull(String field) {
        if (field == null) throw new NullPointerException("The field name can not be null.");
    }

    public static void notBlankOrNull(String field) {
        notNull(field);
        if (field.isEmpty() || field.isBlank()) throw new IllegalArgumentException("The field name can not be empty or blank.");
    }

    public static void validNumberHours(int number) {
        if (number < 1 || number > 20)
            throw new IllegalArgumentException("The video time can not be less than 1 hour or grater than 20 hours.");
    }

}
