package chapter01.ex1_1;

import org.json.simple.JSONObject;
import utils.architecture.ExerciseSolutions;
import utils.architecture.ComparatorTemplate;
import utils.architecture.ProblemTemplate;
import utils.generators.ArrayGenerator;
import utils.generators.RandomGenerator;
import utils.generators.StringGenerator;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Comparator extends ComparatorTemplate {
    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        String[] strings = ArrayGenerator.generateObjectArray(
                params,
                () -> StringGenerator.generateString(params, () -> RandomGenerator.randomCharGenerator(params)),
                String.class
        );
        return new ExerciseSolutions(
                new chapter01.ex1_1.pre.Solution(strings),
                new chapter01.ex1_1.post.Solution(strings)
        );
    }

    @Override
    protected ProblemTemplate getProblem() {
        return new Problem();
    }
}