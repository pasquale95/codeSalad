package chapter03.ex3_4;

import org.json.simple.JSONObject;
import utils.generators.ArrayGenerator;
import utils.architecture.ExerciseSolutions;
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
    private static final String PROBLEM = "Chapter 3. Ex 3.4";

    /**
     * Chapter 3
     * Ex3.4: Queue via Stacks
     * Implement a MyQueue class which implements a queue using two stacks.
     */
    @Override
    public void solve() {
        try {
            printBlue(getProblemName());
            Integer[] numbers = ArrayGenerator.generateObjectArray(
                    10,
                    () -> RandomGenerator.randomIntegerGenerator(50),
                    Integer.class
            );
            After.MyQueue queue = new After.MyQueue();
            for (Integer number : numbers) {
                queue.add(number);
            }
            System.out.print("Removing from the queue twice " + colorYellow(queue.toString())
                    + " returns " + colorYellow(String.valueOf(queue.remove()))
                    + " and " + colorYellow(String.valueOf(queue.remove())) + ". "
            );
            int randValue = RandomGenerator.randomIntegerGenerator(100);
            queue.add(randValue);
            System.out.println("After adding " + colorYellow(String.valueOf(randValue))
                    + ", the queue becomes " + colorYellow(queue.toString())
                    + ", removing gives " + colorYellow(String.valueOf(queue.remove())) + "."
            );
        } catch (Exception e) {
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
        Boolean[] booleans = ArrayGenerator.generateObjectArray(
                params,
                RandomGenerator::randomBooleanGenerator,
                Boolean.class
        );
        return new ExerciseSolutions(new Before(numbers, booleans), new After(numbers, booleans));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}