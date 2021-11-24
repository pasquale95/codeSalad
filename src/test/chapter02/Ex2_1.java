package chapter02;

import chapter02.ex2_1.After;
import chapter02.ex2_1.Before;
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
class Ex2_1 {

    private static LinkedListNode<Integer> withDuplicates;
    private static LinkedListNode<Integer> noDuplicates;

    @BeforeAll
    static void init() {
        // create linked list to clean
        withDuplicates = new LinkedListNode<>(3);
        withDuplicates.append(4).append(3).append(2).append(5).append(3).append(5);
        // expected result
        noDuplicates = new LinkedListNode<>(3);
        noDuplicates.append(4).append(2).append(5);
    }

    @Test
    @Order(1)
    void removeDupsBefore() {
        // test Question A
        LinkedListNode<Integer> clone = withDuplicates.clone();
        Before.removeDuplicatesA(clone);
        assertEquals(noDuplicates, clone);
        // test Question B
        clone = withDuplicates.clone();
        Before.removeDuplicatesB(clone);
        assertEquals(noDuplicates, clone);
    }

    @Test
    @Order(2)
    void removeDupsAfter() {
        // test Question A
        LinkedListNode<Integer> clone = withDuplicates.clone();
        After.removeDuplicatesA(clone);
        assertEquals(noDuplicates, clone);
        // test Question B
        clone = withDuplicates.clone();
        After.removeDuplicatesB(clone);
        assertEquals(noDuplicates, clone);
    }
}