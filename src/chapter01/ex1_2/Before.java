package chapter01.ex1_2;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    private final String[] input;

    public Before(String[] input) {
        this.input = input;
    }

    @Override
    public void run() {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i; j < input.length; j++) {
                arePermutations(input[i], input[j]);
            }
        }
    }

    /**
     * Complexity: O(n log(n))
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
        String firstSorted = first.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String secondSorted = second.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return firstSorted.equals(secondSorted);
    }
}
