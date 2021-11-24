package utils.generators;

import org.json.simple.JSONObject;

import java.util.Random;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class StringGenerator {

    public static final char[] lowerAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static final char[] lowerUpperAlphabetWithSpace =
            "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * Generate an array of strings each of the specified length.
     *
     * @param   total Number of random strings to generate.
     * @param   maxLength Max length of the single string inside the pool.
     * @param   onlyLowerCase True if the string can only contain lowercase alphabet chars (no space).
     * @return  Array of random generated strings.
     */
    public static String[] generateRandomStringArray(int total, int maxLength, boolean onlyLowerCase) {
        Random r = new Random();
        String[] strings = new String[total];
        for (int i = 0; i < total; i++) {
            strings[i] = generateRandomString(r.nextInt(maxLength) + 1, onlyLowerCase);
        }
        return strings;
    }

    /**
     * Generate an array of strings each of the specified length.
     *
     * @param   params Set of parameters to use for generating an array of random strings.
     * @return  Array of random generated strings.
     */
    public static String[] generateRandomStringArray(JSONObject params) {
        return generateRandomStringArray(
                ((Long) params.get("total")).intValue(),
                ((Long) params.get("maxLength")).intValue(),
                (Boolean) params.get("onlyLowerCase")
        );
    }

    /**
     * Generate random string.
     *
     * @param   length Length of the single string inside the pool.
     * @param   onlyLowerCase True if the string can only contain lowercase alphabet chars (no space).
     */
    public static String generateRandomString(int length, boolean onlyLowerCase) {
        Random r = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (onlyLowerCase) {
                stringBuilder.append(lowerAlphabet[r.nextInt(lowerAlphabet.length)]);
            } else {
                stringBuilder.append(lowerUpperAlphabetWithSpace[r.nextInt(lowerUpperAlphabetWithSpace.length)]);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Generate random string.
     *
     * @param   params Set of parameters to use for generating a random string.
     * @return  Array of random generated strings.
     */
    public static String generateRandomString(JSONObject params) {
        return generateRandomString(
                ((Long) params.get("length")).intValue(),
                (Boolean) params.get("onlyLowerCase")
        );
    }

    /**
     * Convert the string to a char array with 2 extra cells for each space char inside the string.
     *
     * @param   string The string to convert.
     * @return  Char array with extra space.
     */
    public static char[] toCharsWithExtraRoom(String string) {
        char[] chars = new char[3*string.length()-2*string.replace(" ", "").length()];
        for (int i = 0; i < string.length(); i++) {
            chars[i] = string.charAt(i);
        }
        return chars;
    }
}
