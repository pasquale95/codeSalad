package chapter01.ex1_1.pre;

import chapter01.ex1_1.SolutionTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    public Solution(String[] input) {
        super(input);
    }

    /**
     * Complexity: O(n^2)
     *
     * @param   stringToCheck The string to check.
     * @return  True if there are at least two chars are equal.
     */
    @Override
    protected boolean isUniqueCharsA(String stringToCheck) {
        return staticIsUniqueCharsA(stringToCheck);
    }

    /**
     * Complexity: O(n^2)
     *
     * @param   stringToCheck The string to check.
     * @return  True if there are at least two chars are equal.
     */
    @Override
    protected boolean isUniqueCharsB(String stringToCheck) {
        return staticIsUniqueCharsB(stringToCheck);
    }

    public static boolean staticIsUniqueCharsA(String stringToCheck) {
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

    public static boolean staticIsUniqueCharsB(String stringToCheck) {
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