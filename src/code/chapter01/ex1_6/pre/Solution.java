package chapter01.ex1_6.pre;

import chapter01.ex1_6.SolutionTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    private final String[] originals;

    public Solution(String[] originals) {
        this.originals = originals;
    }

    @Override
    public void run() {
        for (String original : this.originals) {
            compress(original);
        }
    }

    /**
     * Complexity: O(n)
     *
     * @param   original The original string.
     * @return  The compressed string
     */
    public static String compress(String original) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        if (!original.isEmpty()) {
            char[] chars = original.toCharArray();
            char currentChar = chars[0];
            for (char c : chars) {
                if (c != currentChar) {
                    sb.append(currentChar).append(counter);
                    currentChar = c;
                    counter = 0;
                }
                counter++;
            }
            sb.append(currentChar).append(counter); // last char
        }
        String compressed = sb.toString();

        // return compressed string only if smaller than original
        if (compressed.length() < original.length()) {
            return compressed;
        } else {
            return original;
        }
    }

    @Override
    public String solve(String original) {
        return compress(original);
    }
}
