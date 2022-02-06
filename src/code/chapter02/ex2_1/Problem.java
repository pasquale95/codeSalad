package chapter02.ex2_1;

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
    private static final String PROBLEM = "Chapter 2 - Ex 2.1: Remove Dups";

    /**
     * Chapter 2
     * Ex2_1: Remove Dups
     * Question A: Write code to remove duplicates from an unsorted linked list.
     * Question B: How would you solve this problem if a temporary buffer is not allowed?
     */
    public void runSolution(Method m) throws Exception {
        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                10,
                () -> RandomGenerator.randomIntegerGenerator(8)
        );
        System.out.print(colorYellow(head.toString()) + " after removing duplicates: ");
        m.invoke(null, head);
        System.out.println(colorYellow(head.toString()) + ".");
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(chapter02.ex2_1.pre.Solution.class.getMethod(
                "removeDuplicatesB", LinkedListNode.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(chapter02.ex2_1.post.Solution.class.getMethod(
                "removeDuplicatesB", LinkedListNode.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
