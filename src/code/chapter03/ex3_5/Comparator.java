package chapter03.ex3_5;

import org.json.simple.JSONObject;
import utils.Stack;
import utils.generators.ArrayGenerator;
import utils.architecture.ExerciseSolutions;
import utils.architecture.ComparatorTemplate;
import utils.generators.RandomGenerator;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Comparator extends ComparatorTemplate {

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        Integer[] numbers = ArrayGenerator.generateObjectArray(
                params,
                () -> RandomGenerator.randomIntegerGenerator(params),
                Integer.class
        );
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (Integer number : numbers) {
            stack1.push(number);
            stack2.push(number);
        }
        return new ExerciseSolutions(
                new chapter03.ex3_5.pre.Solution(stack1),
                new chapter03.ex3_5.post.Solution(stack1.clone())
        );
    }
}