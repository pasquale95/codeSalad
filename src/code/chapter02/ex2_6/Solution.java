package chapter02.ex2_6;

import org.json.simple.JSONObject;
import utils.ExerciseSolutions;
import utils.LinkedListNode;
import utils.SolutionTemplate;
import utils.Timer;
import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    private static final String PROBLEM = "Chapter 2. Ex 2.6";

    /**
     * Chapter 2
     * Ex2.6: Palindrome
     * Implement a function to check if a linked list is palindrome.
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        LinkedListNode head = LinkedListNode.createRandomLinkedList(5, 2);
        System.out.println("The linked list " + colorYellow(head.toString())
                + " is palindrome: " + colorYellow(String.valueOf(After.isPalindrome(head)))
        );
    }

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        LinkedListNode head = LinkedListNode.createRandomLinkedList(params);
        return new ExerciseSolutions(new Before(head), new After(head));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}