package chapter02;

import chapter02.ex2_3.After;
import chapter02.ex2_3.Before;
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
class Ex2_3 {

    private static LinkedListNode head;
    private static LinkedListNode pruned;

    @BeforeAll
    static void init() {
        head = new LinkedListNode(13);
        head.append(43).append(31).append(12).append(15).append(3).append(5);
        pruned = new LinkedListNode(13);
        pruned.append(31).append(15).append(3).append(5);
    }

    @Test
    @Order(1)
    void deleteMiddleNodeBefore() {
        LinkedListNode clone = head.clone();
        LinkedListNode nodeToPrune = clone.getNext();
        Before.removeLinkedListNode(nodeToPrune);
        nodeToPrune = clone.getNext().getNext();
        Before.removeLinkedListNode(nodeToPrune);
        assertEquals(pruned, clone);
    }

    @Test
    @Order(2)
    void deleteMiddleNodeAfter() {
        LinkedListNode clone = head.clone();
        LinkedListNode nodeToPrune = clone.getNext();
        After.removeLinkedListNode(nodeToPrune);
        nodeToPrune = clone.getNext().getNext();
        After.removeLinkedListNode(nodeToPrune);
        assertEquals(pruned, clone);
    }
}