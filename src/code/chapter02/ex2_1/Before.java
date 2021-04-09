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
        removeDuplicatesA(this.head.clone());
        removeDuplicatesB(this.head);
    }

    /**
     * Complexity: O(n^2)
     *
     * @param   head The node from where to start removing duplicates.
     */
    public static void removeDuplicatesA(LinkedListNode head) {
        for (LinkedListNode node = head; node != null && !node.isTail(); node = node.getNext()) {
            for (LinkedListNode node1 = node.getNext(); node1 != null ; node1 = node1.getNext()) {
                if (node.getData() == node1.getData()) {
                    node1.delete();
                }
            }
        }
    }

    /**
     * Complexity: O(n^2)
     *
     * @param   head The node from where to start removing duplicates.
     */
    public static void removeDuplicatesB(LinkedListNode head) {
        for (LinkedListNode node = head; node != null && !node.isTail(); node = node.getNext()) {
            for (LinkedListNode node1 = node.getNext(); node1 != null ; node1 = node1.getNext()) {
                if (node.getData() == node1.getData()) {
                    node1.delete();
                }
            }
        }
    }
}