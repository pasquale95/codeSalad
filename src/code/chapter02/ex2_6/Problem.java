package chapter02.ex2_6;

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
    private static final String PROBLEM = "Chapter 2 - Ex 2.6: Palindrome";

    /**
     * Chapter 2
     * Ex2_6: Palindrome
     * Implement a function to check if a linked list is palindrome.
     */
    public void runSolution(Method m) throws Exception {
        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                5,
                () -> RandomGenerator.randomIntegerGenerator(2)
        );
        System.out.println("The linked list " + colorYellow(head.toString())
                + " is palindrome: " + colorYellow(String.valueOf(m.invoke(null, head)))
        );
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(
                chapter02.ex2_6.pre.Solution.class.getMethod("isPalindrome", LinkedListNode.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(
                chapter02.ex2_6.post.Solution.class.getMethod("isPalindrome", LinkedListNode.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
