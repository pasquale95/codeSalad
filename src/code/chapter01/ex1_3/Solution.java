package chapter01.ex1_3;

import utils.StringGenerator;
import utils.Timer;

import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution {

    public static final String PROBLEM = "Chapter 1. Ex 1.3";
    public static final String input = "Mr John Smith";

    /**
     * Chapter 1
     * Ex1.3: URLify
     * Write a method to replace all spaces in a string with '%20'. You may
     * assume that the string has sufficient space at the end to hold the additional
     * characters, and that you are given the "true" length of the string.
     *
     * NOTE: if implementing in Java, please use a character array so that you can
     * perform this operation in place.
     */
    public static void main(String[] args) {
        printBlue(PROBLEM);
        System.out.println(colorYellow('"' + input + '"') + " urlified: " +
                After.urlify(toCharsWithExtraRoom(input), input.length()));
    }

    public static char[] toCharsWithExtraRoom(String string) {
        char[] chars = new char[3*string.length()-2*string.replace(" ", "").length()];
        for (int i = 0; i < string.length(); i++) {
            chars[i] = string.charAt(i);
        }
        return chars;
    }

    public static void time() {
        String input = StringGenerator.generateRandomString(1000, false);
        Before before = new Before(toCharsWithExtraRoom(input), input.length());
        After after = new After(toCharsWithExtraRoom(input), input.length());
        Timer timer = new Timer(PROBLEM, before, after);

        timer.start();
    }
}
