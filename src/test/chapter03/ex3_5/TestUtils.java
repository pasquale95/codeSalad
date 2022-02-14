package chapter03.ex3_5;

import org.junit.jupiter.params.provider.Arguments;
import utils.Stack;
import utils.generators.ArrayGenerator;
import utils.generators.RandomGenerator;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class TestUtils {

    /**
     * @return Test arguments
     */
    private static Stream<Arguments> getParameters() {
        Stack<Integer> stack = new Stack<>();
        Integer[] numbers = ArrayGenerator.generateObjectArray(
                10,
                () -> RandomGenerator.randomIntegerGenerator(1000),
                Integer.class
        );
        for (int n : numbers) {
            stack.push(n);
        }
        Stack<Integer> sorted = new Stack<>();
        Arrays.sort(numbers);
        for (int i = numbers.length - 1; i >= 0; i--) {
            sorted.push(numbers[i]);
        }
        return Stream.of(
                Arguments.of(stack, sorted)
        );
    }
}
