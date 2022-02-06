package chapter01.ex1_7;

import utils.architecture.ProblemTemplate;
import utils.generators.ArrayGenerator;
import utils.generators.RandomGenerator;

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
    private static final String PROBLEM = "Chapter 1 - Ex 1.7: Rotate Matrix";
    private static final int N = 6;

    /**
     * Chapter 1
     * Ex1_7: Rotate Matrix
     * Given an image represented by an N x N matrix, where each pixel in the image
     * is represented by an integer, write a method to rotate the image by 90 degrees.
     * Can you do this in place?
     */
    public void runSolution(Method m) throws Exception {
        printBlue(getProblemName());
        Integer[][] matrix = ArrayGenerator.generateObjectMatrix(
                N,
                () -> RandomGenerator.randomIntegerGenerator(100),
                Integer.class
        );
        System.out.println("The matrix before rotation: ");
        printMatrix(matrix);
        m.invoke(null, (Object) matrix);
        System.out.println("The matrix after rotation: ");
        printMatrix(matrix);
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(chapter01.ex1_7.pre.Solution.class.getMethod(
                "rotateMatrix", Integer[][].class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(chapter01.ex1_7.post.Solution.class.getMethod(
                "rotateMatrix", Integer[][].class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }

    private static void printMatrix(Integer[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (Integer[] row : matrix) {
            for (Integer number: row) {
                sb.append(String.format("%02d", number)).append("|");
            }
            sb.append("\n");
        }
        System.out.print(colorYellow(sb.toString()));
    }
}
