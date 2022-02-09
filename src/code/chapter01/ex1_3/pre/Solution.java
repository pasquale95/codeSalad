package chapter01.ex1_3.pre;

import chapter01.ex1_3.SolutionTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

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
     * Assumption 1: cannot use an additional variable
     * Complexity: O(n^2)
     *
     * @param   input The input char array with extra spaces for additional chars.
     * @param   trueLength The real string length.
     * @return  The urlified string.
     */
    public static String urlify(char[] input, int trueLength) {
        for (int i = 0; i < trueLength; i++) {
            if (input[i] == ' ') {
                for (int j = input.length - 1; j > i+2; j--) {
                    input[j] = input[j-2];
                }
                input[i] = '%';
                input[i+1] = '2';
                input[i+2] = '0';
                i+=2;
                trueLength+=2;
            }
        }
        return String.valueOf(input);
    }

    @Override
    public String solve(char[] input, int trueLength) {
        return urlify(input, trueLength);
    }
}
