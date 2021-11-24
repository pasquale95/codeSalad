package chapter02.ex2_2;

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
    private static final String PROBLEM = "Chapter 2. Ex 2.2";
    private static final int KTH = 3;

    /**
     * Chapter 2
     * Ex2.2: Return Kth to Last
     * Implement an algorithm to find the kth to last element of a singly
     * linked list.
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        LinkedListNode<Integer> head = LinkedListNode.createRandomLinkedList(10, 8, i -> i);
        LinkedListNode<Integer> kth = After.findKthToLast(head, KTH);
        if (kth != null) {
            System.out.println("The " + KTH + "th element from last in " + colorYellow(head.toString()) + " is " +
                    colorYellow(String.valueOf(kth.getData())) + ".");
        } else {
            System.out.println(colorRed("The k index " + KTH + " from the last is out-of-bounds for the linked list ")
                    + colorYellow(head.toString()) + ".");
        }
    }

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        LinkedListNode<Integer> head = LinkedListNode.createRandomLinkedList(params, i -> i);
        return new ExerciseSolutions(new Before(head.clone(), 12), new After(head.clone(), 12));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
