package chapter01.ex1_4;

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
    public static final String PROBLEM = "Chapter 1 - Ex 1_4: Palindrome Permutation";
    private final String input;

    public SolutionTemplate(String input) {
        this.input = input;
    }

    /**
     * Chapter 1
     * Ex1_4: Palindrome Permutation
     * Given a string, write a function to check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards.
     * A permutation is a rearrangement of letters.
     * The palindrome does not need to be limited to just dictionary words.
     * You can ignore casing and non-letter characters.
     */
    @Override
    public void runSampleSolution() {
        String input = "Tact Coa";

        printBlue(getProblemName());
        System.out.println(colorYellow('"' + input + '"') + " is a permutation of a palindrome: " +
                colorYellow(String.valueOf(isPermutationOfPalindrome(input))) + ".");
    }

    @Override
    public void run() {
        isPermutationOfPalindrome(input);
    }

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    public abstract boolean isPermutationOfPalindrome(String input);
}
