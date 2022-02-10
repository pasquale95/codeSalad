package chapter03.ex3_1.pre;

import chapter03.ex3_1.TestUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.exceptions.EmptyStackException;
import utils.exceptions.StackOverflowException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@Tag("Pre")
@DisplayName("Ex3_1: Three in One (Pre)")
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSolution {
    Solution sol;

    @BeforeAll
    void setup() {
        sol = new Solution(TestUtils.STACK_SIZE);
    }

    @ParameterizedTest(name = "Performing a push of number {0} on \"stack {1}\":")
    @MethodSource("chapter03.ex3_1.TestUtils#getParametersPush")
    @Order(1)
    void checkPush(Integer number, Integer stackNumber) throws StackOverflowException {
        sol.pushToStack(number, stackNumber);
    }

    @ParameterizedTest(name = "Performing a pop from \"stack {1}\" to get {0}:")
    @MethodSource("chapter03.ex3_1.TestUtils#getParametersPop")
    @Order(2)
    void checkPop(Integer number, Integer stackNumber) throws EmptyStackException {
        assertEquals(number, sol.popFromStack(stackNumber));
    }
}
