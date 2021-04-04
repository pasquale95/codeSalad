package chapter02.ex2_1;

import utils.LinkedListNode;
import utils.Timer;

import java.util.Random;

import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution {

    private static final String PROBLEM = "Chapter 2. Ex 2.1";
    private static final int LIST_LENGTH = 10;

    /**
     * Chapter 2
     * Ex2.1: Remove Dups
     * Write code to remove duplicates from an unsorted linked list.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        LinkedListNode head = createLinkedList();
        System.out.print(colorYellow(head.toString()) + " after removing updates: ");
        Before.removeDuplicates(head);
        System.out.println(head.toString());
    }

    public static LinkedListNode createLinkedList() {
        Random r = new Random();
        int range = 8;
        LinkedListNode node = new LinkedListNode(r.nextInt(range));
        LinkedListNode head = node;
        for (int i = 1; i < LIST_LENGTH; i++) {
            node = node.append(r.nextInt(range));
        }
        return head;
    }

    public static void time() {
        //Before before = new Before(strings);
        //After after = new After(strings);

        //Timer timer = new Timer(PROBLEM, before, after);
        //timer.start();
    }
}