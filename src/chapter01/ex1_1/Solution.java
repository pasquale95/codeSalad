package chapter01.ex1_1;

import utils.Timer;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 *
 * Chapter 1
 * Ex1.1: Is unique
 * Question A: Implement an algorithm to determine if a string has all unique characters.
 * Question B: What if you cannot use additional data structures?
 */
public class Solution {

    public static final String PROBLEM = "Chapter 1. Ex 1.1";

    public static void main(String[] args) {
        String[] strings = {"genetics", "salt", "castle", "controlled"};

        Before before = new Before(strings);
        After after = new After(strings);
        Timer timer = new Timer(PROBLEM, before, after);

        timer.start();
    }
}