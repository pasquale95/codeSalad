package chapter01.ex1_4;

import utils.architecture.ProblemTemplate;

import java.lang.reflect.Method;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Problem extends ProblemTemplate {
    public static final String PROBLEM = "Chapter 1 - Ex 1.4: Palindrome Permutation";
    public static final String input = "Tact Coa";

    /**
     * Chapter 1
     * Ex1_4: Palindrome Permutation
     * Given a string, write a function to check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards.
     * A permutation is a rearrangement of letters.
     * The palindrome does not need to be limited to just dictionary words.
     * You can ignore casing and non-letter characters.
     */
    public void runSolution(Method m) throws Exception {
        printBlue(getProblemName());
        System.out.println(colorYellow('"' + input + '"') + " is a permutation of a palindrome: " +
                colorYellow(String.valueOf(m.invoke(null, input))) + ".");
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(chapter01.ex1_4.pre.Solution.class.getMethod(
                "isPermutationOfPalindrome", String.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(chapter01.ex1_4.post.Solution.class.getMethod(
                "isPermutationOfPalindrome", String.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
