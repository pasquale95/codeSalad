package chapter03;

import chapter03.ex3_2.pre.Solution;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.exceptions.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Ex3_2 {

    public static final int[] numbers = {10, 3, 5, 6, 2, 10, 2, 1, 11, 13};

    @Test
    @Order(1)
    void stackMinBefore() throws EmptyStackException {
        for (int number : numbers) {
            Solution.push(number);
        }
        assertEquals(13, Solution.pop());
        assertEquals(1, Solution.min());
        assertEquals(11, Solution.pop());
        assertEquals(1, Solution.min());
        assertEquals(1, Solution.pop());
        assertEquals(2, Solution.min());
        assertEquals(2, Solution.pop());
        assertEquals(2, Solution.min());
        while (!Solution.isEmpty()) {
            Solution.pop();
        }
        assertThrows(EmptyStackException.class, Solution::pop);
    }

    @Test
    @Order(2)
    void stackMinAfter() throws EmptyStackException {
        for (int number : numbers) {
            chapter03.ex3_2.post.Solution.push(number);
        }
        assertEquals(13, chapter03.ex3_2.post.Solution.pop());
        assertEquals(1, chapter03.ex3_2.post.Solution.min());
        assertEquals(11, chapter03.ex3_2.post.Solution.pop());
        assertEquals(1, chapter03.ex3_2.post.Solution.min());
        assertEquals(1, chapter03.ex3_2.post.Solution.pop());
        assertEquals(2, chapter03.ex3_2.post.Solution.min());
        assertEquals(2, chapter03.ex3_2.post.Solution.pop());
        assertEquals(2, chapter03.ex3_2.post.Solution.min());
        while (!chapter03.ex3_2.post.Solution.isEmpty()) {
            chapter03.ex3_2.post.Solution.pop();
        }
        assertThrows(EmptyStackException.class, chapter03.ex3_2.post.Solution::pop);
    }
}
