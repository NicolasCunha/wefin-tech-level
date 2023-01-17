package com.wefin.tech.person.util;

/**
 * Regex related utilities class.
 */
public final class RegexUtils {

    private RegexUtils() throws IllegalAccessException {
        throw new IllegalAccessException("RegexUtils is an utility class. Should not be instantiated.");
    }

    public static String removeSpecialCharactersAndNumbers(final String input) {
        final String removeLettersAndSpecialChars = "[^0-9]";
        return input.replaceAll(removeLettersAndSpecialChars, "");
    }

}
