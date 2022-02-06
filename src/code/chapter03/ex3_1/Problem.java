package chapter03.ex3_1;

import chapter03.ex3_1.pre.Solution;
import utils.architecture.ProblemTemplate;
import utils.generators.ArrayGenerator;
import utils.generators.RandomGenerator;

import java.lang.reflect.Method;

import static utils.Colors.colorYellow;
import static utils.Colors.printBlue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Problem extends ProblemTemplate {
    private static final String PROBLEM = "Chapter 3 - Ex 3.1: Three in One";

    /**
     * Chapter 3
     * Ex3_1: Three in One
     * Describe how you could use a single array to implement three stacks.
     */
    public void runSolution(
            Method allocateStack,
            Method pushToStack,
            Method popFromStack
    ) throws Exception {
        printBlue(getProblemName());
        Integer[] numbers = ArrayGenerator.generateObjectArray(
                10,
                () -> RandomGenerator.randomIntegerGenerator(20),
                Integer.class
        );
        Integer[] stackSequence = ArrayGenerator.generateObjectArray(
                10,
                () -> RandomGenerator.randomIntegerGenerator(Solution.STACKS),
                Integer.class
        );
        // set at least 1 element per stack -> prevent emptyStackException
        stackSequence[0] = 0;
        stackSequence[1] = 1;
        stackSequence[2] = 2;
        allocateStack.invoke(null, numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            pushToStack.invoke(null, numbers[i], stackSequence[i]);
        }
        System.out.println("Pop from stack 0: " + colorYellow(chapter03.ex3_1.post.Solution.stackToString(0))
                + " gives " + colorYellow(String.valueOf(popFromStack.invoke(null, 0)))
                + ", while pop from stack 1: " + colorYellow(chapter03.ex3_1.post.Solution.stackToString(1))
                + " gives " + colorYellow(String.valueOf(popFromStack.invoke(null, 1)))
                + ", while pop from stack 2: " + colorYellow(chapter03.ex3_1.post.Solution.stackToString(2))
                + " gives " + colorYellow(String.valueOf(popFromStack.invoke(null, 2))) + "."
        );
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(
                chapter03.ex3_1.pre.Solution.class.getMethod("allocateStack", int.class),
                chapter03.ex3_1.pre.Solution.class.getMethod("pushToStack", int.class, int.class),
                chapter03.ex3_1.pre.Solution.class.getMethod("popFromStack", int.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(
                chapter03.ex3_1.post.Solution.class.getMethod("allocateStack", int.class),
                chapter03.ex3_1.post.Solution.class.getMethod("pushToStack", int.class, int.class),
                chapter03.ex3_1.post.Solution.class.getMethod("popFromStack", int.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
