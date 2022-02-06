package chapter01.ex1_2;

import utils.architecture.ProblemTemplate;

import java.lang.reflect.InvocationTargetException;
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
    public static final String PROBLEM = "Chapter 1 - Ex 1.2: Check permutations";
    public static final String[] strings = {"stressed", "School master", "desserts", "The classroom"};

    /**
     * Chapter 1
     * Ex1_2: Check permutations
     * Given two strings, write a method to decide if one
     * is a permutation of the other.
     */
    public void runSolution(Method m) throws InvocationTargetException, IllegalAccessException {
        printBlue(getProblemName());
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                System.out.println(colorYellow('"' + strings[i] + '"')
                        + " and " + colorYellow('"' + strings[j] + '"')
                        + " are permutations: "
                        + colorYellow(String.valueOf(m.invoke(null, strings[i], strings[j])))
                        + "."
                );
            }
        }
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(chapter01.ex1_2.pre.Solution.class.getMethod(
                "arePermutations", String.class, String.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(chapter01.ex1_2.post.Solution.class.getMethod(
                "arePermutations", String.class, String.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
