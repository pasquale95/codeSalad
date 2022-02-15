package chapter01.ex1_2;

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
    public static final String PROBLEM = "Chapter 1 - Ex 1_2: Check permutations";
    private final String[] input;

    public SolutionTemplate(String[] input) {
        this.input = input;
    }

    /**
     * Chapter 1
     * Ex1_2: Check permutations
     * Given two strings, write a method to decide if one
     * is a permutation of the other.
     */
    @Override
    public void runSampleSolution() {
        String[] strings = {"stressed", "School master", "desserts", "The classroom"};

        printBlue(getProblemName());
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                System.out.println(colorYellow('"' + strings[i] + '"')
                        + " and " + colorYellow('"' + strings[j] + '"')
                        + " are permutations: "
                        + colorYellow(String.valueOf(arePermutations(strings[i], strings[j])))
                        + "."
                );
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                arePermutations(input[i], input[j]);
            }
        }
    }

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    public abstract boolean arePermutations(String first, String second);
}
