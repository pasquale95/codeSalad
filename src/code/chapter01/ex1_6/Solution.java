package chapter01.ex1_6;

import org.json.simple.JSONObject;
import utils.architecture.ExerciseSolutions;
import utils.architecture.SolutionTemplate;
import utils.generators.ArrayGenerator;
import utils.generators.RandomGenerator;
import utils.generators.StringGenerator;
import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    public static final String PROBLEM = "Chapter 1. Ex 1.6";
    public static final String TO_COMPRESS = "aaabbbcddaaAAAff";

    /**
     * Chapter 1
     * Ex1.6: String Compression
     * Implement a method to perform basic string compression using the counts of repeated
     * characters. For example, the string "aabcccccaaa" would become "a1b1c5a3". If the compressed
     * string would not become smaller than the original string, your method should return the original
     * string. You can assume the string has only uppercase and lowercase letters (a-z).
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        System.out.println("The string " + colorYellow(TO_COMPRESS) + " after compression becomes "
                + colorYellow(After.compress(TO_COMPRESS)) + ".");
    }

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        String[] strings = ArrayGenerator.generateObjectArray(
                params,
                () -> StringGenerator.generateString(params, () -> RandomGenerator.randomCharGenerator(params)),
                String.class
        );
        return new ExerciseSolutions(new Before(strings), new After(strings));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
