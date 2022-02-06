package chapter01.ex1_1;

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
    private static final String PROBLEM = "Chapter 1 - Ex 1.1: Is unique";
    private static final String[] strings = {"genetics", "salt", "castle", "controlled"};

    /**
     * Chapter 1
     * Ex1_1: Is unique
     * Question A: Implement an algorithm to determine if a string has all unique characters.
     * Question B: What if you cannot use additional data structures?
     */
    public void runSolution(Method m) throws InvocationTargetException, IllegalAccessException {
        printBlue(getProblemName());
        for (String string : strings) {
            System.out.println(colorYellow('"' + string + '"') + " has unique chars: "
                    + colorYellow(m.invoke(null, string) + ".")
            );
        }
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(chapter01.ex1_1.pre.Solution.class.getMethod("isUniqueCharsB", String.class));
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(chapter01.ex1_1.post.Solution.class.getMethod("isUniqueCharsB", String.class));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
