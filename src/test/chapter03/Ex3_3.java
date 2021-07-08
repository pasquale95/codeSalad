package chapter03;

import chapter03.ex3_3.After;
import chapter03.ex3_3.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Ex3_3 {

    public static final int THRESHOLD = 3;
    public static final int[] NUMBERS = {1, 3, 5, 6, 10, 13, 12, 11, 1, 93};

    @Test
    @Order(1)
    void checkStackOfPlatesBefore() throws EmptyStackException {
        Before.SetOfStacks setOfStacks = new Before.SetOfStacks(THRESHOLD);
        for (int number : NUMBERS) {
            setOfStacks.push(number);
        }
        assertEquals(93, setOfStacks.pop());
        assertEquals(1, setOfStacks.pop());
        assertEquals(5, setOfStacks.popAt(0));
        setOfStacks.push(45);
        assertEquals(13, setOfStacks.popAt(1));
        assertEquals(45, setOfStacks.pop());
        while (!setOfStacks.isEmpty()) {
            setOfStacks.pop();
        }
        assertThrows(EmptyStackException.class, setOfStacks::pop);
    }

    @Test
    @Order(2)
    void checkStackOfPlatesAfter() throws EmptyStackException {
        After.SetOfStacks setOfStacks = new After.SetOfStacks(THRESHOLD);
        for (int number : NUMBERS) {
            setOfStacks.push(number);
        }
        assertEquals(93, setOfStacks.pop());
        assertEquals(1, setOfStacks.pop());
        assertEquals(5, setOfStacks.popAt(0));
        setOfStacks.push(45);
        assertEquals(13, setOfStacks.popAt(1));
        assertEquals(45, setOfStacks.pop());
        while (!setOfStacks.isEmpty()) {
            setOfStacks.pop();
        }
        assertThrows(EmptyStackException.class, setOfStacks::pop);
    }
}
