package chapter02;

import chapter02.ex2_4.After;
import chapter02.ex2_4.Before;
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
class Ex2_4 {

    private static LinkedListNode head;
    private static final int threshold = 15;

    @BeforeAll
    static void init() {
        head = new LinkedListNode(13);
        head.append(43).append(31).append(12).append(15).append(3).append(5).append(14);
    }

    @Test
    @Order(1)
    void partitionBefore() {
        LinkedListNode partitioned = Before.partition(head.clone(), threshold);
        boolean rightHalf = false;
        LinkedListNode runner = partitioned;
        while (runner != null) {
            if (runner.getData()>threshold) {
                rightHalf = true;
            }
            if (!rightHalf) {
                assertTrue(runner.getData()<threshold);
            } else {
                assertFalse(runner.getData()<threshold);
            }
            runner = runner.getNext();
        }
    }

    @Test
    @Order(2)
    void partitionAfter() {
        LinkedListNode partitioned = After.partition(head.clone(), threshold);
        boolean rightHalf = false;
        LinkedListNode runner = partitioned;
        while (runner != null) {
            if (runner.getData()>threshold) {
                rightHalf = true;
            }
            if (!rightHalf) {
                assertTrue(runner.getData()<threshold);
            } else {
                assertFalse(runner.getData()<threshold);
            }
            runner = runner.getNext();
        }
    }
}