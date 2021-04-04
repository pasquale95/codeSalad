package utils;

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
     * @param total
     * @param length
     */
    public static String[] generateRandomStringArray(int total, int length, boolean onlyLowerLetters) {
        String[] strings = new String[total];
        for (int i = 0; i < total; i++) {
            strings[i] = generateRandomString(length, onlyLowerLetters);
        }
        return strings;
    }

    /**
     * Generate random string.
     * @param length
     */
    public static String generateRandomString(int length, boolean onlyLowerLetters) {
        Random r = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (onlyLowerLetters) {
                stringBuilder.append(lowerAlphabet[r.nextInt(lowerAlphabet.length)]);
            } else {
                stringBuilder.append(lowerUpperAlphabetWithSpace[r.nextInt(lowerUpperAlphabetWithSpace.length)]);
            }
        }
        return stringBuilder.toString();
    }
}
