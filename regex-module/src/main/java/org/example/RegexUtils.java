
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    // Validate email
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    // 2️ Extract all numbers from text
    public static List<String> extractNumbers(String text) {
        List<String> numbers = new ArrayList<>();

        if (text == null) {
            return numbers;
        }

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            numbers.add(matcher.group());
        }

        return numbers;
    }

    // 3️ Normalize multiple spaces into one
    public static String normalizeSpaces(String text) {
        if (text == null) {
            return null;
        }
        return text.trim().replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {

    }
}
