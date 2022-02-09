package chapter01.ex1_3;

import org.json.simple.JSONObject;
import utils.architecture.ExerciseSolutions;
import utils.architecture.ComparatorTemplate;
import utils.generators.RandomGenerator;
import utils.generators.StringGenerator;

import static utils.generators.StringGenerator.toCharsWithExtraRoom;

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
        return new ExerciseSolutions(
                new chapter01.ex1_3.pre.Solution(toCharsWithExtraRoom(input), input.length()),
                new chapter01.ex1_3.post.Solution(toCharsWithExtraRoom(input), input.length())
        );
    }
}
