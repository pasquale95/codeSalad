package chapter03.ex3_1;

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
@Tag("After")
@DisplayName("Ex3.1: Three in One (After)")
@TestMethodOrder(OrderAnnotation.class)
public class TestAfter {

    @BeforeAll
    static void setup() {
        After.allocateStack(TestUtils.STACK_SIZE);
    }

    @ParameterizedTest(name = "Performing a push of number {0} on \"stack {1}\":")
    @MethodSource("chapter03.ex3_1.TestUtils#getParameters")
    @Order(1)
    void checkPush(Integer number, Integer stackNumber) throws StackOverflowException {
        After.pushToStack(number, stackNumber);
    }

    @ParameterizedTest(name = "Performing a pop from \"stack {1}\" to get {0}:")
    @MethodSource("chapter03.ex3_1.TestUtils#getParameters")
    @Order(2)
    void checkPop(Integer number, Integer stackNumber) throws EmptyStackException {
        assertEquals(number, After.popFromStack(stackNumber));
    }
}
