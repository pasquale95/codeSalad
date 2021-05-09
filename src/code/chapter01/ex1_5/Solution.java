package chapter01.ex1_5;

import utils.StringGenerator;
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

    public static final String PROBLEM = "Chapter 1. Ex 1.5";
    public static final String one = "pales";
    public static final String two = "pale";
    public static final String three = "ple";

    /**
     * Chapter 1
     * Ex1.5: One Away
     * There are three types of edits that can be performed on strings:
     * insert a character, remove a character, or replace a character.
     * Given two strings, write a function to check if they are one edit
     * (or zero edits) away.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        System.out.println("The strings " + colorYellow(one) + " and " + colorYellow(two) +
                " are one edit away: " + After.areOneAway(one, two));
        System.out.println("The strings " + colorYellow(one) + " and " + colorYellow(three) +
                " are one edit away: " + After.areOneAway(one, three));
        System.out.println("The strings " + colorYellow(two) + " and " + colorYellow(three) +
                " are one edit away: " + After.areOneAway(two, three));
    }

    public static void time() {
        String[] input = StringGenerator.generateRandomStringArray(100, 10, false);
        Before before = new Before(input);
        After after = new After(input);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}