package chapter01.ex1_5;

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
    public static final String PROBLEM = "Chapter 1 - Ex 1.5: One Away";
    public static final String one = "pales";
    public static final String two = "pale";
    public static final String three = "ple";

    /**
     * Chapter 1
     * Ex1_5: One Away
     * There are three types of edits that can be performed on strings:
     * insert a character, remove a character, or replace a character.
     * Given two strings, write a function to check if they are one edit
     * (or zero edits) away.
     */
    public void runSolution(Method m) throws Exception {
        printBlue(getProblemName());
        System.out.println("The strings " + colorYellow(one) + " and " + colorYellow(two) +
                " are one edit away: " + colorYellow(String.valueOf(m.invoke(null, one, two))) + ".");
        System.out.println("The strings " + colorYellow(one) + " and " + colorYellow(three) +
                " are one edit away: " + colorYellow(String.valueOf(m.invoke(null, one, three))) + ".");
        System.out.println("The strings " + colorYellow(two) + " and " + colorYellow(three) +
                " are one edit away: " + colorYellow(String.valueOf(m.invoke(null, two, three))) + ".");
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(chapter01.ex1_5.pre.Solution.class.getMethod(
                "areOneAway", String.class, String.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(chapter01.ex1_5.post.Solution.class.getMethod(
                "areOneAway", String.class, String.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
