package chapter02.ex2_3;

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

    // TODO cleanup all code
    private static final String PROBLEM = "Chapter 2. Ex 2.3";
    private static final int LIST_LENGTH = 10;

    /**
     * Chapter 2
     * Ex2.3: Delete Middle Node
     * Implement an algorithm to delete a node in the middle
     * (i.e. any node but the first and last node, not necessarily
     * the exact middle) of a singly linked list, given only access
     * to that node.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        LinkedListNode head = LinkedListNode.createRandomLinkedList(LIST_LENGTH, 100);
        LinkedListNode nodeToPrune = getNodeToPrune(head);
        System.out.print(colorYellow(head.toString()) + " after removing the node " + nodeToPrune.getData() + ": ");
        Before.removeLinkedListNode(nodeToPrune);
        System.out.println(head.toString());
    }

    public static void time() {
        LinkedListNode head = LinkedListNode.createRandomLinkedList(200, 200);
        Before before = new Before(getNodeToPrune(head.clone()));
        After after = new After(getNodeToPrune(head.clone()));
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }

    /**
     * Retrieve node to prune in the linked list
     * @param   head The head of the linked list.
     */
    private static LinkedListNode getNodeToPrune(LinkedListNode head) {
        Random r = new Random();
        int nodeToPrune = r.nextInt(LIST_LENGTH - 2) + 1; // no head or tail
        for (int i = 0; i < nodeToPrune; i++) {
            head = head.getNext();
        }
        return head;
    }
}