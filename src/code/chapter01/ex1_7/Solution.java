package chapter01.ex1_7;

import org.json.simple.JSONObject;
import utils.generators.ArrayGenerator;
import utils.architecture.ExerciseSolutions;
import utils.architecture.SolutionTemplate;
import utils.generators.RandomGenerator;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    private static final String PROBLEM = "Chapter 1. Ex 1.7";
    private static final int N = 6;

    /**
     * Chapter 1
     * Ex1.7: Rotate Matrix
     * Given an image represented by an N x N matrix, where each pixel in the image
     * is represented by an integer, write a method to rotate the image by 90 degrees.
     * Can you do this in place?
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        Integer[][] matrix = ArrayGenerator.generateObjectMatrix(
                N,
                () -> RandomGenerator.randomIntegerGenerator(100),
                Integer.class
        );
        System.out.println("The matrix before rotation: ");
        printMatrix(matrix);
        After.rotateMatrix(matrix);
        System.out.println("The matrix after rotation: ");
        printMatrix(matrix);
    }

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        Integer[][] matrix = ArrayGenerator.generateObjectMatrix(
                params,
                () -> RandomGenerator.randomIntegerGenerator(params),
                Integer.class
        );
        return new ExerciseSolutions(new Before(matrix), new After(matrix));
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