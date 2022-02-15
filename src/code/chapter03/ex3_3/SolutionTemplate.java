package chapter03.ex3_3;

import chapter03.ex3_3.pre.SetOfStacks;
import utils.architecture.SolutionStrategy;
import utils.exceptions.EmptyStackException;
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
    protected static final String PROBLEM = "Chapter 3 - Ex 3_3: Stack of plates";
    protected Integer[] numbers;
    protected int threshold;

    public SolutionTemplate(Integer[] numbers, int threshold) {
        this.numbers = numbers;
        this.threshold = threshold;
    }

    /**
     * Chapter 3
     * Ex3_3: Stack of plates
     * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
     * Therefore, in real life, we would likely start a new stack when the previous stack exceeds
     * some threshold.
     * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of
     * several stacks and should create a new stack once the previous one exceeds capacity.
     * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is,
     * pop() should return the same values as it would if there were just a single stack).
     *
     * FOLLOW-UP
     * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
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
            SetOfStacksStrategy setOfStacks = getSetOfStacksInstance(4);
            for (Integer number : numbers) {
                setOfStacks.push(number);
            }
            System.out.println("Set of stacks is composed by these stacks: " + colorYellow(setOfStacks.toString())
                    + "; 3 pops return respectively "
                    + colorYellow(String.valueOf(setOfStacks.pop())) + ", "
                    + colorYellow(String.valueOf(setOfStacks.pop())) + " and "
                    + colorYellow(String.valueOf(setOfStacks.pop())) + "; "
                    + "pop from 1st stack returns " + colorYellow(String.valueOf(setOfStacks.popAt(0))) + ". "
                    + "Now the set of stacks is: " + colorYellow(setOfStacks.toString()) + "."
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            SetOfStacksStrategy setOfStacks = getSetOfStacksInstance(this.threshold);
            // measure push()
            for (int number : this.numbers) {
                setOfStacks.push(number);
            }
            // measure popAt()
            for (int i = 0; i < setOfStacks.getStacks(); i++) {
                setOfStacks.popAt(i);
            }
            // measure pop()
            for (int i = 0; i < this.numbers.length / 2; i++) {
                setOfStacks.pop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract SetOfStacksStrategy getSetOfStacksInstance(int stacks);

    @Override
    public String getProblemName() {
        return PROBLEM;
    }
}
