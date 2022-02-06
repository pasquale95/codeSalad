package chapter02.ex2_2.post;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution implements Runnable {

    static class Index {
        int index = 0;
    }

    private final LinkedListNode<Integer> head;
    private final int kth;

    public Solution(LinkedListNode<Integer> head, int kth) {
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
        Index index = new Index();
        return kthToLast(head, k+1, index); // k+1 since the last element is 0 pos ahead of itself
    }

    /**
     * Recursive method to find the kth element from the tail.
     *
     * @param   node The current node.
     * @param   k The index of the node to find, starting from 0 for the tail.
     * @param   index Counter starting from 0.
     * @return  The kth node.
     */
    protected static LinkedListNode<Integer> kthToLast(LinkedListNode<Integer> node, int k, Index index) {
        if (node == null) {
            return null;
        }
        LinkedListNode<Integer> kth = kthToLast(node.getNext(), k, index);
        index.index++;
        if (index.index == k) {
            return node;
        }
        return kth;
    }
}
