package chapter02.ex2_2;

import chapter02.ex2_2.pre.Solution;
import org.json.simple.JSONObject;
import utils.architecture.ExerciseSolutions;
import utils.LinkedListNode;
import utils.architecture.ComparatorTemplate;
import utils.architecture.ProblemTemplate;
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
        LinkedListNode<Integer> head = LinkedListNode.createLinkedList(
                params,
                () -> RandomGenerator.randomIntegerGenerator(params)
        );
        return new ExerciseSolutions(new Solution(head.clone(), 12), new chapter02.ex2_2.post.Solution(head.clone(), 12));
    }

    @Override
    protected ProblemTemplate getProblem() {
        return new Problem();
    }
}
