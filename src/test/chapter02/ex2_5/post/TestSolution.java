package chapter02.ex2_5.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@Tag("Post")
@DisplayName("Ex2_5: Sum Lists (Post)")
public class TestSolution {
    Solution sol;

    @BeforeEach
    public void setup() {
        sol = new Solution(null);
    }

    @ParameterizedTest(name = "Checking that reverse sum of \"{1}\" and \"{2}\" is \"{0}\":")
    @MethodSource("chapter02.ex2_5.TestUtils#getParametersReverseOrderSum")
    void checkReverseOrderSum(
            LinkedListNode<Integer> expected,
            LinkedListNode<Integer> addend1,
            LinkedListNode<Integer> addend2
    ) {
            assertEquals(expected, sol.reverseOrderSum(addend1, addend2));
    }

    @ParameterizedTest(name = "Checking that forward sum of \"{1}\" and \"{2}\" is \"{0}\":")
    @MethodSource("chapter02.ex2_5.TestUtils#getParametersForwardOrderSum")
    void checkForwardOrderSum(
            LinkedListNode<Integer> expected,
            LinkedListNode<Integer> addend1,
            LinkedListNode<Integer> addend2
    ) {
        assertEquals(expected, sol.forwardOrderSum(addend1, addend2));
    }
}
