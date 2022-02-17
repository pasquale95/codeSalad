package chapter02.ex2_4.post;

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
        LinkedListNode<Integer> head = node;
        LinkedListNode<Integer> tail = node;

        if (node != null) {
            node = node.getNext();
            head.append((LinkedListNode<Integer>) null);
        }
        while (node != null) {
            LinkedListNode<Integer> next = node.getNext();
            node.append((LinkedListNode<Integer>) null);
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