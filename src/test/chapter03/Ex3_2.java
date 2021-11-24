package chapter03;

import chapter03.ex3_2.Before;
import chapter03.ex3_2.After;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.Exceptions.EmptyStackException;

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
            Before.push(number);
        }
        assertEquals(13, Before.pop());
        assertEquals(1, Before.min());
        assertEquals(11, Before.pop());
        assertEquals(1, Before.min());
        assertEquals(1, Before.pop());
        assertEquals(2, Before.min());
        assertEquals(2, Before.pop());
        assertEquals(2, Before.min());
        while (!Before.isEmpty()) {
            Before.pop();
        }
        assertThrows(EmptyStackException.class, Before::pop);
    }

    @Test
    @Order(2)
    void stackMinAfter() throws EmptyStackException {
        for (int number : numbers) {
            After.push(number);
        }
        assertEquals(13, After.pop());
        assertEquals(1, After.min());
        assertEquals(11, After.pop());
        assertEquals(1, After.min());
        assertEquals(1, After.pop());
        assertEquals(2, After.min());
        assertEquals(2, After.pop());
        assertEquals(2, After.min());
        while (!After.isEmpty()) {
            After.pop();
        }
        assertThrows(EmptyStackException.class, After::pop);
    }
}
