package chapter02.ex2_5;

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
    protected static final String PROBLEM = "Chapter 2 - Ex 2_5: Sum Lists";
    protected final LinkedListNode<Integer>[] addends;

    /**
     * Chapter 2
     * Ex2_5: Sum Lists
     * You have two numbers represented by a linked list, where each node contains a single
     * digit. The digits are stored in reverse order, such that the 1st digit is at the head of the
     * list. Write a function that adds the two numbers and returns the sum as a linked list.
     * (You are not allowed to "cheat" and just convert the linked list to an integer).
     * FOLLOW UP: Suppose the digits are stored in forward order. Repeat the above problem.
     *
     * @param addends The two lists to sum.
     */
    public SolutionTemplate(LinkedListNode<Integer>[] addends) {
        this.addends = addends;
    }

    @Override
    public void runSampleSolution() {
        printBlue(getProblemName());
        LinkedListNode<Integer> addend1 = LinkedListNode.createLinkedList(
                RandomGenerator.randomIntegerGenerator(4) + 1,
                () -> RandomGenerator.randomIntegerGenerator(10)
        );
        LinkedListNode<Integer> addend2 = LinkedListNode.createLinkedList(
                RandomGenerator.randomIntegerGenerator(4) + 1,
                () -> RandomGenerator.randomIntegerGenerator(10)
        );
        System.out.println("The sum in reverse order of " + colorYellow(addend1.toString())
                + " and " + colorYellow(addend2.toString())
                + " is " + colorYellow(reverseOrderSum(addend1, addend2).toString())
                + ", while sum in forward order is "
                + colorYellow(forwardOrderSum(addend1, addend2).toString())
                + "."
        );
    }

    @Override
    public void run() {
        for (int i = 0; i < addends.length - 1; i++) {
            for (int j = i + 1; j < addends.length; j++) {
                reverseOrderSum(this.addends[i], this.addends[j]);
                forwardOrderSum(this.addends[i], this.addends[j]);
            }
        }
    }

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    public abstract LinkedListNode<Integer> reverseOrderSum(LinkedListNode<Integer> addend1, LinkedListNode<Integer> addend2);

    public abstract LinkedListNode<Integer> forwardOrderSum(LinkedListNode<Integer> addend1, LinkedListNode<Integer> addend2);
}
