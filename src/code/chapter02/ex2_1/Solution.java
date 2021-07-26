package chapter02.ex2_1;

import utils.LinkedListNode;
import utils.Timer;

import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution {

    private static final String PROBLEM = "Chapter 2. Ex 2.1";

    /**
     * Chapter 2
     * Ex2.1: Remove Dups
     * Question A: Write code to remove duplicates from an unsorted linked list.
     * Question B: How would you solve this problem if a temporary buffer is not allowed?
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        LinkedListNode head = LinkedListNode.createRandomLinkedList(10, 8);
        System.out.print(colorYellow(head.toString()) + " after removing duplicates: ");
        After.removeDuplicatesB(head);
        System.out.println(colorYellow(head.toString()) + ".");
    }

    public static void time() {
        LinkedListNode head = LinkedListNode.createRandomLinkedList(200, 200);
        Before before = new Before(head.clone());
        After after = new After(head.clone());
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}