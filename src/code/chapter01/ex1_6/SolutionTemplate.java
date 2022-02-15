package chapter01.ex1_6;

import utils.architecture.SolutionStrategy;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class SolutionTemplate implements SolutionStrategy {
    public static final String PROBLEM = "Chapter 1 - Ex 1_6: String Compression";

    /**
     * Chapter 1
     * Ex1_6: String Compression
     * Implement a method to perform basic string compression using the counts of repeated
     * characters. For example, the string "aabcccccaaa" would become "a1b1c5a3". If the compressed
     * string would not become smaller than the original string, your method should return the original
     * string. You can assume the string has only uppercase and lowercase letters (a-z).
     */
    @Override
    public void runSampleSolution() {
        String to_compress = "aaabbbcddaaAAAff";

        printBlue(getProblemName());
        System.out.println("The string " + colorYellow(to_compress) + " after compression becomes "
                + colorYellow(String.valueOf(solve(to_compress))) + ".");
    }

    public abstract String solve(String original);

    @Override
    public String getProblemName() {
        return PROBLEM;
    }
}
