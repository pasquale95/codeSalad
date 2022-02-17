package chapter01.ex1_3.pre;

import chapter01.ex1_3.SolutionTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    /**
     * @see SolutionTemplate#SolutionTemplate(char[], Integer)
     */
    public Solution(char[] input, Integer trueLength) {
        super(input, trueLength);
    }

    /**
     * Complexity: O(n^2)
     * Assumption 1: cannot use an additional variable
     *
     * @param   input The input char array with extra spaces for additional chars.
     * @param   trueLength The real string length.
     * @return  The urlified string.
     */
    @Override
    public String urlify(char[] input, Integer trueLength) {
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
}
