package chapter03.ex3_4;

import chapter03.ex3_4.pre.MyQueue;
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
    protected static final String PROBLEM = "Chapter 3 - Ex 3.4: Queue via Stacks";
    protected final Integer[] numbers;
    protected final Boolean[] remove;

    public SolutionTemplate(Integer[] numbers, Boolean[] remove) {
        this.numbers = numbers;
        this.remove = remove;
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
            MyQueueStrategy queue = getMyQueueInstance();
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

    @Override
    public void run() {
        try {
            MyQueue queue = new MyQueue();
            for (int i = 0; i < numbers.length; i++) {
                queue.add(numbers[i]);
                if (remove[i]) {
                    queue.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    public abstract MyQueueStrategy getMyQueueInstance();
}
