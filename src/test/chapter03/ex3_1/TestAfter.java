package chapter03.ex3_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
public class TestAfter {

    @BeforeAll
    static void setup() {
        After.allocateStack(TestUtils.STACK_SIZE);
    }

    @ParameterizedTest(name = "Performing a {0} on stack {2} to {0} \"{1}\":")
    @MethodSource("chapter03.ex3_1.TestUtils#getParameters")
    void check(String operation, Integer number, Integer stack) throws EmptyStackException, StackOverflowException {
        if (operation.equals("pop")) {
            assertEquals(number, After.popFromStack(stack));
        } else {
            After.pushToStack(number, stack);
        }
    }
}
