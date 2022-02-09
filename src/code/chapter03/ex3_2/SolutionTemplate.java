package chapter03.ex3_2;

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
    private static final String PROBLEM = "Chapter 3 - Ex 3.2: Stack Min";

    /**
     * Chapter 3
     * Ex3_2: Stack Min
     * How would you design a stack which, in addition to push and pop, has a function
     * min which returns the minimum element? Push, pop and min should all operate in O(1) time.
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
            for (Integer number : numbers) {
                solvePush(number);
            }
            System.out.println("Min in stack " + colorYellow(String.valueOf(solveStackToString()))
                    + " is " + colorYellow(String.valueOf(solveMin()))
                    + ". Pop returns " + colorYellow(String.valueOf(solvePop()))
                    + " and the min after the pop is " + colorYellow(String.valueOf(solveMin())) + "."
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public abstract void solvePush(int data);

    public abstract int solvePop() throws EmptyStackException;

    public abstract int solveMin() throws EmptyStackException;

    public abstract String solveStackToString();

    @Override
    public String getProblemName() {
        return PROBLEM;
    }
}
