package chapter01.ex1_2.post;

import chapter01.ex1_2.SolutionTemplate;

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
     * Constraint 1: we can assume that the string only contains ASCII chars (128 totally).
     * Constraint 2: capital letters count the same as lowercase
     *
     * @param   first The first string.
     * @param   second The second string to compare.
     * @return  True if the two strings are permutations of the same charset.
     */
    @Override
    public boolean arePermutations(String first, String second) {
        return staticArePermutations(first, second);
    }

    public static boolean staticArePermutations(String first, String second) {
        if (first.length() != second.length()) {
            // permutations must have same length
            return false;
        }
        // if permutations, first should balance the negative balance of the second
        int[] chars = new int[128];
        first = first.toLowerCase();
        second = second.toLowerCase();
        for (int i = 0; i < first.length(); i++) {
            chars[first.charAt(i)]++;
            chars[second.charAt(i)]--;
        }
        // check occurrences
        for (int characterOccurrence : chars) {
            if (characterOccurrence != 0) {
                return false;
            }
        }
        return true;
    }
}
