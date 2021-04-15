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
     * TODO
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        Before.allocateStack(6);
        try {
            Before.pushFirstStack(5);
            Before.pushSecondStack(2);
            Before.pushSecondStack(1);
            Before.pushThirdStack(4);
            Before.pushFirstStack(10);
            Before.pushFirstStack(18);
            System.out.println("Pop from " + colorYellow(Before.firstStackToString())
                    + "gives: " + Before.popFirstStack()
                    + ", while pop from " + colorYellow(Before.secondStackToString())
                    + "gives: " + Before.popSecondStack()
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