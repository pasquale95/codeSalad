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
        Before.pushFirstStack(1);
        Before.pushFirstStack(3);
        Before.pushSecondStack(5);
        Before.pushThirdStack(6);
        Before.pushThirdStack(10);
        Before.pushThirdStack(13);
        assertEquals(1, Before.popFirstStack());
        assertEquals(5, Before.popSecondStack());
        assertEquals(3, Before.popFirstStack());
        assertThrows(EmptyStackException.class, Before::popSecondStack);
        Before.pushSecondStack(20);
        Before.pushSecondStack(22);
        Before.pushSecondStack(24);
        assertThrows(StackOverflowException.class, () -> {Before.pushFirstStack(1);});
        assertEquals(6, Before.popThirdStack());
        assertEquals(20, Before.popSecondStack());
    }

    @Test
    @Order(2)
    void removeDuplicatesAfter() {

    }
}
