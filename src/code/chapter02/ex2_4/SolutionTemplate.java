package chapter02.ex2_4;

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
    private static final String PROBLEM = "Chapter 2 - Ex 2_4: Partition";

    /**
     * Chapter 2
     * Ex2_4: Partition
     * Write code to partition a linked list around a value x, such that all nodes
     * less than x come before all nodes greater than or equal to x.
     * (IMPORTANT: The partition element x can appear anywhere in the "right partition";
     * it does not need to appear between the left and the right partitions.)
     */
    @Override
    public void runSampleSolution() {
        int LIST_LENGTH = 10, CEILING = 50;
        int threshold = RandomGenerator.randomIntegerGenerator(CEILING);

        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                LIST_LENGTH,
                () -> RandomGenerator.randomIntegerGenerator(CEILING)
        );
        LinkedListNode<Integer> partitioned = solve(head.clone(), threshold);
        System.out.println(colorYellow(head.toString()) + " after partitioning on the threshold " + threshold
                + " becomes: " + colorYellow(partitionFormat(partitioned, threshold)) + ".");
    }

    public abstract LinkedListNode<Integer> solve(LinkedListNode<Integer> node, int threshold);

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

    @Override
    public String getProblemName() {
        return PROBLEM;
    }
}
