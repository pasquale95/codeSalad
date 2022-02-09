package chapter03.ex3_4;

import utils.architecture.SolutionStrategy;
import utils.exceptions.EmptyQueueException;
import utils.generators.ArrayGenerator;
import utils.generators.RandomGenerator;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class SolutionTemplate implements SolutionStrategy {
    private static final String PROBLEM = "Chapter 3 - Ex 3.4: Queue via Stacks";

    public interface MyQueue {
        void add(int data);
        int remove() throws EmptyQueueException;
    }

    /**
     * Chapter 3
     * Ex3_4: Queue via Stacks
     * Implement a MyQueue class which implements a queue using two stacks.
     */
    @Override
    public void runSampleSolution() {
        try {
            printBlue(getProblemName());
            Integer[] numbers = ArrayGenerator.generateObjectArray(
                    10,
                    () -> RandomGenerator.randomIntegerGenerator(50),
                    Integer.class
            );
            MyQueue queue = getMyQueueInstance();
            for (Integer number : numbers) {
                queue.add(number);
            }
            System.out.print("Removing from the queue twice " + colorYellow(queue.toString())
                    + " returns " + colorYellow(String.valueOf(queue.remove()))
                    + " and " + colorYellow(String.valueOf(queue.remove())) + ". "
            );
            int randValue = RandomGenerator.randomIntegerGenerator(100);
            queue.add(randValue);
            System.out.println("After adding " + colorYellow(String.valueOf(randValue))
                    + ", the queue becomes " + colorYellow(queue.toString())
                    + ", removing gives " + colorYellow(String.valueOf(queue.remove())) + "."
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public abstract MyQueue getMyQueueInstance();

    @Override
    public String getProblemName() {
        return PROBLEM;
    }
}
