package chapter02.ex2_2;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    private final LinkedListNode<Integer> head;
    private final int kth;

    public Before (LinkedListNode<Integer> head, int kth) {
        this.head = head;
        this.kth = kth;
    }

    @Override
    public void run() {
        findKthToLast(this.head, this.kth);
    }

    /**
     * Complexity: O(n)
     *
     * @param   head The head of the linked list.
     * @param   k The index of the node to find, starting from 0 for the tail.
     */
    public static LinkedListNode<Integer> findKthToLast(LinkedListNode<Integer> head, int k) {
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
