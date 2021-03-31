package chapter01.ex1_4;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    private final String input;

    public After(String input) {
        this.input = input;
    }

    @Override
    public void run() {
        isPermutationOfPalindrome(input);
    }

    /**
     * Complexity: O(n)
     *
     * @param input
     */
    public static boolean isPermutationOfPalindrome(String input) {
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
