package chapter02.ex2_4;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    private final LinkedListNode head;
    private final int threshold;

    public After(LinkedListNode head, int threshold) {
        this.head = head;
        this.threshold = threshold;
    }

    @Override
    public void run() {
        partition(this.head, this.threshold);
    }

    /**
     * Complexity: O(n)
     *
     * Partition a linked list moving all nodes smaller than the given threshold to the beginning
     * and the others at the end. Partition is performed while walking the linked list.
     * @param   node The head of the linked list to partition.
     * @param   threshold The threshold to use for partitioning.
     * @return  The partitioned linked list.
     */
    public static LinkedListNode partition(LinkedListNode node, int threshold) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        if (node != null) {
            node = node.getNext();
            head.append(null);
        }
        while (node != null) {
            LinkedListNode next = node.getNext();
            node.append(null);
            if (node.getData() < threshold) {
                node.append(head);
                head = node;
            } else {
                tail.append(node);
                tail = node;
            }
            node = next;
        }

        return head;
    }
}