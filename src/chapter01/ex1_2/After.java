package chapter01.ex1_2;

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
                arePermutations(input[i], input[j]);
            }
        }
    }

    /**
     * Constraint 1: we can assume that the string only contains ASCII chars (128 totally).
     * Constraint 2: capital letters count the same as lowercase
     *
     * @param first
     * @param second
     * @return boolean
     */
    public static boolean arePermutations(String first, String second) {
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
            if (characterOccurrence < 0) {
                return false;
            }
        }
        return true;
    }

}
