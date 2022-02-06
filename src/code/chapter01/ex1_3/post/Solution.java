package chapter01.ex1_3.post;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution implements Runnable {

    private final char[] input;
    private final int trueLength;

    public Solution(char[] input, int trueLength) {
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
     * @param   input The input char array with extra spaces for additional chars.
     * @param   trueLength The real string length.
     * @return  The urlified string.
     */
    public static String urlify(char[] input, int trueLength) {
        int finalLength = trueLength + 2*countSpaces(input, trueLength) - 1;

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
     * Count how many times the space appears in a char array subset.
     *
     * @param   chars The input char array with extra spaces for additional chars.
     * @param   end The last index (excluded) to check.
     * @return  The number of spaces in the passed char array.
     */
    private static int countSpaces(char[] chars, int end) {
        int times = 0;
        for (int i = 0; i < end; i++) {
            if (chars[i] == ' ') {
                times++;
            }
        }
        return times;
    }
}
