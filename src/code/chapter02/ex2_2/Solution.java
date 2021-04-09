package chapter02.ex2_2;

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

    private static final String PROBLEM = "Chapter 2. Ex 2.2";
    private static final int KTH = 3;

    /**
     * Chapter 2
     * Ex2.2: Return Kth to Last
     * Implement an algorithm to find the kth to last element of a singly
     * linked list.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        LinkedListNode head = LinkedListNode.createRandomLinkedList(10, 8);
        LinkedListNode kth = After.findKthToLast(head, KTH);
        if (kth != null) {
            System.out.println("The " + KTH + "th element from last in " + colorYellow(head.toString()) + " is: " + kth.getData());
        } else {
            System.out.println(colorRed("The k index " + KTH + " from the last is out-of-bounds for the linked list ")
                    + colorYellow(head.toString()));
        }
    }

    public static void time() {
        LinkedListNode head = LinkedListNode.createRandomLinkedList(20, 20);
        Before before = new Before(head.clone(), 12);
        After after = new After(head.clone(), 12);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}
