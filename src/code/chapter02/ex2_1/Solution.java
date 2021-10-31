package chapter02.ex2_1;

import org.json.simple.JSONObject;
import utils.ExerciseSolutions;
import utils.LinkedListNode;
import utils.SolutionTemplate;
import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    private static final String PROBLEM = "Chapter 2. Ex 2.1";

    /**
     * Chapter 2
     * Ex2.1: Remove Dups
     * Question A: Write code to remove duplicates from an unsorted linked list.
     * Question B: How would you solve this problem if a temporary buffer is not allowed?
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        LinkedListNode head = LinkedListNode.createRandomLinkedList(10, 8);
        System.out.print(colorYellow(head.toString()) + " after removing duplicates: ");
        After.removeDuplicatesB(head);
        System.out.println(colorYellow(head.toString()) + ".");
    }

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        LinkedListNode head = LinkedListNode.createRandomLinkedList(params);
        return new ExerciseSolutions(new Before(head.clone()), new After(head.clone()));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}