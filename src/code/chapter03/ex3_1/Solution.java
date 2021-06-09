package chapter03.ex3_1;

import utils.Timer;

import java.util.Random;

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
    private static final int NUMBERS = 200;

    /**
     * Chapter 3
     * Ex3.1: Three in One
     * Describe how you could use a single array to implement three stacks.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        Before.allocateStack(6);
        try {
            After.allocateStack(6);
            After.pushToStack(5, 0);
            After.pushToStack(2, 1);
            After.pushToStack(1, 1);
            After.pushToStack(4, 2);
            After.pushToStack(10, 0);
            After.pushToStack(18, 0);
            System.out.println("Pop from stack 0: " + colorYellow(After.stackToString(0))
                    + "gives: " + After.popFromStack(0)
                    + ", while pop from stack 1: " + colorYellow(After.stackToString(1))
                    + "gives: " + After.popFromStack(1)
                    + ", while pop from stack 2: " + colorYellow(After.stackToString(2))
                    + "gives: " + After.popFromStack(2)
            );
        } catch (StackOverflowException | EmptyStackException e) {
            e.printStackTrace();
        }
    }

    public static void time() {
        int[] numbers = new int[NUMBERS], stackSequence = new int[NUMBERS];
        Random r = new Random();
        for (int i = 0; i < NUMBERS; i++) {
            numbers[i] = r.nextInt(1000);
            stackSequence[i] = r.nextInt(Before.STACKS);
        }
        Before before = new Before(numbers, stackSequence);
        After after = new After(numbers, stackSequence);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}