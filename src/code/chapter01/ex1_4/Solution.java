package chapter01.ex1_4;

import org.json.simple.JSONObject;
import utils.ExerciseSolutions;
import utils.SolutionTemplate;
import utils.Generators.StringGenerator;
import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    public static final String PROBLEM = "Chapter 1. Ex 1.4";
    public static final String input = "Tact Coa";

    /**
     * Chapter 1
     * Ex1.4: Palindrome Permutation
     * Given a string, write a function to check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards.
     * A permutation is a rearrangement of letters.
     * The palindrome does not need to be limited to just dictionary words.
     * You can ignore casing and non-letter characters.
     */
    @Override
    public void solve() {
        printBlue(getProblemName());
        System.out.println(colorYellow('"' + input + '"') + " is a permutation of a palindrome: " +
                colorYellow(String.valueOf(After.isPermutationOfPalindrome(input))) + ".");
    }

    @Override
    protected ExerciseSolutions getExerciseSolutions(JSONObject params) {
        String input = StringGenerator.generateRandomString(params);
        return new ExerciseSolutions(new Before(input), new After(input));
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
