package chapter01.ex1_2;

import org.json.simple.JSONObject;
import utils.ExerciseSolutions;
import utils.SolutionTemplate;
import utils.StringGenerator;
import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    public static final String PROBLEM = "Chapter 1. Ex 1.2";
    public static final String[] strings = {"stressed", "School master", "desserts", "The classroom"};

    /**
     * Chapter 1
     * Ex1.2: Check permutations
     * Given two strings, write a method to decide if one
     * is a permutation of the other.
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                System.out.println(colorYellow('"' + strings[i] + '"')
                        + " and " + colorYellow('"' + strings[j] + '"')
                        + " are permutations: "
                        + colorYellow(String.valueOf(After.arePermutations(strings[i], strings[j]))) + "."
                );
            }
        }
    }

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        String[] strings = StringGenerator.generateRandomStringArray(params);
        return new ExerciseSolutions(new Before(strings), new After(strings));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}