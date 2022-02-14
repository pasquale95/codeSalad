package chapter03.ex3_5.pre;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@Tag("Pre")
@DisplayName("Ex3_5: Sort Stack (Pre)")
public class TestSolution {

    @ParameterizedTest(name = "Sorting stack {0} to {1}:")
    @MethodSource("chapter03.ex3_5.TestUtils#getParameters")
    void checkAdd(Stack<Integer> stack, Stack<Integer> expected) {
        Solution.staticSortStack(stack);
        assertEquals(stack, expected);
    }
}
