package chapter03.ex3_4.pre;

import chapter03.ex3_3.TestUtils;
import chapter03.ex3_3.pre.SetOfStacks;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.exceptions.EmptyQueueException;
import utils.exceptions.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@Tag("Pre")
@DisplayName("Ex3_4: Queue via Stacks (Pre)")
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSolution {
    MyQueue myQueue;

    @BeforeAll
    void setup() {
        myQueue = new MyQueue();
    }

    @ParameterizedTest(name = "Adding number {0} to the queue:")
    @MethodSource("chapter03.ex3_4.TestUtils#getParametersAdd")
    @Order(1)
    void checkAdd(Integer number) {
        myQueue.add(number);
    }

    @ParameterizedTest(name = "Removing first element from queue and expecting {0}:")
    @MethodSource("chapter03.ex3_4.TestUtils#getParametersRemove")
    @Order(2)
    void checkRemove(Integer number) throws EmptyQueueException {
        assertEquals(number, myQueue.remove());
    }

    @ParameterizedTest(name = "Peek from queue and expecting {0}:")
    @MethodSource("chapter03.ex3_4.TestUtils#getParametersPeek")
    @Order(3)
    void checkPop(Integer number) throws EmptyQueueException {
        assertEquals(number, myQueue.peek());
    }
}
