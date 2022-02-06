package chapter02.ex2_2;

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
    private static final String PROBLEM = "Chapter 2. Ex 2.2: Return Kth to Last";
    private static final int KTH = 3;

    /**
     * Chapter 2
     * Ex2_2: Return Kth to Last
     * Implement an algorithm to find the kth to last element of a singly
     * linked list.
     */
    @SuppressWarnings("unchecked")
    public void runSolution(Method m) throws Exception {
        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                10,
                () -> RandomGenerator.randomIntegerGenerator(8)
        );
        LinkedListNode<Integer> kth = (LinkedListNode<Integer>) m.invoke(null, head, KTH);
        if (kth != null) {
            System.out.println("The " + KTH + "th element from last in " + colorYellow(head.toString()) + " is " +
                    colorYellow(String.valueOf(kth.getData())) + ".");
        } else {
            System.out.println(colorRed("The k index " + KTH + " from the last is out-of-bounds for the linked list ")
                    + colorYellow(head.toString()) + ".");
        }
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(chapter02.ex2_2.pre.Solution.class.getMethod(
                "findKthToLast", LinkedListNode.class, int.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(chapter02.ex2_2.post.Solution.class.getMethod(
                "findKthToLast", LinkedListNode.class, int.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
