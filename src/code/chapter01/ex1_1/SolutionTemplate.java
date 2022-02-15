package chapter01.ex1_1;

import utils.architecture.SolutionStrategy;

import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class SolutionTemplate implements SolutionStrategy {
    private static final String PROBLEM = "Chapter 1 - Ex 1_1: Is unique";

    /**
     * Chapter 1
     * Ex1_1: Is unique
     * Question A: Implement an algorithm to determine if a string has all unique characters.
     * Question B: What if you cannot use additional data structures?
     */
    @Override
    public void runSampleSolution() {
        String[] strings = {"genetics", "salt", "castle", "controlled"};

        printBlue(getProblemName());
        printYellow("QUESTION A");
        for (String string : strings) {
            System.out.println(colorYellow('"' + string + '"') + " has unique chars: "
                    + colorYellow(solveQuestionA(string) + ".")
            );
        }
        printYellow("QUESTION B");
        for (String string : strings) {
            System.out.println(colorYellow('"' + string + '"') + " has unique chars: "
                    + colorYellow(solveQuestionB(string) + ".")
            );
        }
    }

    protected abstract boolean solveQuestionA(String stringToCheck);

    protected abstract boolean solveQuestionB(String stringToCheck);

    @Override
    public String getProblemName() {
        return PROBLEM;
    }
}
