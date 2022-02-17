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
    protected static final String PROBLEM = "Chapter 3 - Ex 3_1: Three in One";
    protected final Integer[] numbers;
    protected final Integer[] stackSequence;
    protected Integer[] stack;
    protected static final int STACKS = 3;

    /**
     * Chapter 3
     * Ex3_1: Three in One
     * Describe how you could use a single array to implement three stacks.
     *
     * @param numbers The numbers to push in the stacks.
     * @param stackSequence Array containing the stack number where to push the number at the same index in "numbers".
     */
    public SolutionTemplate(Integer[] numbers, Integer[] stackSequence) {
        this.numbers = numbers;
        this.stackSequence = stackSequence;
        if (numbers != null) {
            allocateStack(numbers.length);
        }
    }

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

    @Override
    public void run() {
        try {
            for (int i = 0; i < numbers.length && i < stackSequence.length; i++) {
                pushToStack(numbers[i], stackSequence[i]);
            }
            for (int i : stackSequence) {
                popFromStack(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    public abstract void allocateStack(Integer size);

    public abstract void pushToStack(Integer data, Integer stackNumber) throws StackOverflowException;

    public abstract Integer popFromStack(Integer stackNumber) throws EmptyStackException;

    public abstract String stackToString(Integer stackNumber);
}
