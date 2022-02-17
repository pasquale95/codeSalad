package chapter01.ex1_2.pre;

import chapter01.ex1_2.SolutionTemplate;

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
     * Complexity: O(n log(n))
     *
     * @param   first The first string.
     * @param   second The second string to compare.
     * @return  True if the two strings are permutations of the same charset.
     */
    @Override
    public boolean arePermutations(String first, String second) {
        if (first.length() != second.length()) {
            // permutations must have same length
            return false;
        }
        String firstSorted = first.toLowerCase().chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String secondSorted = second.toLowerCase().chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return firstSorted.equals(secondSorted);
    }
}
