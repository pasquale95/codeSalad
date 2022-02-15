package chapter02.ex2_6;

import utils.LinkedListNode;
import utils.architecture.SolutionStrategy;
import utils.generators.RandomGenerator;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class SolutionTemplate implements SolutionStrategy {
    private static final String PROBLEM = "Chapter 2 - Ex 2_6: Palindrome";

    /**
     * Chapter 2
     * Ex2_6: Palindrome
     * Implement a function to check if a linked list is palindrome.
     */
    @Override
    public void runSampleSolution() {
        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                5,
                () -> RandomGenerator.randomIntegerGenerator(2)
        );
        System.out.println("The linked list " + colorYellow(head.toString())
                + " is palindrome: " + colorYellow(String.valueOf(solve(head)))
        );
    }

    public abstract boolean solve(LinkedListNode<Integer> head);

    @Override
    public String getProblemName() {
        return PROBLEM;
    }
}
