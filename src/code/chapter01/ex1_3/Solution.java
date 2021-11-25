package chapter01.ex1_3;

import org.json.simple.JSONObject;
import utils.architecture.ExerciseSolutions;
import utils.architecture.SolutionTemplate;
import utils.generators.RandomGenerator;
import utils.generators.StringGenerator;

import java.util.Random;

import static utils.Colors.*;
import static utils.generators.StringGenerator.toCharsWithExtraRoom;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    public static final String PROBLEM = "Chapter 1. Ex 1.3";
    public static final String input = "Mr John Smith";

    /**
     * Chapter 1
     * Ex1.3: URLify
     * Write a method to replace all spaces in a string with '%20'. You may
     * assume that the string has sufficient space at the end to hold the additional
     * characters, and that you are given the "true" length of the string.
     *
     * NOTE: if implementing in Java, please use a character array so that you can
     * perform this operation in place.
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        System.out.println(colorYellow('"' + input + '"') + " urlified: " +
                colorYellow(After.urlify(toCharsWithExtraRoom(input), input.length())) + ".");
    }

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        String input = StringGenerator.generateString(params, () -> RandomGenerator.randomCharGenerator(params));
        return new ExerciseSolutions(
                new Before(toCharsWithExtraRoom(input), input.length()),
                new After(toCharsWithExtraRoom(input), input.length())
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
