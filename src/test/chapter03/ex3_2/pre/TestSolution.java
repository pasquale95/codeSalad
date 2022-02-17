package chapter03.ex3_2.pre;

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
@Tag("Pre")
@DisplayName("Ex3_2: Stack Min (Pre)")
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSolution {
    Solution sol;

    @BeforeAll
    void setup() {
        sol = new Solution(null, null);
    }

    @ParameterizedTest(name = "Performing push of number {0}:")
    @MethodSource("chapter03.ex3_2.TestUtils#getParametersPush")
    @Order(1)
    void checkPush(Integer number) {
        sol.push(number);
    }

    @ParameterizedTest(name = "Performing pop expecting number {0}:")
    @MethodSource("chapter03.ex3_2.TestUtils#getParametersPop")
    @Order(2)
    void checkPop(Integer number) throws EmptyStackException {
        assertEquals(number, sol.pop());
    }

    @ParameterizedTest(name = "Performing min expecting {0}:")
    @MethodSource("chapter03.ex3_2.TestUtils#getParametersMin")
    @Order(3)
    void checkMin(Integer number) throws EmptyStackException {
        assertEquals(number, sol.min());
    }
}
