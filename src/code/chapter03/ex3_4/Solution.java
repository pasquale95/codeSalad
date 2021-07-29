package chapter03.ex3_4;

import org.json.simple.JSONObject;
import utils.ArrayGenerator;
import utils.EmptyStackException;
import utils.Timer;

import java.util.Random;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution {

    private static final String PROBLEM = "Chapter 3. Ex 3.4";

    /**
     * Chapter 3
     * Ex3.4: Queue via Stacks
     * Implement a MyQueue class which implements a queue using two stacks.
     */
    public static void main(String[] args) {
        try {
            printBlue(PROBLEM);
            int[] numbers = ArrayGenerator.generateRandomIntArray(10, 50);
            After.MyQueue queue = new After.MyQueue();
            for (int number : numbers) {
                queue.add(number);
            }
            System.out.print("Removing from the queue twice " + colorYellow(queue.toString())
                    + " returns " + colorYellow(String.valueOf(queue.remove()))
                    + " and " + colorYellow(String.valueOf(queue.remove())) + ". "
            );
            Random r = new Random();
            int randValue = r.nextInt(100);
            queue.add(randValue);
            System.out.println("After adding " + colorYellow(String.valueOf(randValue))
                    + ", the queue becomes " + colorYellow(queue.toString())
                    + ", removing gives " + colorYellow(String.valueOf(queue.remove())) + "."
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void time(JSONObject params) {
        int[] numbers = ArrayGenerator.generateRandomIntArray(params);
        boolean[] booleans = ArrayGenerator.generateRandomBooleanArray(((Long)params.get("size")).intValue());
        Before before = new Before(numbers, booleans);
        After after = new After(numbers, booleans);
        Timer timer = new Timer(PROBLEM, before, after);
        timer.start();
    }
}