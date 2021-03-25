package chapter01.ex1_1;

import utils.Timer;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution {

    private static final String PROBLEM = "Chapter 1. Ex 1.1";
    private static final String[] strings = {"genetics", "salt", "castle", "controlled"};

    /**
     * Chapter 1
     * Ex1.1: Is unique
     * Question A: Implement an algorithm to determine if a string has all unique characters.
     * Question B: What if you cannot use additional data structures?
     */
    public static void main(String[] args) {
        System.out.println(PROBLEM);
        for (String string : strings) {
            System.out.println(string + " has unique chars: " + After.isUniqueCharsDifficult(string));
        }
    }

    public static void time() {
        Before before = new Before(strings);
        After after = new After(strings);

        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}