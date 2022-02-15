package chapter02.ex2_1;

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
    private static final String PROBLEM = "Chapter 2 - Ex 2_1: Remove Dups";

    /**
     * Chapter 2
     * Ex2_1: Remove Dups
     * Question A: Write code to remove duplicates from an unsorted linked list.
     * Question B: How would you runSampleSolution this problem if a temporary buffer is not allowed?
     */
    @Override
    public void runSampleSolution() {
        printBlue(getProblemName());
        // Question A
        printYellow("QUESTION A");
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                10,
                () -> RandomGenerator.randomIntegerGenerator(8)
        );
        System.out.print(colorYellow(head.toString()) + " after removing duplicates: ");
        solveQuestionA(head);
        System.out.println(colorYellow(head.toString()) + ".");
        // Question B
        printYellow("QUESTION B");
        head = LinkedListNode.createLinkedList(
                10,
                () -> RandomGenerator.randomIntegerGenerator(8)
        );
        System.out.print(colorYellow(head.toString()) + " after removing duplicates: ");
        solveQuestionB(head);
        System.out.println(colorYellow(head.toString()) + ".");
    }

    public abstract void solveQuestionA(LinkedListNode<Integer> head);

    public abstract void solveQuestionB(LinkedListNode<Integer> head);

    @Override
    public String getProblemName() {
        return PROBLEM;
    }
}
