package chapter01.ex1_6;

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
    public static void main(String[] args) {
        printBlue(PROBLEM);
        System.out.println("The string " + colorYellow(TO_COMPRESS) + " after compression becomes "
                + colorYellow(After.compress(TO_COMPRESS)) + ".");
    }

    public static void time() {
        String[] input = StringGenerator.generateRandomStringArray(100, 20, false);
        Before before = new Before(input);
        After after = new After(input);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}
