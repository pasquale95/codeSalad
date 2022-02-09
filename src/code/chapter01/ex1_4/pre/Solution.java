package chapter01.ex1_4.pre;

import chapter01.ex1_4.SolutionTemplate;

import java.util.HashMap;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    private final String input;

    public Solution(String input) {
        this.input = input;
    }

    @Override
    public void run() {
        isPermutationOfPalindrome(input);
    }

    /**
     * Complexity: O(n)
     *
     * @param   input The input string to check
     * @return  True if the string is a permutation of a palindrome.
     */
    public static boolean isPermutationOfPalindrome(String input) {
        // make lowercase since we can ignore casing
        input = input.toLowerCase();
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                // just consider letters
                if (!charFrequency.containsKey(c)) {
                    charFrequency.put(c, 0);
                }
                charFrequency.replace(c, charFrequency.get(c) + 1);
            }
        }
        int oddFrequencyChars = 0;
        for (Integer frequency : charFrequency.values()) {
            // count how many chars are in odd number
            oddFrequencyChars += frequency % 2;
        }
        // if at least 2 chars have an odd frequency, the string cannot be palindrome
        return oddFrequencyChars <= 1;
    }

    @Override
    public boolean solve(String input) {
        return isPermutationOfPalindrome(input);
    }
}
