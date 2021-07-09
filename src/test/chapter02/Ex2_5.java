package chapter02;

import chapter02.ex2_5.After;
import chapter02.ex2_5.Before;
import org.junit.jupiter.api.*;
import utils.LinkedListNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ex2_5 {

    private static LinkedListNode addend1, addend2, addend3, reverseSum1, forwardSum1, reverseSum2, forwardSum2;

    @BeforeAll
    static void init() {
        addend1 = new LinkedListNode(6);        // 6529
        addend1.append(5).append(2).append(9);
        addend2 = new LinkedListNode(8);        // 8567
        addend2.append(5).append(6).append(7);
        addend3 = new LinkedListNode(6);        // 64
        addend3.append(4);
        reverseSum1 = new LinkedListNode(4);    // 9256+7658=16914
        reverseSum1.append(1).append(9).append(6).append(1);
        forwardSum1 = new LinkedListNode(1);    // 6529+8567=15096
        forwardSum1.append(5).append(0).append(9).append(6);
        reverseSum2 = new LinkedListNode(2);    // 9256 + 46 = 9302
        reverseSum2.append(0).append(3).append(9);
        forwardSum2 = new LinkedListNode(6);    // 6529 + 64 = 6593
        forwardSum2.append(5).append(9).append(3);
    }

    @Test
    @Order(1)
    void sumListsBefore() {
        testEquals(reverseSum1, Before.reverseOrderSum(addend1, addend2));
        testEquals(forwardSum1, Before.forwardOrderSum(addend1, addend2));
        testEquals(reverseSum2, Before.reverseOrderSum(addend1, addend3));
        testEquals(forwardSum2, Before.forwardOrderSum(addend1, addend3));
    }

    @Test
    @Order(2)
    void sumListsAfter() {
        testEquals(reverseSum1, After.reverseOrderSum(addend1, addend2));
        testEquals(forwardSum1, After.forwardOrderSum(addend1, addend2));
        testEquals(reverseSum2, After.reverseOrderSum(addend1, addend3));
        testEquals(forwardSum2, After.forwardOrderSum(addend1, addend3));
    }

    private void testEquals(LinkedListNode expected, LinkedListNode given) {
        while (expected != null &&  given != null) {
            assertEquals(expected, given);
            expected = expected.getNext();
            given = given.getNext();
        }
        assertNull(expected);
        assertNull(given);
    }
}