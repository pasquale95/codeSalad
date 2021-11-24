package chapter01;

import chapter01.ex1_7.After;
import chapter01.ex1_7.Before;
import org.junit.jupiter.api.*;
import utils.generators.ArrayGenerator;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ex1_7 {

    int[][] matrix, backupMatrix;
    final int N = 10;

    @BeforeEach
    void init() {
        matrix = ArrayGenerator.generateRandomMatrix(N, 100);
        backupMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(matrix[i], 0, backupMatrix[i], 0, N);
        }
    }

    @Test
    @Order(1)
    void rotateMatrixBefore() {
        int x, y;
        Random r = new Random();
        Before.rotateMatrix(matrix);
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N);
            y = r.nextInt(N);
            assertEquals(backupMatrix[y][x], matrix[x][N - 1 - y]);
        }
    }

    @Test
    @Order(2)
    void rotateMatrixAfter() {
        int x, y;
        Random r = new Random();
        After.rotateMatrix(matrix);
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N);
            y = r.nextInt(N);
            assertEquals(backupMatrix[y][x], matrix[x][N - 1 - y]);
        }
    }
}