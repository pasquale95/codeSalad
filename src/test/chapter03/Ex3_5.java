package chapter03;

import chapter03.ex3_5.Before;
import chapter03.ex3_5.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.ArrayGenerator;
import utils.Stack;

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
        int[] numbers = ArrayGenerator.generateRandomIntArray(10, 1000);
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
        Before.sortStack(stack);
        assertEquals(sorted, stack);
    }

    @Test
    @Order(2)
    void sortStackAfter() {
        After.sortStack(stack);
        assertEquals(sorted, stack);
    }
}