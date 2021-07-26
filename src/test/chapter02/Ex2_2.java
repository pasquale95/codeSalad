package chapter02;

import chapter02.ex2_2.After;
import chapter02.ex2_2.Before;
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
class Ex2_2 {

    private static LinkedListNode head;

    @BeforeAll
    static void init() {
        // create linked list to clean
        head = new LinkedListNode(13);
        head.append(43).append(31).append(12).append(15).append(3).append(5);
    }

    @Test
    @Order(1)
    void returnKthToLastBefore() {
        LinkedListNode kth = Before.findKthToLast(head, 2);
        assertNotNull(kth);
        assertEquals(15, kth.getData());
        kth = Before.findKthToLast(head, 0);
        assertNotNull(kth);
        assertEquals(5, kth.getData());
        kth = Before.findKthToLast(head, 7);
        assertNull(kth);
    }

    @Test
    @Order(2)
    void returnKthToLastAfter() {
        LinkedListNode kth = After.findKthToLast(head, 2);
        assertNotNull(kth);
        assertEquals(15, kth.getData());
        kth = After.findKthToLast(head, 0);
        assertNotNull(kth);
        assertEquals(5, kth.getData());
        kth = After.findKthToLast(head, 7);
        assertNull(kth);
    }
}