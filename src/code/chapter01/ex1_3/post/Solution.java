package chapter01.ex1_3.post;

import chapter01.ex1_3.SolutionTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    public Solution(char[] input, Integer trueLength) {
        super(input, trueLength);
    }

    /**
     * Complexity: O(n)
     *
     * @param   input The input char array with extra spaces for additional chars.
     * @param   trueLength The real string length.
     * @return  The urlified string.
     */
    @Override
    public String urlify(char[] input, Integer trueLength) {
        return staticUrlify(input, trueLength);
    }

    public static String staticUrlify(char[] input, Integer trueLength) {
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
    private static int countSpaces(char[] chars, Integer end) {
        int times = 0;
        for (int i = 0; i < end; i++) {
            if (chars[i] == ' ') {
                times++;
            }
        }
        return times;
    }
}
