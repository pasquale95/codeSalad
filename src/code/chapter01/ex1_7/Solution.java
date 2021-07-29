package chapter01.ex1_7;

import org.json.simple.JSONObject;
import utils.ArrayGenerator;
import utils.Timer;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution {

    private static final String PROBLEM = "Chapter 1. Ex 1.7";
    private static final int N = 6;

    /**
     * Chapter 1
     * Ex1.1: Rotate Matrix
     * Given an image represented by an N x N matrix, where each pixel in the image
     * is represented by an integer, write a method to rotate the image by 90 degrees.
     * Can you do this in place?
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        int[][] matrix = ArrayGenerator.generateRandomMatrix(N, 100);
        System.out.println("The matrix before rotation: ");
        printMatrix(matrix);
        After.rotateMatrix(matrix);
        System.out.println("The matrix after rotation: ");
        printMatrix(matrix);
    }

    public static void time(JSONObject params) {
        int[][] matrix = ArrayGenerator.generateRandomMatrix(params);
        Before before = new Before(matrix);
        After after = new After(matrix);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int number: row) {
                sb.append(String.format("%02d", number)).append("|");
            }
            sb.append("\n");
        }
        System.out.print(colorYellow(sb.toString()));
    }
}