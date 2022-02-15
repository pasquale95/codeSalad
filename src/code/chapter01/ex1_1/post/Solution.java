package chapter01.ex1_1.post;

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
     * Complexity: O(n)
     * 1st constraint: just alphabetical characters (numbers don't count);
     * 2nd constraint: uppercase and lowercase chars count for the same;
     *
     * @param   stringToCheck The string to check.
     * @return  True if there are at least two chars are equal.
     */
    public static boolean staticIsUniqueCharsA(String stringToCheck) {
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
     * Complexity: O(n log(n))
     * 1st constraint: the input string can be modified;
     * 2nd constraint: no additional data structures.
     *
     * @param   stringToCheck The string to check.
     * @return  True if there are at least two chars are equal.
     */
    public static boolean staticIsUniqueCharsB(String stringToCheck) {
        stringToCheck = stringToCheck.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        for (int i = 0; i < stringToCheck.length()-1; i++) {
            if (stringToCheck.charAt(i) == stringToCheck.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected boolean isUniqueCharsA(String stringToCheck) {
        return staticIsUniqueCharsA(stringToCheck);
    }

    @Override
    protected boolean isUniqueCharsB(String stringToCheck) {
        return staticIsUniqueCharsB(stringToCheck);
    }
}