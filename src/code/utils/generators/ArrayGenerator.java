package utils.generators;

import org.json.simple.JSONObject;

import java.util.Random;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class ArrayGenerator {

    /**
     * Generate an array of random integers.
     * @param   size The array size.
     * @param   ceiling The ceiling for the random function.
     * @return  The array of random integers.
     */
    public static int[] generateRandomIntArray(int size, int ceiling) {
        Random r = new Random();
        int[] integers = new int[size];
        for (int i = 0; i < size; i++) {
            integers[i] = r.nextInt(ceiling);
        }
        return integers;
    }

    /**
     * Generate an array of random integers.
     * @param   params Set of parameters to use for generating a random string.
     * @return  The array of random integers.
     */
    public static int[] generateRandomIntArray(JSONObject params) {
        return generateRandomIntArray(
                ((Long) params.get("size")).intValue(),
                ((Long) params.get("ceiling")).intValue()
        );
    }

    /**
     * Generate an array of random integers.
     * @param   N The matrix size
     * @param   ceiling The ceiling for the random function.
     * @return  A NxN matrix with random generated values.
     */
    public static int[][] generateRandomMatrix(int N, int ceiling) {
        int[][] matrix = new int[N][];
        for (int i = 0; i < N; i++) {
            matrix[i] = ArrayGenerator.generateRandomIntArray(N, ceiling);
        }
        return matrix;
    }

    /**
     * Generate an array of random integers.
     * @param   params Set of parameters to use for generating a random string.
     * @return  A NxN matrix with random generated values.
     */
    public static int[][] generateRandomMatrix(JSONObject params) {
        return generateRandomMatrix(
                ((Long) params.get("N")).intValue(),
                ((Long) params.get("ceiling")).intValue()
        );
    }

    /**
     * Generate an array of random booleans.
     * @param   size The array size.
     * @return  The array of random booleans.
     */
    public static boolean[] generateRandomBooleanArray(int size) {
        Random r = new Random();
        boolean[] booleans = new boolean[size];
        for (int i = 0; i < size; i++) {
            booleans[i] = (r.nextInt(2) % 2) == 0;
        }
        return booleans;
    }
}
