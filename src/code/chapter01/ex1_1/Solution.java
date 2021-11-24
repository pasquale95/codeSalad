package chapter01.ex1_1;

import org.json.simple.JSONObject;
import utils.ExerciseSolutions;
import utils.SolutionTemplate;
import utils.Generators.StringGenerator;
import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    private static final String PROBLEM = "Chapter 1. Ex 1.1";
    private static final String[] strings = {"genetics", "salt", "castle", "controlled"};

    /**
     * Chapter 1
     * Ex1.1: Is unique
     * Question A: Implement an algorithm to determine if a string has all unique characters.
     * Question B: What if you cannot use additional data structures?
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        for (String string : strings) {
            System.out.println(colorYellow('"' + string + '"') + " has unique chars: "
                    + colorYellow(String.valueOf(After.isUniqueCharsB(string))) + ".");
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