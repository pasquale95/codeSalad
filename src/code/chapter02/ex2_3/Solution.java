package chapter02.ex2_3;

import org.json.simple.JSONObject;
import utils.architecture.ExerciseSolutions;
import utils.LinkedListNode;
import utils.architecture.SolutionTemplate;
import java.util.Random;
import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    private static final String PROBLEM = "Chapter 2. Ex 2.3";
    private static final int LIST_LENGTH = 10;

    /**
     * Chapter 2
     * Ex2.3: Delete Middle Node
     * Implement an algorithm to delete a node in the middle
     * (i.e. any node but the first and last node, not necessarily
     * the exact middle) of a singly linked list, given only access
     * to that node.
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createRandomLinkedList(LIST_LENGTH, 100, i -> i);
        LinkedListNode<Integer> nodeToPrune = getNodeToPrune(head);
        System.out.print(colorYellow(head.toString()) + " after removing the node " + nodeToPrune.getData() + ": ");
        After.removeLinkedListNode(nodeToPrune);
        System.out.println(colorYellow(head.toString()) + ".");
    }

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        LinkedListNode<Integer> head = LinkedListNode.createRandomLinkedList(params, i -> i);
        return new ExerciseSolutions(new Before(getNodeToPrune(head.clone())), new After(getNodeToPrune(head.clone())));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }

    /**
     * Retrieve node to prune in the linked list
     * @param   head The head of the linked list.
     */
    private static LinkedListNode<Integer> getNodeToPrune(LinkedListNode<Integer> head) {
        Random r = new Random();
        int nodeToPrune = r.nextInt(LIST_LENGTH - 2) + 1; // no head or tail
        for (int i = 0; i < nodeToPrune; i++) {
            head = head.getNext();
        }
        return head;
    }
}