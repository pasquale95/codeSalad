package chapter01.ex1_5.pre;

import chapter01.ex1_5.SolutionTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    /**
     * @see SolutionTemplate#SolutionTemplate(String[])
     */
    public Solution(String[] input) {
        super(input);
    }

    /**
     * Complexity: O(n)
     *
     * @param one The first string to compare
     * @param two The second string to compare
     * @return True if the strings are one edit away.
     */
    @Override
    public boolean areOneAway(String one, String two) {
        int diff = one.length() - two.length();
        // check addition/removal edits
        if (Math.abs(diff) > 1) {
            return false;
        }
        int edits = 0;
        // check replace edits
        for (int i = 0, j = 0; i < one.length() && j < two.length(); i++, j++) {
            if (one.charAt(i) != two.charAt(j)) {
                edits++;
                if (edits > 1) {
                    return false;
                }
                if (diff < 0) {
                    j++;
                } else if (diff > 0) {
                    i++;
                }
            }
        }
        return true;
    }
}
