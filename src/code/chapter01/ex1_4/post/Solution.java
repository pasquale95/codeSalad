package chapter01.ex1_4.post;

import chapter01.ex1_4.SolutionTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    public Solution(String input) {
        super(input);
    }

    /**
     * Complexity: O(n)
     *
     * @param   input The input string to check
     * @return  True if the string is a permutation of a palindrome.
     */
    @Override
    public boolean isPermutationOfPalindrome(String input) {
        return staticIsPermutationOfPalindrome(input);
    }

    public static boolean staticIsPermutationOfPalindrome(String input) {
        // make lowercase since we can ignore casing
        input = input.toLowerCase();
        int bitVector = 0;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                bitVector ^= (1 << (c - 'a'));
            }
        }
        return (bitVector & (bitVector - 1)) == 0;
    }
}
