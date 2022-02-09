package chapter03.ex3_1;

import org.json.simple.JSONObject;
import utils.architecture.ExerciseSolutions;
import utils.generators.ArrayGenerator;
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
        Integer[] stackSequence = ArrayGenerator.generateObjectArray(
                params,
                () -> RandomGenerator.randomIntegerGenerator(SolutionTemplate.STACKS),
                Integer.class
        );
        return new ExerciseSolutions(
                new chapter03.ex3_1.pre.Solution(numbers, stackSequence),
                new chapter03.ex3_1.post.Solution(numbers, stackSequence)
        );
    }
}