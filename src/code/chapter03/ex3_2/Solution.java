package chapter03.ex3_2;

import org.json.simple.JSONObject;
import utils.generators.ArrayGenerator;
import utils.exceptions.EmptyStackException;
import utils.architecture.ExerciseSolutions;
import utils.architecture.SolutionTemplate;
import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    private static final String PROBLEM = "Chapter 3. Ex 3.2";

    /**
     * Chapter 3
     * Ex3.2: Stack Min
     * How would you design a stack which, in addition to push and pop, has a function
     * min which returns the minimum element? Push, pop and min should all operate in O(1) time.
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
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

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        int[] numbers = ArrayGenerator.generateRandomIntArray(params);
        boolean[] booleans = ArrayGenerator.generateRandomBooleanArray(((Long)params.get("size")).intValue());
        return new ExerciseSolutions(new Before(numbers, booleans), new After(numbers, booleans));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}