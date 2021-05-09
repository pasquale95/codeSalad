package chapter03.ex3_1;

import utils.LinkedListNode;
import utils.Timer;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution {

    private static final String PROBLEM = "Chapter 3. Ex 3.1";

    /**
     * Chapter 3
     * Ex3.1: Three in One
     * Describe how you could use a single array to implement three stacks.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        Before.allocateStack(6);
        try {
            Before.pushToStack(5, 1);
            Before.pushToStack(2, 2);
            Before.pushToStack(1, 2);
            Before.pushToStack(4, 3);
            Before.pushToStack(10, 1);
            Before.pushToStack(18, 1);
            System.out.println("Pop from stack 1: " + colorYellow(Before.stackToString(1))
                    + "gives: " + Before.popFromStack(1)
                    + ", while pop from stack 2: " + colorYellow(Before.stackToString(2))
                    + "gives: " + Before.popFromStack(2)
                    + ", while pop from stack 3: " + colorYellow(Before.stackToString(3))
                    + "gives: " + Before.popFromStack(3)
            );
        } catch (StackOverflowException | EmptyStackException e) {
            e.printStackTrace();
        }
    }

    public static void time() {
        // TODO
        //LinkedListNode head = LinkedListNode.createRandomLinkedList(200, 200);
        //Before before = new Before(head.clone());
        //After after = new After(head.clone());
        //Timer timer = new Timer(PROBLEM, before, after);
        //timer.start();
    }
}