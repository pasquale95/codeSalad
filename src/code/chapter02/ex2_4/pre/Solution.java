package chapter02.ex2_4.pre;

import chapter02.ex2_4.SolutionTemplate;
import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    /**
     * @see SolutionTemplate#SolutionTemplate(LinkedListNode, Integer)
     */
    public Solution(LinkedListNode<Integer> head, Integer threshold) {
        super(head, threshold);
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
    @Override
    public LinkedListNode<Integer> partition(LinkedListNode<Integer> node, Integer threshold) {
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