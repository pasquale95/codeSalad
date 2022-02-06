package chapter02.ex2_3;

import utils.LinkedListNode;
import utils.architecture.ProblemTemplate;
import utils.generators.RandomGenerator;

import java.lang.reflect.Method;

import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Problem extends ProblemTemplate {
    private static final String PROBLEM = "Chapter 2 - Ex 2.3: Delete Middle Node";
    private static final int LIST_LENGTH = 10;

    /**
     * Chapter 2
     * Ex2_3: Delete Middle Node
     * Implement an algorithm to delete a node in the middle
     * (i.e. any node but the first and last node, not necessarily
     * the exact middle) of a singly linked list, given only access
     * to that node.
     */
    public void runSolution(Method m) throws Exception {
        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                LIST_LENGTH,
                () -> RandomGenerator.randomIntegerGenerator(100)
        );
        LinkedListNode<Integer> nodeToPrune = getNodeToPrune(head);
        System.out.print(colorYellow(head.toString()) + " after removing the node " + nodeToPrune.getData() + ": ");
        m.invoke(null, nodeToPrune);
        System.out.println(colorYellow(head.toString()) + ".");
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(chapter02.ex2_3.pre.Solution.class.getMethod(
                "removeLinkedListNode", LinkedListNode.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(chapter02.ex2_3.post.Solution.class.getMethod(
                "removeLinkedListNode", LinkedListNode.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }

    /**
     * Retrieve node to prune in the linked list
     * @param   head The head of the linked list.
     */
    public static LinkedListNode<Integer> getNodeToPrune(LinkedListNode<Integer> head) {
        int nodeToPrune = RandomGenerator.randomIntegerGenerator(LIST_LENGTH - 2) + 1; // no head or tail
        for (int i = 0; i < nodeToPrune; i++) {
            head = head.getNext();
        }
        return head;
    }
}
