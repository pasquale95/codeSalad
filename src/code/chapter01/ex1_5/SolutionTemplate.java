package chapter01.ex1_5;

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
    public static final String PROBLEM = "Chapter 1 - Ex 1_5: One Away";
    private final String[] input;

    public SolutionTemplate(String[] input) {
        this.input = input;
    }

    /**
     * Chapter 1
     * Ex1_5: One Away
     * There are three types of edits that can be performed on strings:
     * insert a character, remove a character, or replace a character.
     * Given two strings, write a function to check if they are one edit
     * (or zero edits) away.
     */
    @Override
    public void runSampleSolution() {
        String one = "pales";
        String two = "pale";
        String three = "ple";

        printBlue(getProblemName());
        System.out.println("The strings " + colorYellow(one) + " and " + colorYellow(two) +
                " are one edit away: " + colorYellow(String.valueOf(areOneAway(one, two))) + ".");
        System.out.println("The strings " + colorYellow(one) + " and " + colorYellow(three) +
                " are one edit away: " + colorYellow(String.valueOf(areOneAway(one, three))) + ".");
        System.out.println("The strings " + colorYellow(two) + " and " + colorYellow(three) +
                " are one edit away: " + colorYellow(String.valueOf(areOneAway(two, three))) + ".");
    }

    @Override
    public void run() {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                areOneAway(input[i], input[j]);
            }
        }
    }

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    public abstract boolean areOneAway(String one, String two);
}
