package chapter02.ex2_5;

import utils.LinkedListNode;
import utils.architecture.ProblemTemplate;
import utils.generators.RandomGenerator;

import java.lang.reflect.Method;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Problem extends ProblemTemplate {
    private static final String PROBLEM = "Chapter 2 - Ex 2.5: Sum Lists";

    /**
     * Chapter 2
     * Ex2_5: Sum Lists
     * You have two numbers represented by a linked list, where each node contains a single
     * digit. The digits are stored in reverse order, such that the 1st digit is at the head of the
     * list. Write a function that adds the two numbers and returns the sum as a linked list.
     * (You are not allowed to "cheat" and just convert the linked list to an integer).
     * FOLLOW UP: Suppose the digits are stored in forward order. Repeat the above problem.
     */
    public void runSolution(Method reverseOrderSum, Method forwardOrderSum) throws Exception {
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
                + " is " + colorYellow(reverseOrderSum.invoke(null, addend1, addend2).toString())
                + ", while sum in forward order is "
                + colorYellow(forwardOrderSum.invoke(null, addend1, addend2).toString())
                + "."
        );
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(
                chapter02.ex2_5.pre.Solution.class.getMethod(
                        "reverseOrderSum", LinkedListNode.class, LinkedListNode.class),
                chapter02.ex2_5.pre.Solution.class.getMethod(
                        "forwardOrderSum", LinkedListNode.class, LinkedListNode.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(
                chapter02.ex2_5.post.Solution.class.getMethod(
                        "reverseOrderSum", LinkedListNode.class, LinkedListNode.class),
                chapter02.ex2_5.post.Solution.class.getMethod(
                        "forwardOrderSum", LinkedListNode.class, LinkedListNode.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
