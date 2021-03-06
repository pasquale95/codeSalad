package chapter02.ex2_4;

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

    private static final String PROBLEM = "Chapter 2. Ex 2.4";
    private static final int LIST_LENGTH = 10, CEILING = 50;

    /**
     * Chapter 2
     * Ex2.4: Partition
     * Write code to partition a linked list around a value x, such that all nodes
     * less than x come before all nodes greater than or equal to x.
     * (IMPORTANT: The partition element x can appear anywhere in the "right partition";
     * it does not need to appear between the left and the right partitions.)
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        LinkedListNode head = LinkedListNode.createRandomLinkedList(LIST_LENGTH, CEILING);
        Random r = new Random();
        int threshold = r.nextInt(CEILING);
        LinkedListNode partitioned = After.partition(head.clone(), threshold);
        System.out.println(colorYellow(head.toString()) + " after partitioning on the threshold " + threshold
                + " becomes: " + colorYellow(partitionFormat(partitioned, threshold)) + ".");
    }

    public static void time() {
        LinkedListNode head = LinkedListNode.createRandomLinkedList(1000, 1000);
        Random r = new Random();
        int threshold = r.nextInt(2000);
        Before before = new Before(head.clone(), threshold);
        After after = new After(head.clone(), threshold);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }

    /**
     * Format list using the proposed scheme "BeforeList   ->    AfterList"
     * @param   node The starting linked list node
     * @param   threshold The threshold value used for partitioning
     * @return  The linked list as formatted string.
     */
    private static String partitionFormat(LinkedListNode node, int threshold) {
        StringBuilder sb = new StringBuilder();
        boolean partitionFound = false;
        while (!node.isTail()) {
            sb.append(node.getData());
            if (node.getNext().getData() > threshold && !partitionFound) {
                sb.append("   ->   ");
                partitionFound = true;
            } else {
                sb.append(" -> ");
            }
            node = node.getNext();
        }
        sb.append(node.getData());
        return sb.toString();
    }
}