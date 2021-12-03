package chapter02.ex2_1;

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
@Tag("After")
@DisplayName("Ex2.1: Remove Dups (After)")
public class TestAfter {

    @ParameterizedTest(name = "(Question A) Removing duplicates from \"{1}\" to become \"{0}\":")
    @MethodSource("chapter02.ex2_1.TestUtils#getParameters")
    void checkA(LinkedListNode<Integer> expected, LinkedListNode<Integer> input) {
        After.removeDuplicatesA(input);
        assertEquals(expected, input);
    }

    @ParameterizedTest(name = "(Question B) Removing duplicates from \"{1}\" to become \"{0}\":")
    @MethodSource("chapter02.ex2_1.TestUtils#getParameters")
    void checkB(LinkedListNode<Integer> expected, LinkedListNode<Integer> input) {
        After.removeDuplicatesB(input);
        assertEquals(expected, input);
    }
}
