package chapter02.ex2_2.pre;

import chapter02.ex2_2.SolutionTemplate;
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
    public Solution(LinkedListNode<Integer> head, Integer kth) {
        super(head, kth);
    }

    /**
     * Complexity: O(n)
     *
     * @param   head The head of the linked list.
     * @param   k The index of the node to find, starting from 0 for the tail.
     */
    @Override
    public LinkedListNode<Integer> findKthToLast(LinkedListNode<Integer> head, Integer k) {
        int length = 0;
        for (LinkedListNode<Integer> node = head; node != null; node = node.getNext()) {
            length++;
        }
        length -= (k + 1); // +1 since the tail is "0 steps to last"
        if (length < 0) {
            // list is shorter than k+1
            return null;
        }
        while (length > 0 && head != null) {
            head = head.getNext();
            length--;
        }
        return head;
    }
}
