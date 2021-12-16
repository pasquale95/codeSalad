package chapter02.ex2_6;

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
@Tag("Before")
@DisplayName("Ex2.6: Palindrome (Before)")
public class TestBefore {

    @ParameterizedTest(name = "Checking if {1} is palindrome:")
    @MethodSource("chapter02.ex2_6.TestUtils#getParameters")
    void check(Boolean expected, LinkedListNode<Integer> input) {
        assertEquals(expected, Before.isPalindrome(input));
    }
}
