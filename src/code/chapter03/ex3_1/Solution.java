package chapter03.ex3_1;

import utils.ArrayGenerator;
import utils.EmptyStackException;
import utils.StackOverflowException;
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
    private static final int NUMBERS = 200;

    /**
     * Chapter 3
     * Ex3.1: Three in One
     * Describe how you could use a single array to implement three stacks.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        try {
            int[] numbers = ArrayGenerator.generateRandomIntArray(10, 20);
            int[] stackSequence = ArrayGenerator.generateRandomIntArray(10, Before.STACKS);
            After.allocateStack(numbers.length);
            for (int i = 0; i < numbers.length; i++) {
                After.pushToStack(numbers[i], stackSequence[i]);
            }
            System.out.println("Pop from stack 0: " + colorYellow(After.stackToString(0))
                    + " gives " + colorYellow(String.valueOf(After.popFromStack(0)))
                    + ", while pop from stack 1: " + colorYellow(After.stackToString(1))
                    + " gives " + colorYellow(String.valueOf(After.popFromStack(1)))
                    + ", while pop from stack 2: " + colorYellow(After.stackToString(2))
                    + " gives " + colorYellow(String.valueOf(After.popFromStack(2))) + "."
            );
        } catch (StackOverflowException | EmptyStackException e) {
            e.printStackTrace();
        }
    }

    public static void time() {
        int[] numbers = ArrayGenerator.generateRandomIntArray(NUMBERS, 1000);
        int[] stackSequence = ArrayGenerator.generateRandomIntArray(NUMBERS, Before.STACKS);
        Before before = new Before(numbers, stackSequence);
        After after = new After(numbers, stackSequence);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}