package chapter01.ex1_4;

import chapter01.ex1_4.pre.Solution;
import org.json.simple.JSONObject;
import utils.architecture.ExerciseSolutions;
import utils.architecture.ComparatorTemplate;
import utils.architecture.ProblemTemplate;
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
        String input = StringGenerator.generateString(params, () -> RandomGenerator.randomCharGenerator(params));
        return new ExerciseSolutions(new Solution(input), new chapter01.ex1_4.post.Solution(input));
    }

    @Override
    protected ProblemTemplate getProblem() {
        return new Problem();
    }
}
