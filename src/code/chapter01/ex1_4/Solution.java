package chapter01.ex1_4;

import utils.Timer;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution {

    public static final String PROBLEM = "Chapter 1. Ex 1.4";
    public static final String input = "Tact Coa";

    /**
     * Chapter 1
     * Ex1.3: Palindrome Permutation
     * TODO
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        System.out.println(colorYellow('"' + input + '"') + " is a permutation of a palindrome: " +
                After.isPermutationOfPalindrome(input));
    }

    public static void time() {
        Before before = new Before(input);
        After after = new After(input);
        Timer timer = new Timer(PROBLEM, before, after);

        timer.start();
    }
}
