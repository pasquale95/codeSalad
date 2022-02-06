package chapter02.ex2_4;

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
    private static final String PROBLEM = "Chapter 2 - Ex 2.4: Partition";
    private static final int LIST_LENGTH = 10, CEILING = 50;

    /**
     * Chapter 2
     * Ex2_4: Partition
     * Write code to partition a linked list around a value x, such that all nodes
     * less than x come before all nodes greater than or equal to x.
     * (IMPORTANT: The partition element x can appear anywhere in the "right partition";
     * it does not need to appear between the left and the right partitions.)
     */
    @SuppressWarnings("unchecked")
    public void runSolution(Method m) throws Exception {
        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                LIST_LENGTH,
                () -> RandomGenerator.randomIntegerGenerator(CEILING)
        );
        int threshold = RandomGenerator.randomIntegerGenerator(CEILING);
        LinkedListNode<Integer> partitioned = (LinkedListNode<Integer>) m.invoke(null, head.clone(), threshold);
        System.out.println(colorYellow(head.toString()) + " after partitioning on the threshold " + threshold
                + " becomes: " + colorYellow(partitionFormat(partitioned, threshold)) + ".");
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(chapter02.ex2_4.pre.Solution.class.getMethod(
                "partition", LinkedListNode.class, int.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(chapter02.ex2_4.post.Solution.class.getMethod(
                "partition", LinkedListNode.class, int.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }

    /**
     * Format list using the proposed scheme "BeforeList   ->    AfterList"
     * @param   node The starting linked list node
     * @param   threshold The threshold value used for partitioning
     * @return  The linked list as formatted string.
     */
    private static String partitionFormat(LinkedListNode<Integer> node, int threshold) {
        StringBuilder sb = new StringBuilder();
        boolean partitionFound = false;
        while (!node.isTail()) {
            sb.append(node.getData());
            if (node.getNext().getData() > threshold && !partitionFound) {
                sb.append("   ->   ");
                partitionFound = true;
            } else {
                sb.append(" -> ");
            }
            node = node.getNext();
        }
        sb.append(node.getData());
        return sb.toString();
    }
}
