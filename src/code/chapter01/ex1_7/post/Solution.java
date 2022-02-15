package chapter01.ex1_7.post;

import chapter01.ex1_7.SolutionTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    public Solution(Integer[][] matrix) {
        super(matrix);
    }

    /**
     * Complexity: O(n^2)
     *
     * Rotate the matrix of 90°.
     * @param   matrix The matrix to rotate.
     */
    @Override
    public void rotateMatrix(Integer[][] matrix) {
        staticRotateMatrix(matrix);
    }

    public static void staticRotateMatrix(Integer[][] matrix) {
        int N = matrix.length, tmp;
        for (int layer = 0; layer < N / 2; layer++) {
            for (int x = layer; x < N - 1 - layer; x++) {
                tmp = matrix[layer][x];
                matrix[layer][x] = matrix[N - 1 - x][layer];
                matrix[N - 1 - x][layer] = matrix[N - 1 - layer][N - 1 - x];
                matrix[N - 1 - layer][N - 1 - x] = matrix[x][N - 1 - layer];
                matrix[x][N - 1 - layer] = tmp;
            }
        }
    }
}