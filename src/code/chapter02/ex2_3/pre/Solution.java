package chapter02.ex2_3.pre;

import chapter02.ex2_3.SolutionTemplate;
import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    /**
     * @see SolutionTemplate#SolutionTemplate(LinkedListNode)
     */
    public Solution(LinkedListNode<Integer> node) {
        super(node);
    }

    /**
     * Complexity: O(1)
     *
     * @param   node The node to delete
     */
    @Override
    public void removeLinkedListNode(LinkedListNode<Integer> node) {
        if (node == null || node.isTail()) {
            // We don't expect to have a null node or the tail
            return;
        }
        node.setData(node.getNext().getData());
        node.append(node.getNext().getNext());
    }
}