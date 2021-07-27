package chapter02.ex2_6;

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

    private static final String PROBLEM = "Chapter 2. Ex 2.6";

    /**
     * Chapter 2
     * Ex2.6: Palindrome
     * Implement a function to check if a linked list is palindrome.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        LinkedListNode head = LinkedListNode.createRandomLinkedList(5, 2);
        System.out.println("The linked list " + colorYellow(head.toString())
                + " is palindrome: " + colorYellow(String.valueOf(After.isPalindrome(head)))
        );
    }

    public static void time() {
        LinkedListNode head = LinkedListNode.createRandomLinkedList(1000, 2);
        Before before = new Before(head);
        After after = new After(head);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}