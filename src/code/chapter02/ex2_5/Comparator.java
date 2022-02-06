package chapter02.ex2_5;

import chapter02.ex2_5.pre.Solution;
import org.json.simple.JSONObject;
import utils.*;
import utils.architecture.ExerciseSolutions;
import utils.architecture.ComparatorTemplate;
import utils.architecture.ProblemTemplate;
import utils.generators.ArrayGenerator;
import utils.generators.RandomGenerator;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Comparator extends ComparatorTemplate {

    @Override
    @SuppressWarnings("unchecked")
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        LinkedListNode<Integer>[] addends = ArrayGenerator.generateObjectArray(
                params,
                () -> LinkedListNode.createLinkedList(
                        params,
                        () -> RandomGenerator.randomIntegerGenerator(params)
                ),
                LinkedListNode.class
        );
        return new ExerciseSolutions(new Solution(addends), new chapter02.ex2_5.post.Solution(addends));
    }

    @Override
    protected ProblemTemplate getProblem() {
        return new Problem();
    }
}