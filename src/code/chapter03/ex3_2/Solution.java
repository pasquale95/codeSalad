package chapter03.ex3_2;

import utils.ArrayGenerator;
import utils.EmptyStackException;

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

    /**
     * Chapter 3
     * Ex3.2: TODO
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        try {
            int[] numbers = ArrayGenerator.generateRandomIntArray(10, 20);
            for (int number : numbers) {
                Before.push(number);
            }
            System.out.println("Min in stack " + colorYellow(Before.stackToString())
                    + "is " + Before.min()
                    + ". Pop returns " + Before.pop()
                    + " and the min after the pop is " + Before.min() + "."
            );
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
    }

    public static void time() {
        //int[] numbers = new int[NUMBERS], stackSequence = new int[NUMBERS];
        //Random r = new Random();
        //for (int i = 0; i < NUMBERS; i++) {
        //    numbers[i] = r.nextInt(1000);
        //    stackSequence[i] = r.nextInt(Before.STACKS);
        //}
        //Before before = new Before(numbers, stackSequence);
        //After after = new After(numbers, stackSequence);
        //Timer timer = new Timer(PROBLEM, before, after);
        //timer.start();
    }
}