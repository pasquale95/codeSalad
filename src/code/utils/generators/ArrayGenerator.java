package utils.generators;

import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.util.function.Supplier;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class ArrayGenerator {

    /**
     * Generate an array of random integers.
     * @param   N The matrix size
     * @param   supplier The supplier function mapping an integer to the object T.
     * @return  A NxN matrix with random generated values.
     */
    @SuppressWarnings("unchecked")
    public static <T> T[][] generateObjectMatrix(
            int N,
            Supplier<T> supplier,
            Class<T> clazz
    ) {
        T[][] matrix = (T[][]) Array.newInstance(clazz, N, N);
        for (int i = 0; i < N; i++) {
            matrix[i] = generateObjectArray(N, supplier, clazz);
        }
        return matrix;
    }

    /**
     * Generate an array of random integers.
     * @param   params Set of parameters to use for generating a random string.
     * @param   supplier The supplier function mapping an integer to the object T.
     * @return  A NxN matrix with random generated values.
     */
    public static <T> T[][] generateObjectMatrix(
            JSONObject params,
            Supplier<T> supplier,
            Class<T> clazz
    ) {
        return generateObjectMatrix(
                ((Long) params.get("arraySize")).intValue(),
                supplier,
                clazz
        );
    }

    /**
     * Generate an array of random objects using a random integer array as baseline and mapping random values
     * through a supplier.
     * @param   params Set of parameters to use for generating a random string.
     * @param   supplier The supplier function mapping an integer to the object T.
     * @param   clazz The object class.
     * @return  An array of objects T[].
     */
    public static <T> T[] generateObjectArray(
            JSONObject params,
            Supplier<T> supplier,
            Class<T> clazz
    ) {
        return generateObjectArray(
                ((Long) params.get("arraySize")).intValue(),
                supplier,
                clazz
        );
    }

    /**
     * Generate an array of random objects using a random integer array as baseline and mapping random values
     * through a supplier.
     * @param   arraySize The array size.
     * @param   supplier The supplier function mapping an integer to the object T
     * @param   clazz The object class
     * @return  An array of objects T[].
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] generateObjectArray(
            int arraySize,
            Supplier<T> supplier,
            Class<T> clazz
    ) {
        T[] array = (T[]) Array.newInstance(clazz, arraySize);
        for (int i = 0; i < arraySize; i++) {
            array[i] = supplier.get();
        }
        return array;
    }
}
