package chapter03.ex3_2;

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
    private static final String PROBLEM = "Chapter 3 - Ex 3.2: Stack Min";

    /**
     * Chapter 3
     * Ex3_2: Stack Min
     * How would you design a stack which, in addition to push and pop, has a function
     * min which returns the minimum element? Push, pop and min should all operate in O(1) time.
     */
    public void runSolution(
            Method push,
            Method pop,
            Method min,
            Method stackToString
    ) throws Exception {
        printBlue(getProblemName());
        Integer[] numbers = ArrayGenerator.generateObjectArray(
                10,
                () -> RandomGenerator.randomIntegerGenerator(20),
                Integer.class
        );
        for (Integer number : numbers) {
            push.invoke(null, number);
        }
        System.out.println("Min in stack " + colorYellow(String.valueOf(stackToString.invoke(null)))
                + " is " + colorYellow(String.valueOf(min.invoke(null)))
                + ". Pop returns " + colorYellow(String.valueOf(pop.invoke(null)))
                + " and the min after the pop is " + colorYellow(String.valueOf(min.invoke(null))) + "."
        );
    }

    @Override
    public void solutionPre() throws Exception {
        runSolution(
                chapter03.ex3_2.pre.Solution.class.getMethod("push", int.class),
                chapter03.ex3_2.pre.Solution.class.getMethod("pop"),
                chapter03.ex3_2.pre.Solution.class.getMethod("min"),
                chapter03.ex3_2.pre.Solution.class.getMethod("stackToString")
        );
    }

    @Override
    public void solutionPost() throws Exception {
        runSolution(
                chapter03.ex3_2.post.Solution.class.getMethod("push", int.class),
                chapter03.ex3_2.post.Solution.class.getMethod("pop"),
                chapter03.ex3_2.post.Solution.class.getMethod("min"),
                chapter03.ex3_2.post.Solution.class.getMethod("stackToString")
        );
    }

    @Override
    protected String getProblemName() {
        return PROBLEM;
    }
}
