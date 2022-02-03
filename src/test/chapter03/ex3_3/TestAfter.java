package chapter03.ex3_3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.exceptions.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@Tag("After")
@DisplayName("Ex3.3: Stack of plates (After)")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class TestAfter {

    After.SetOfStacks setOfStacks = null;

    @BeforeAll
    void setup() {
        setOfStacks = new After.SetOfStacks(TestUtils.THRESHOLD);
    }

    @ParameterizedTest(name = "Performing push of number {0}:")
    @MethodSource("chapter03.ex3_3.TestUtils#getParametersPush")
    @Order(1)
    void checkPush(Integer number) {
        setOfStacks.push(number);
    }

    @ParameterizedTest(name = "Performing popAt from \"stack {1}\" and expecting {0}:")
    @MethodSource("chapter03.ex3_3.TestUtils#getParametersPopAt")
    @Order(2)
    void checkPopAt(Integer number, Integer stack) throws EmptyStackException {
        assertEquals(number, setOfStacks.popAt(stack));
    }

    @ParameterizedTest(name = "Performing pop expecting {0}:")
    @MethodSource("chapter03.ex3_3.TestUtils#getParametersPop")
    @Order(3)
    void checkPop(Integer number) throws EmptyStackException {
        assertEquals(number, setOfStacks.pop());
    }
}
