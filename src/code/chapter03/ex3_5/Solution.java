package chapter03.ex3_5;

import org.json.simple.JSONObject;
import utils.generators.ArrayGenerator;
import utils.architecture.ExerciseSolutions;
import utils.architecture.SolutionTemplate;
import utils.Stack;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    private static final String PROBLEM = "Chapter 3. Ex 3.5";

    /**
     * Chapter 3
     * Ex3.5: Sort Stack
     * Write a program to sort a stack such that the smallest items are on the top.
     * You can use an additional temporary stack, but you may not copy the elements
     * into any other data structure (such as an array).
     * The stack supports the following operations: push, pop, peek and isEmpty.
     */
    @Override
    public void solve() {
        try {
            printBlue(getProblemName());
            Stack<Integer> stack = new Stack<>();
            int[] numbers = ArrayGenerator.generateRandomIntArray(10, 50);
            for (int number : numbers) {
                stack.push(number);
            }
            System.out.print("The stack " + colorYellow(stack.toString()) + " is sorted to ");
            After.sortStack(stack);
            System.out.println(colorYellow(stack.toString()) + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        int[] numbers = ArrayGenerator.generateRandomIntArray(params);
        return new ExerciseSolutions(new Before(numbers), new After(numbers));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}