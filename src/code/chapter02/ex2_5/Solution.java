package chapter02.ex2_5;

import org.json.simple.JSONObject;
import utils.LinkedListNode;
import utils.Timer;

import java.util.Random;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution {

    private static final String PROBLEM = "Chapter 2. Ex 2.5";

    /**
     * Chapter 2
     * Ex2.5: Sum Lists
     * You have two numbers represented by a linked list, where each node contains a single
     * digit. The digits are stored in reverse order, such that the 1's digit is at the head of the
     * list. Write a function that adds the two numbers and returns the sum as a linked list.
     * (You are not allowed to "cheat" and just convert the linked list to an integer).
     * FOLLOW UP: Suppose the digits are stored in forward order. Repeat the above problem.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        Random r = new Random();
        LinkedListNode addend1 = LinkedListNode.createRandomLinkedList(r.nextInt(4)+1, 10);
        LinkedListNode addend2 = LinkedListNode.createRandomLinkedList(r.nextInt(4)+1, 10);
        System.out.println("The sum in reverse order of " + colorYellow(addend1.toString())
                + " and " + colorYellow(addend2.toString())
                + " is " + colorYellow(After.reverseOrderSum(addend1, addend2).toString())
                + ", while sum in forward order is " + colorYellow(After.forwardOrderSum(addend1, addend2).toString()) + "."
        );
    }

    public static void time(JSONObject params) {
        LinkedListNode[] addends = LinkedListNode.createRandomLinkedListArray(params);
        Before before = new Before(addends);
        After after = new After(addends);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}