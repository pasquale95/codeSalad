package chapter02.ex2_1;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    private final LinkedListNode head;

    public Before(LinkedListNode head) {
        this.head = head;
    }

    @Override
    public void run() {
        removeDuplicates(this.head);
    }

    /**
     * Complexity: O(n^2)
     *
     * @param head
     */
    public static void removeDuplicates(LinkedListNode head) {
        for (LinkedListNode node = head; node != null && !node.isTail(); node = node.getNext()) {
            for (LinkedListNode node1 = node.getNext(); node1 != null ; node1 = node1.getNext()) {
                if (node.getData() == node1.getData()) {
                    node1.delete();
                }
            }
        }
    }
}