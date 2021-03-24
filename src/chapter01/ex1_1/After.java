package chapter01.ex1_1;

import java.util.Arrays;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    private final String[] input;

    /**
     * Implementation after reading the hints and the official solution.
     *
     * @param input
     */
    public After(String[] input) {
        this.input = input;
    }

    @Override
    public void run() {
        for (String string : this.input) {
            isUniqueCharsEasy(string);
            isUniqueCharsDifficult(string);
        }
    }

    /**
     * 1st constraint: just alphabetical characters (numbers don't count);
     * 2nd constraint: uppercase and lowercase chars count for the same;
     * Complexity: O(n)
     *
     * @param stringToCheck
     * @return boolean
     */
    public static boolean isUniqueCharsEasy(String stringToCheck) {
        int bitVector = 0;
        String stringToCheckLower = stringToCheck.toLowerCase();
        for (int i = 0; i < stringToCheck.length(); i++) {
            int alphabetPosition = stringToCheckLower.charAt(i) - 'a';
            if ((bitVector & (1 << alphabetPosition)) > 0) {
                // found a character with the same position in the alphabet
                return false;
            }
            // mark that position as taken
            bitVector |= (1 << alphabetPosition);
        }
        return true;
    }

    /**
     * 1st constraint: the input string can be modified.
     * Complexity: O(n log(n))
     *
     * @param stringToCheck
     * @return boolean
     */
    public static boolean isUniqueCharsDifficult(String stringToCheck) {
        //stringToCheck = stringToCheck.chars()
        //        .sorted()
        //        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        //        .toString();
        char[] chars = stringToCheck.toCharArray();
        Arrays.sort(chars);
        stringToCheck = new String(chars);
        for (int i = 0; i < stringToCheck.length()-1; i++) {
            if (stringToCheck.charAt(i) == stringToCheck.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}