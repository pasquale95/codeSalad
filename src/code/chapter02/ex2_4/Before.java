package chapter02.ex2_4;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    private final LinkedListNode<Integer> head;
    private final int threshold;

    public Before(LinkedListNode<Integer> head, int threshold) {
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
    public static LinkedListNode<Integer> partition(LinkedListNode<Integer> node, int threshold) {
        LinkedListNode<Integer> beforeHead = null, beforeTail = null, afterHead = null, afterTail = null;
        while (node != null) {
            int value = node.getData();
            if (value < threshold) {
                if (beforeHead == null) {
                    beforeHead = new LinkedListNode<>(value);
                    beforeTail = beforeHead;
                } else {
                    beforeTail = beforeTail.append(value);
                }
            } else {
                if (afterHead == null) {
                    afterHead = new LinkedListNode<>(value);
                    afterTail = afterHead;
                } else {
                    afterTail = afterTail.append(value);
                }
            }
            node = node.getNext();
        }
        if (beforeHead == null) {
            // all list nodes bigger than threshold -> no need to merge
            return afterHead;
        }
        // merge two lists
        beforeTail.append(afterHead);
        return beforeHead;
    }
}