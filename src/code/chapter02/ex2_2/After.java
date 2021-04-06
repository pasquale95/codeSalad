package chapter02.ex2_2;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    static class Index {
        int index = 0;
    }

    private final LinkedListNode head;
    private final int k;

    public After (LinkedListNode head, int k) {
        this.head = head;
        this.k = k;
    }

    @Override
    public void run() {
        findKthToLast(this.head, this.k);
    }

    /**
     * Complexity: O(n)
     *
     * @param head
     * @param k
     */
    public static LinkedListNode findKthToLast(LinkedListNode head, int k) {
        Index index = new Index();
        return kthToLast(head, k+1, index); // k+1 since the last element is 0 pos ahead of itself
    }

    protected static LinkedListNode kthToLast(LinkedListNode node, int k, Index index) {
        if (node == null) {
            return null;
        }
        LinkedListNode kth = kthToLast(node.getNext(), k, index);
        index.index++;
        if (index.index == k) {
            return node;
        }
        return kth;
    }
}
