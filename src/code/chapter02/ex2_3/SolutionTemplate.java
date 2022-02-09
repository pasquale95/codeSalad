package chapter02.ex2_3;

import utils.LinkedListNode;
import utils.architecture.SolutionStrategy;
import utils.generators.RandomGenerator;

import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class SolutionTemplate implements SolutionStrategy {
    private static final String PROBLEM = "Chapter 2 - Ex 2.3: Delete Middle Node";

    /**
     * Chapter 2
     * Ex2_3: Delete Middle Node
     * Implement an algorithm to delete a node in the middle
     * (i.e. any node but the first and last node, not necessarily
     * the exact middle) of a singly linked list, given only access
     * to that node.
     */
    @Override
    public void runSampleSolution() {
        int LIST_LENGTH = 10;

        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                LIST_LENGTH,
                () -> RandomGenerator.randomIntegerGenerator(100)
        );
        LinkedListNode<Integer> nodeToPrune = getNodeToPrune(head);
        System.out.print(colorYellow(head.toString()) + " after removing the node " + nodeToPrune.getData() + ": ");
        solve(nodeToPrune);
        System.out.println(colorYellow(head.toString()) + ".");
    }

    public abstract void solve(LinkedListNode<Integer> node);

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    /**
     * Retrieve node to prune in the linked list
     * @param   head The head of the linked list.
     */
    public static LinkedListNode<Integer> getNodeToPrune(LinkedListNode<Integer> head) {
        int nodeToPrune = RandomGenerator.randomIntegerGenerator(head.getSize() - 2) + 1; // no head or tail
        for (int i = 0; i < nodeToPrune; i++) {
            head = head.getNext();
        }
        return head;
    }
}
