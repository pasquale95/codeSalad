package chapter02.ex2_2;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    private final LinkedListNode head;
    private final int kth;

    public Before (LinkedListNode head, int kth) {
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
     * @param head
     * @param kth
     */
    public static LinkedListNode findKthToLast(LinkedListNode head, int kth) {
        int length = 0;
        for (LinkedListNode node = head; node != null; node = node.getNext()) {
            length++;
        }
        length -= (kth + 1); // +1 since the tail is "0 steps to last"
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
