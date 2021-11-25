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
     * Create a matrix of T objects generated through a supplier.
     * @param   params Set of parameters to use for generating the matrix.
     * @param   supplier The supplier function which generates the object T.
     * @return  A T[N][N] matrix.
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
     * Create a matrix of T objects generated through a supplier.
     * @param   N The matrix size
     * @param   supplier The supplier function which generates the object T.
     * @return  A T[N][N] matrix.
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
     * Create an array of T objects generated through a supplier.
     * @param   params Set of parameters to use for generating the array.
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
     * Create an array of T objects generated through a supplier.
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
