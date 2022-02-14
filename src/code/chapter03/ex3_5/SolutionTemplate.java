package chapter03.ex3_5;

import utils.Stack;
import utils.architecture.SolutionStrategy;
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
    protected static final String PROBLEM = "Chapter 3 - Ex 3.5: Sort Stack";
    protected final Integer[] numbers;

    public SolutionTemplate(Integer[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Chapter 3
     * Ex3_5: Sort Stack
     * Write a program to sort a stack such that the smallest items are on the top.
     * You can use an additional temporary stack, but you may not copy the elements
     * into any other data structure (such as an array).
     * The stack supports the following operations: push, pop, peek and isEmpty.
     */
    @Override
    public void runSampleSolution() {
        printBlue(getProblemName());
        Stack<Integer> stack = new Stack<>();
        Integer[] numbers = ArrayGenerator.generateObjectArray(
                10,
                () -> RandomGenerator.randomIntegerGenerator(50),
                Integer.class
        );
        for (Integer number : numbers) {
            stack.push(number);
        }
        System.out.print("The stack " + colorYellow(stack.toString()) + " is sorted to ");
        sortStack(stack);
        System.out.println(colorYellow(stack.toString()) + ".");
    }

    @Override
    public void run() {
        Stack<Integer> stack = new Stack<>();
        for (Integer number : numbers) {
            stack.push(number);
        }
        sortStack(stack);
    }

    @Override
    public String getProblemName() {
        return PROBLEM;
    }

    public abstract void sortStack(Stack<Integer> stack);
}
