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
    protected static final String PROBLEM = "Chapter 2 - Ex 2_1: Remove Dups";
    protected final LinkedListNode<Integer> head;

    /**
     * Chapter 2
     * Ex2_1: Remove Dups
     * Question A: Write code to remove duplicates from an unsorted linked list.
     * Question B: How would you runSampleSolution this problem if a temporary buffer is not allowed?
     *
     * @param head The linked list head.
     */
    public SolutionTemplate(LinkedListNode<Integer> head) {
        this.head = head;
    }

    @Override
    public void runSampleSolution() {
        printBlue(getProblemName());
        // Question A
        printGreen("QUESTION A");
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                10,
                () -> RandomGenerator.randomIntegerGenerator(8)
        );
        System.out.print(colorYellow(head.toString()) + " after removing duplicates: ");
        removeDuplicatesA(head);
        System.out.println(colorYellow(head.toString()) + ".");
        // Question B
        printGreen("QUESTION B");
        head = LinkedListNode.createLinkedList(
                10,
                () -> RandomGenerator.randomIntegerGenerator(8)
        );
        System.out.print(colorYellow(head.toString()) + " after removing duplicates: ");
        removeDuplicatesB(head);
        System.out.println(colorYellow(head.toString()) + ".");
    }

    @Override
    public void run() {
        removeDuplicatesA(this.head.clone());
        removeDuplicatesB(this.head);
    }

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    public abstract void removeDuplicatesA(LinkedListNode<Integer> head);

    public abstract void removeDuplicatesB(LinkedListNode<Integer> head);
}
