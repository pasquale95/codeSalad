package chapter03.ex3_3;

import chapter03.ex3_2.After;
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

    private static final String PROBLEM = "Chapter 3. Ex 3.3";
    private static final int THRESHOLD = 4;

    /**
     * Chapter 3
     * Ex3.3: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
     * Therefore, in real life, we would likely start a new stack when the previous stack exceeds
     * some threshold.
     * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of
     * several stacks and should create a new stack once the previous one exceeds capacity.
     * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is,
     * pop() should return the same values as it would if there were just a single stack).
     *
     * FOLLOW UP
     * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        try {
            int[] numbers = ArrayGenerator.generateRandomIntArray(10, 20);
            Before.SetOfStacks setOfStacks = Before.retrieveSetOfStacks(THRESHOLD);
            for (int number : numbers) {
                setOfStacks.push(number);
            }
            System.out.println("Set of stacks is composed by these stacks: " + colorYellow(setOfStacks.toString())
                    + "; 2 pops return respectively "
                    + colorYellow(String.valueOf(setOfStacks.pop())) + " and "
                    + colorYellow(String.valueOf(setOfStacks.pop())) + "; "
                    + "pop from 1st stack returns " + colorYellow(String.valueOf(setOfStacks.popAt(0))) + ". "
                    + "Now the set of stacks is: " + colorYellow(setOfStacks.toString()) + "."
            );
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
    }

    public static void time() {
        // TODO
        //int[] numbers = ArrayGenerator.generateRandomIntArray(SIZE, 10000);
        //boolean[] booleans = ArrayGenerator.generateRandomBooleanArray(SIZE);
        //Before before = new Before(numbers, booleans);
        //After after = new After(numbers, booleans);
        //Timer timer = new Timer(PROBLEM, before, after);
        //timer.start();
    }
}