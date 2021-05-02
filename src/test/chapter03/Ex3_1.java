package chapter03;

import chapter03.ex3_1.Before;
import chapter03.ex3_1.EmptyStackException;
import chapter03.ex3_1.StackOverflowException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.LinkedListNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Ex3_1 {

    private static LinkedListNode withDuplicates;
    private static LinkedListNode noDuplicates;

    @Test
    @Order(1)
    void checkTripleStackBefore() throws StackOverflowException, EmptyStackException {
        Before.allocateStack(6);
        Before.pushToStack(1, 1);
        Before.pushToStack(3, 1);
        Before.pushToStack(5, 2);
        Before.pushToStack(6, 3);
        Before.pushToStack(10, 3);
        Before.pushToStack(13, 3);
        assertEquals(1, Before.popFromStack(1));
        assertEquals(5, Before.popFromStack(2));
        assertEquals(3, Before.popFromStack(1));
        assertThrows(EmptyStackException.class, () -> {Before.popFromStack(2);});
        Before.pushToStack(20, 1);
        Before.pushToStack(22, 2);
        Before.pushToStack(24, 2);
        assertThrows(StackOverflowException.class, () -> {Before.pushToStack(1, 1);});
        assertEquals(6, Before.popFromStack(3));
        assertEquals(20, Before.popFromStack(1));
    }

    @Test
    @Order(2)
    void removeDuplicatesAfter() {

    }
}
