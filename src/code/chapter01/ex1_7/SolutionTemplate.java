package chapter01.ex1_7;

import utils.architecture.SolutionStrategy;
import utils.generators.ArrayGenerator;
import utils.generators.RandomGenerator;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class SolutionTemplate implements SolutionStrategy {
    private static final String PROBLEM = "Chapter 1 - Ex 1_7: Rotate Matrix";

    /**
     * Chapter 1
     * Ex1_7: Rotate Matrix
     * Given an image represented by an N x N matrix, where each pixel in the image
     * is represented by an integer, write a method to rotate the image by 90 degrees.
     * Can you do this in place?
     */
    @Override
    public void runSampleSolution() {
        int n = 6;

        printBlue(getProblemName());
        Integer[][] matrix = ArrayGenerator.generateObjectMatrix(
                n,
                () -> RandomGenerator.randomIntegerGenerator(100),
                Integer.class
        );
        System.out.println("The matrix before rotation: ");
        printMatrix(matrix);
        solve(matrix);
        System.out.println("The matrix after rotation: ");
        printMatrix(matrix);
    }

    public abstract void solve(Integer[][] matrix);

    @Override
    public String getProblemName() {
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
