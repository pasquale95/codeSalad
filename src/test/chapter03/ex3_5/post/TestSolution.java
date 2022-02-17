package chapter03.ex3_5.post;

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
@Tag("Post")
@DisplayName("Ex3_5: Sort Stack (Post)")
public class TestSolution {
    Solution sol;

    @BeforeEach
    public void setup() {
        sol = new Solution(null);
    }

    @ParameterizedTest(name = "Sorting stack {0} to {1}:")
    @MethodSource("chapter03.ex3_5.TestUtils#getParameters")
    void checkAdd(Stack<Integer> stack, Stack<Integer> expected) {
        sol.sortStack(stack);
        assertEquals(stack, expected);
    }
}
