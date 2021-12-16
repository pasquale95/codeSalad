package chapter02.ex2_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedListNode;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@Tag("After")
@DisplayName("Ex2.5: Sum Lists (After)")
public class TestAfter {

    @ParameterizedTest(name = "Checking that sum in {0} mode of \"{2}\" and \"{3}\" is \"{1}\":")
    @MethodSource("chapter02.ex2_5.TestUtils#getParameters")
    void check(
            String order,
            LinkedListNode<Integer> expected,
            LinkedListNode<Integer> addend1,
            LinkedListNode<Integer> addend2
    ) {
        if (order.equals("reverse")) {
            assertEquals(expected, After.reverseOrderSum(addend1, addend2));
        } else {
            assertEquals(expected, After.forwardOrderSum(addend1, addend2));
        }
    }
}
