package chapter03.ex3_1;

import org.json.simple.JSONObject;
import utils.architecture.ExerciseSolutions;
import utils.exceptions.EmptyStackException;
import utils.exceptions.StackOverflowException;
import utils.generators.ArrayGenerator;
import utils.architecture.SolutionTemplate;
import utils.generators.RandomGenerator;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    private static final String PROBLEM = "Chapter 3. Ex 3.1";

    /**
     * Chapter 3
     * Ex3.1: Three in One
     * Describe how you could use a single array to implement three stacks.
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        try {
            Integer[] numbers = ArrayGenerator.generateObjectArray(
                    10,
                    () -> RandomGenerator.randomIntegerGenerator(20),
                    Integer.class
            );
            Integer[] stackSequence = ArrayGenerator.generateObjectArray(
                    10,
                    () -> RandomGenerator.randomIntegerGenerator(Before.STACKS),
                    Integer.class
            );
            // set at least 1 element per stack -> prevent emptyStackException
            stackSequence[0] = 0;
            stackSequence[1] = 1;
            stackSequence[2] = 2;
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

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        Integer[] numbers = ArrayGenerator.generateObjectArray(
                params,
                () -> RandomGenerator.randomIntegerGenerator(params),
                Integer.class
        );
        Integer[] stackSequence = ArrayGenerator.generateObjectArray(
                params,
                () -> RandomGenerator.randomIntegerGenerator(Before.STACKS),
                Integer.class
        );
        return new ExerciseSolutions(new Before(numbers, stackSequence), new After(numbers, stackSequence));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}