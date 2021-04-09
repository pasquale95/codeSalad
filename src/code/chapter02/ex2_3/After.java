package chapter02.ex2_3;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    private final LinkedListNode node;

    public After(LinkedListNode node) {
        this.node = node;
    }

    @Override
    public void run() {
        removeLinkedListNode(this.node);
    }

    /**
     * Complexity: TODO
     *
     * @param   node The node to delete
     */
    public static void removeLinkedListNode(LinkedListNode node) {
        if (node.isTail()) {
            return;
        }
        node.setData(node.getNext().getData());
        node.append(node.getNext().getNext());
    }
}