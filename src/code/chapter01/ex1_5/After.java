package chapter01.ex1_5;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    private final String[] input;

    public After(String[] input) {
        this.input = input;
    }

    @Override
    public void run() {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                areOneAway(input[i], input[j]);
            }
        }
    }

    /**
     * Complexity: O(n)
     *
     * @param one The first string to compare
     * @param two The second string to compare
     * @return True if the strings are one edit away.
     */
    public static boolean areOneAway(String one, String two) {
        int diff = one.length() - two.length();
        // check addition/removal edits
        if (Math.abs(diff) > 1) {
            return false;
        }
        boolean foundDifference = false;
        // check replace edits
        for (int i = 0, j = 0; i < one.length() && j < two.length(); i++, j++) {
            if (one.charAt(i) != two.charAt(j)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
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
