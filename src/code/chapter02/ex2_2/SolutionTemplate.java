package chapter02.ex2_2;

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
    protected static final String PROBLEM = "Chapter 2. Ex 2_2: Return Kth to Last";
    protected final LinkedListNode<Integer> head;
    protected final Integer kth;

    /**
     * Chapter 2
     * Ex2_2: Return Kth to Last
     * Implement an algorithm to find the kth to last element of a singly
     * linked list.
     *
     * @param head  The linked list head.
     * @param kth   The k value.
     */
    public SolutionTemplate(LinkedListNode<Integer> head, Integer kth) {
        this.head = head;
        this.kth = kth;
    }

    @Override
    public void runSampleSolution() {
        int KTH = 3;

        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                10,
                () -> RandomGenerator.randomIntegerGenerator(8)
        );
        LinkedListNode<Integer> kth = findKthToLast(head, KTH);
        if (kth != null) {
            System.out.println("The " + KTH + "th element from last in " + colorYellow(head.toString()) + " is " +
                    colorYellow(String.valueOf(kth.getData())) + ".");
        } else {
            System.out.println(colorRed("The k index " + KTH + " from the last is out-of-bounds for the linked list ")
                    + colorYellow(head.toString()) + ".");
        }
    }

    @Override
    public void run() {
        findKthToLast(this.head, this.kth);
    }

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    public abstract LinkedListNode<Integer> findKthToLast(LinkedListNode<Integer> head, Integer k);
}
