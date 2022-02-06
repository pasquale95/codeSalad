package chapter02.ex2_1.post;

import utils.LinkedListNode;

import java.util.HashSet;

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
     * Complexity: O(n)
     *
     * @param   head The node from where to start removing duplicates.
     */
    public static void removeDuplicatesA(LinkedListNode<Integer> head) {
        HashSet<Integer> hashTable = new HashSet<>();
        while (head != null) {
            if (hashTable.contains(head.getData())) {
                head.delete();
            } else {
                hashTable.add(head.getData());
            }
            head = head.getNext();
        }
    }

    /**
     * Constraint 1: no temporary buffer is allowed
     * Complexity: O(n^2)
     *
     * @param   head The node from where to start removing duplicates.
     */
    public static void removeDuplicatesB(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        while (current != null && !current.isTail()) {
            LinkedListNode<Integer> runner = current.getNext();
            while (runner != null) {
                if (current.getData().equals(runner.getData())) {
                    runner.delete();
                }
                runner = runner.getNext();
            }
            current = current.getNext();
        }
    }
}