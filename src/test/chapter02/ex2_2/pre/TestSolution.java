package chapter02.ex2_2.pre;

import chapter02.ex2_2.post.Solution;
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
@Tag("Pre")
@DisplayName("Ex2_2: Return Kth to Last (Pre)")
public class TestSolution {
    Solution sol;

    @BeforeEach
    public void setup() {
        sol = new Solution(null, null);
    }

    @ParameterizedTest(name = "Checking that in \"{1}\" the kth element from last with k = {2} is \"{0}\":")
    @MethodSource("chapter02.ex2_2.TestUtils#getParameters")
    void check(Integer expected, LinkedListNode<Integer> input, Integer k) {
        LinkedListNode<Integer> kth = sol.findKthToLast(input, k);
        assertEquals(expected, kth != null ? kth.getData() : null);
    }
}
