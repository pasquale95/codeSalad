package chapter01.ex1_3;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    private final char[] input;
    private final int trueLength;

    public After(char[] input, int trueLength) {
        this.input = input;
        this.trueLength = trueLength;
    }

    @Override
    public void run() {
        urlify(input, trueLength);
    }

    /**
     * Complexity: O(n)
     *
     * @param input
     * @param trueLength
     */
    public static String urlify(char[] input, int trueLength) {
        int finalLength = trueLength + 2*countChar(input, ' ', 0, trueLength) - 1;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[finalLength--] = '0';
                input[finalLength--] = '2';
                input[finalLength--] = '%';
            } else {
                input[finalLength--] = input[i];
            }
        }
        return String.valueOf(input);
    }

    /**
     * Count how many times a char appears in a char array subset
     * between start (included) and end (excluded)
     *
     * @param chars
     * @param charToCount
     * @param start
     * @param end
     */
    private static int countChar(char[] chars, char charToCount, int start, int end) {
        int times = 0;
        for (int i = start; i < end; i++) {
            if (chars[i] == charToCount) {
                times++;
            }
        }
        return times;
    }
}
