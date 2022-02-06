package chapter02.ex2_3.pre;

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
@DisplayName("Ex2_3: Delete Middle Node (Pre)")
public class TestSolution {

    @ParameterizedTest(name = "Pruning from \"{1}\" to get \"{0}\":")
    @MethodSource("chapter02.ex2_3.TestUtils#getParameters")
    void check(LinkedListNode<Integer> expected, LinkedListNode<Integer> input, LinkedListNode<Integer> toPrune) {
        Solution.removeLinkedListNode(toPrune);
        assertEquals(expected, input);
    }
}
