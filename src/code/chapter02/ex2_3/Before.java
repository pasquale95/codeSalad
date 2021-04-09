package chapter02.ex2_3;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    private final LinkedListNode node;

    public Before(LinkedListNode node) {
        this.node = node;
    }

    @Override
    public void run() {
        removeLinkedListNode(this.node);
    }

    /**
     * Complexity: O(1)
     *
     * @param node
     */
    public static void removeLinkedListNode(LinkedListNode node) {
        if (node.isTail()) {
            return;
        }
        node.setData(node.getNext().getData());
        node.append(node.getNext().getNext());
    }
}