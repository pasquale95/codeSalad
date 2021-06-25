package chapter03.ex3_2;

import utils.ArrayGenerator;
import utils.EmptyStackException;
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

    private static final String PROBLEM = "Chapter 3. Ex 3.2";
    private static final int SIZE = 5000;

    /**
     * Chapter 3
     * Ex3.2: Stack Min
     * How would you design a stack which, in addition to push and pop, has a function
     * min which returns the minimum element? Push, pop and min should all operate in O(1) time.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        try {
            int[] numbers = ArrayGenerator.generateRandomIntArray(10, 20);
            for (int number : numbers) {
                After.push(number);
            }
            System.out.println("Min in stack " + colorYellow(After.stackToString())
                    + " is " + colorYellow(String.valueOf(After.min()))
                    + ". Pop returns " + colorYellow(String.valueOf(After.pop()))
                    + " and the min after the pop is " + colorYellow(String.valueOf(After.min())) + "."
            );
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
    }

    public static void time() {
        int[] numbers = ArrayGenerator.generateRandomIntArray(SIZE, 10000);
        boolean[] booleans = ArrayGenerator.generateRandomBooleanArray(SIZE);
        Before before = new Before(numbers, booleans);
        After after = new After(numbers, booleans);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}