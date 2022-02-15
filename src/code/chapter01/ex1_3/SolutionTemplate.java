package chapter01.ex1_3;

import utils.architecture.SolutionStrategy;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;
import static utils.generators.StringGenerator.toCharsWithExtraRoom;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class SolutionTemplate implements SolutionStrategy {
    public static final String PROBLEM = "Chapter 1 - Ex 1_3: URLify";
    private final char[] input;
    private final Integer trueLength;

    public SolutionTemplate(char[] input, Integer trueLength) {
        this.input = input;
        this.trueLength = trueLength;
    }

    @Override
    public void run() {
        urlify(input, trueLength);
    }

    /**
     * Chapter 1
     * Ex1_3: URLify
     * Write a method to replace all spaces in a string with '%20'. You may
     * assume that the string has sufficient space at the end to hold the additional
     * characters, and that you are given the "true" length of the string.
     *
     * NOTE: if implementing in Java, please use a character array so that you can
     * perform this operation in place.
     */
    @Override
    public void runSampleSolution() {
        String input = "Mr John Smith";

        printBlue(getProblemName());
        System.out.println(
                colorYellow('"' + input + '"')
                + " urlified: "
                + colorYellow(urlify(toCharsWithExtraRoom(input), input.length())) + "."
        );
    }

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    public abstract String urlify(char[] input, Integer trueLength);
}
