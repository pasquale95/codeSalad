package utils;

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
}
