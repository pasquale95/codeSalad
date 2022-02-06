package chapter02.ex2_1.pre;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution implements Runnable {

    private final LinkedListNode<Integer> head;

    public Solution(LinkedListNode<Integer> head) {
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
    public static void removeDuplicatesA(LinkedListNode<Integer> head) {
        for (LinkedListNode<Integer> node = head; node != null && !node.isTail(); node = node.getNext()) {
            for (LinkedListNode<Integer> node1 = node.getNext(); node1 != null ; node1 = node1.getNext()) {
                if (node.getData().equals(node1.getData())) {
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
    public static void removeDuplicatesB(LinkedListNode<Integer> head) {
        for (LinkedListNode<Integer> node = head; node != null && !node.isTail(); node = node.getNext()) {
            for (LinkedListNode<Integer> node1 = node.getNext(); node1 != null ; node1 = node1.getNext()) {
                if (node.getData().equals(node1.getData())) {
                    node1.delete();
                }
            }
        }
    }
}