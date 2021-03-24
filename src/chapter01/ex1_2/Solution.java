package chapter01.ex1_2;

import utils.Timer;


/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 *
 * Chapter 1
 * Ex1.2: Check permutations
 * Given two strings, write a method to decide if one
 * is a permutation of the other.
 */
public class Solution {

    public static final String PROBLEM = "Chapter 1. Ex 1.2";

    public static void main(String[] args) {
        String[] strings = {"stressed", "", "School master", "desserts", "The classroom"};

        Before before = new Before(strings);
        After after = new After(strings);
        Timer timer = new Timer(PROBLEM, before, after);

        timer.start();
    }
}