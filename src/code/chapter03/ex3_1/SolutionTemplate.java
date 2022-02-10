package chapter03.ex3_1;

import utils.architecture.SolutionStrategy;
import utils.exceptions.EmptyStackException;
import utils.exceptions.StackOverflowException;
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
    private static final String PROBLEM = "Chapter 3 - Ex 3.1: Three in One";
    protected static final int STACKS = 3;
    protected int[] stack;

    /**
     * Chapter 3
     * Ex3_1: Three in One
     * Describe how you could use a single array to implement three stacks.
     */
    @Override
    public void runSampleSolution() {
        try {
            printBlue(getProblemName());
            Integer[] numbers = ArrayGenerator.generateObjectArray(
                    10,
                    () -> RandomGenerator.randomIntegerGenerator(20),
                    Integer.class
            );
            Integer[] stackSequence = ArrayGenerator.generateObjectArray(
                    10,
                    () -> RandomGenerator.randomIntegerGenerator(STACKS),
                    Integer.class
            );
            // set at least 1 element per stack -> prevent emptyStackException
            stackSequence[0] = 0;
            stackSequence[1] = 1;
            stackSequence[2] = 2;
            allocateStack(numbers.length);
            for (int i = 0; i < numbers.length; i++) {
                pushToStack(numbers[i], stackSequence[i]);
            }
            System.out.println("Pop from stack 0: " + colorYellow(stackToString(0))
                    + " gives " + colorYellow(String.valueOf(popFromStack(0)))
                    + ", while pop from stack 1: " + colorYellow(stackToString(1))
                    + " gives " + colorYellow(String.valueOf(popFromStack(1)))
                    + ", while pop from stack 2: " + colorYellow(stackToString(2))
                    + " gives " + colorYellow(String.valueOf(popFromStack(2)))
                    + "."
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public abstract void allocateStack(int size);

    public abstract void pushToStack(int data, int stackNumber) throws StackOverflowException;

    public abstract int popFromStack(int stackNumber) throws EmptyStackException;

    public abstract String stackToString(int stackNumber);

    @Override
    public String getProblemName() {
        return PROBLEM;
    }
}
