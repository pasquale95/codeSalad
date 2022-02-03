package chapter03.ex3_2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
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
@DisplayName("Ex3.2: Stack Min (After)")
public class TestAfter {


    @ParameterizedTest(name = "Performing push of number {0}:")
    @MethodSource("chapter03.ex3_2.TestUtils#getParametersPush")
    @Order(1)
    void checkPush(Integer number) {
        After.push(number);
    }

    @ParameterizedTest(name = "Performing pop expecting number {0}:")
    @MethodSource("chapter03.ex3_2.TestUtils#getParametersPop")
    @Order(2)
    void checkPop(Integer number) throws EmptyStackException {
        assertEquals(number, After.pop());
    }

    @ParameterizedTest(name = "Performing min expecting {0}:")
    @MethodSource("chapter03.ex3_2.TestUtils#getParametersMin")
    @Order(3)
    void checkMin(Integer number) throws EmptyStackException {
        assertEquals(number, After.min());
    }
}
