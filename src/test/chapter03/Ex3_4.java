package chapter03;

import chapter03.ex3_4.After;
import chapter03.ex3_4.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.exceptions.EmptyQueueException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Ex3_4 {

    public static final int[] NUMBERS = {1, 3, 5, 6, 10, 13, 12, 11, 1, 93};

    @Test
    @Order(1)
    void queueViaStacksBefore() throws EmptyQueueException {
        Before.MyQueue myQueue = new Before.MyQueue();
        for (int number : NUMBERS) {
            myQueue.add(number);
        }
        assertEquals(1, myQueue.remove());
        assertEquals(3, myQueue.remove());
        assertEquals(5, myQueue.remove());
        myQueue.add(54);
        assertEquals(6, myQueue.peek());
        assertEquals(6, myQueue.remove());
        assertEquals(10, myQueue.peek());
        while (!myQueue.isEmpty()) {
            myQueue.remove();
        }
        assertThrows(EmptyQueueException.class, myQueue::remove);
    }

    @Test
    @Order(2)
    void queueViaStacksAfter() throws EmptyQueueException {
        After.MyQueue myQueue = new After.MyQueue();
        for (int number : NUMBERS) {
            myQueue.add(number);
        }
        assertEquals(1, myQueue.remove());
        assertEquals(3, myQueue.remove());
        assertEquals(5, myQueue.remove());
        myQueue.add(54);
        assertEquals(6, myQueue.peek());
        assertEquals(6, myQueue.remove());
        assertEquals(10, myQueue.peek());
        while (!myQueue.isEmpty()) {
            myQueue.remove();
        }
        assertThrows(EmptyQueueException.class, myQueue::remove);
    }
}
