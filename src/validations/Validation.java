package validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static void notNull(String field, String error) {
        if (field==null || field.isEmpty())
            throw new IllegalArgumentException(error);
    }

    public static void isValidNumberHours(int number, String error) {
        if (number <= 0 || number > 20)
            throw new IllegalArgumentException(error);
    }

    public static boolean isValidUrl(String url, String error) {
        String urlPatten = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(urlPatten, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
