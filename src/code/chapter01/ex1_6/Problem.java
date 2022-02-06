package chapter01.ex1_6;

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
    public static final String PROBLEM = "Chapter 1 - Ex 1.6: String Compression";
    public static final String TO_COMPRESS = "aaabbbcddaaAAAff";

    /**
     * Chapter 1
     * Ex1_6: String Compression
     * Implement a method to perform basic string compression using the counts of repeated
     * characters. For example, the string "aabcccccaaa" would become "a1b1c5a3". If the compressed
     * string would not become smaller than the original string, your method should return the original
     * string. You can assume the string has only uppercase and lowercase letters (a-z).
     */
    public void runSolution(Method m) throws Exception {
        printBlue(getProblemName());
        System.out.println("The string " + colorYellow(TO_COMPRESS) + " after compression becomes "
                + colorYellow(String.valueOf(m.invoke(null, TO_COMPRESS))) + ".");
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(chapter01.ex1_6.pre.Solution.class.getMethod(
                "compress", String.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(chapter01.ex1_6.post.Solution.class.getMethod(
                "compress", String.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
