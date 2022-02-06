package chapter01.ex1_7.pre;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution implements Runnable {

    private final Integer[][] matrix;

    public Solution(Integer[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public void run() {
        rotateMatrix(matrix);
    }

    /**
     * Complexity: O(n^2)
     *
     * Rotate the matrix of 90°.
     * @param   matrix The matrix to rotate.
     */
    public static void rotateMatrix(Integer[][] matrix) {
        int N = matrix.length, x, y, toRotate, tmp;
        // move from most external layers to internal ones
        for (int k = 0; k < N / 2; k++) {
            y = k;
            // move only elements not already moved
            for (int i = k; i < N - 1 - k; i++) {
                x = i;
                toRotate = matrix[y][x];
                // 4 times as the matrix sides
                for (int j = 0; j < 4; j++) {
                    tmp = matrix[x][N - 1 - y];
                    matrix[x][N - 1 - y] = toRotate;
                    toRotate = tmp;
                    tmp = y;
                    y = x;
                    x = N - 1 - tmp;
                }
            }
        }
    }
}