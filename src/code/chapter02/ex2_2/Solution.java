package chapter02.ex2_2;

import chapter02.ex2_1.After;
import chapter02.ex2_2.Before;
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
    private static final int KTH = 9;

    /**
     * Chapter 2
     * Ex2.2: Return Kth to Last
     * Implement an algorithm to find the kth to last element of a singly
     * linked list.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        LinkedListNode head = LinkedListNode.createRandomLinkedList(10, 8);
        LinkedListNode kth = Before.findKthToLast(head, KTH);
        if (kth != null) {
            System.out.print("The " + KTH + "th element from last in " + colorYellow(head.toString()) + " is: " + kth.getData());
        } else {
            System.out.print(colorRed("The k index " + KTH + " from the last is out-of-bounds for the linked list ")
                    + colorYellow(head.toString()));
        }
    }

    public static void time() {
        // TODO
        //LinkedListNode head = LinkedListNode.createRandomLinkedList(200, 200);
        //Before before = new Before(head.clone());
        //After after = new After(head.clone());
        //Timer timer = new Timer(PROBLEM, before, after);
        //timer.start();
    }
}
