package chapter03;

import chapter03.ex3_5.post.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.generators.ArrayGenerator;
import utils.Stack;
import utils.generators.RandomGenerator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Ex3_5 {

    private static Stack<Integer> stack, sorted;

    @BeforeEach
    void init() {
        stack = new Stack<>();
        Integer[] numbers = ArrayGenerator.generateObjectArray(
                10,
                () -> RandomGenerator.randomIntegerGenerator(1000),
                Integer.class
        );
        for (int n : numbers) {
            stack.push(n);
        }
        sorted = new Stack<>();
        Arrays.sort(numbers);
        for (int i = numbers.length - 1; i >= 0; i--) {
            sorted.push(numbers[i]);
        }
    }

    @Test
    @Order(1)
    void sortStackBefore() {
        chapter03.ex3_5.pre.Solution.sortStack(stack);
        assertEquals(sorted, stack);
    }

    @Test
    @Order(2)
    void sortStackAfter() {
        Solution.sortStack(stack);
        assertEquals(sorted, stack);
    }
}
