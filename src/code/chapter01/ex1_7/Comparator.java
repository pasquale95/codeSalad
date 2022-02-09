package chapter01.ex1_7;

import org.json.simple.JSONObject;
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
        Integer[][] matrix = ArrayGenerator.generateObjectMatrix(
                params,
                () -> RandomGenerator.randomIntegerGenerator(params),
                Integer.class
        );
        return new ExerciseSolutions(
                new chapter01.ex1_7.pre.Solution(matrix),
                new chapter01.ex1_7.post.Solution(matrix)
        );
    }
}