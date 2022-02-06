package chapter03.ex3_5;

import utils.Stack;
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
    private static final String PROBLEM = "Chapter 3 - Ex 3.5: Sort Stack";

    /**
     * Chapter 3
     * Ex3_5: Sort Stack
     * Write a program to sort a stack such that the smallest items are on the top.
     * You can use an additional temporary stack, but you may not copy the elements
     * into any other data structure (such as an array).
     * The stack supports the following operations: push, pop, peek and isEmpty.
     */
    public void runSolution(Method sortStack) throws Exception {
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
        sortStack.invoke(null, stack);
        System.out.println(colorYellow(stack.toString()) + ".");
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(
                chapter03.ex3_5.pre.Solution.class.getMethod("sortStack", Stack.class)
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(
                chapter03.ex3_5.post.Solution.class.getMethod("sortStack", Stack.class)
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
