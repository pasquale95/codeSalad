package chapter03.ex3_5;

import chapter03.ex3_5.post.Solution;
import org.json.simple.JSONObject;
import utils.architecture.ProblemTemplate;
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
        return new ExerciseSolutions(new chapter03.ex3_5.pre.Solution(numbers), new Solution(numbers));
    }

    @Override
    protected ProblemTemplate getProblem() {
        return new Problem();
    }
}