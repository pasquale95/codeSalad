package chapter03;

import chapter03.ex3_1.Before;
import chapter03.ex3_1.After;
import utils.EmptyStackException;
import utils.StackOverflowException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Ex3_1 {

    public static final int STACK_ONE = 0, STACK_TWO = 1, STACK_THREE = 2;

    @Test
    @Order(1)
    void checkTripleStackBefore() throws StackOverflowException, EmptyStackException {
        Before.allocateStack(6);
        Before.pushToStack(1, STACK_ONE);
        Before.pushToStack(3, STACK_ONE);
        Before.pushToStack(5, STACK_TWO);
        Before.pushToStack(6, STACK_THREE);
        Before.pushToStack(10, STACK_THREE);
        Before.pushToStack(13, STACK_THREE);
        assertEquals(3, Before.popFromStack(STACK_ONE));
        assertEquals(5, Before.popFromStack(STACK_TWO));
        assertEquals(1, Before.popFromStack(STACK_ONE));
        assertThrows(EmptyStackException.class, () -> Before.popFromStack(STACK_TWO));
        Before.pushToStack(20, STACK_ONE);
        Before.pushToStack(22, STACK_TWO);
        Before.pushToStack(24, STACK_TWO);
        assertThrows(StackOverflowException.class, () -> Before.pushToStack(1, STACK_ONE));
        assertEquals(13, Before.popFromStack(STACK_THREE));
        assertEquals(20, Before.popFromStack(STACK_ONE));
    }

    @Test
    @Order(2)
    void checkTripleStackAfter() throws StackOverflowException, EmptyStackException {
        After.allocateStack(6);
        After.pushToStack(1, STACK_ONE);
        After.pushToStack(3, STACK_ONE);
        After.pushToStack(5, STACK_TWO);
        After.pushToStack(6, STACK_THREE);
        After.pushToStack(10, STACK_THREE);
        After.pushToStack(13, STACK_THREE);
        assertEquals(3, After.popFromStack(STACK_ONE));
        assertEquals(5, After.popFromStack(STACK_TWO));
        assertEquals(1, After.popFromStack(STACK_ONE));
        assertThrows(EmptyStackException.class, () -> After.popFromStack(STACK_TWO));
        After.pushToStack(20, STACK_ONE);
        After.pushToStack(22, STACK_TWO);
        After.pushToStack(24, STACK_TWO);
        assertThrows(StackOverflowException.class, () -> After.pushToStack(1, STACK_ONE));
        assertEquals(13, After.popFromStack(STACK_THREE));
        assertEquals(20, After.popFromStack(STACK_ONE));
    }
}
