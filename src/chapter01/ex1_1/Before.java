package chapter01.ex1_1;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    private final String[] input;

    public Before(String[] input) {
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
     * Complexity: O(n^2)
     *
     * @param stringToCheck
     * @return boolean
     */
    public static boolean isUniqueCharsEasy(String stringToCheck) {
        for (int i = 0; i < stringToCheck.length()-1; i++) {
            for (int j = i+1; j < stringToCheck.length(); j++) {
                if (stringToCheck.charAt(i) == stringToCheck.charAt(j)) {
                    // if two chars are equal, return false
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Complexity: O(n^2)
     *
     * @param stringToCheck
     * @return boolean
     */
    public static boolean isUniqueCharsDifficult(String stringToCheck) {
        for (int i = 0; i < stringToCheck.length()-1; i++) {
            for (int j = i+1; j < stringToCheck.length(); j++) {
                if (stringToCheck.charAt(i) == stringToCheck.charAt(j)) {
                    // if two chars are equal, return false
                    return false;
                }
            }
        }
        return true;
    }
}