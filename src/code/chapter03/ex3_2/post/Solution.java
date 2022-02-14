package chapter03.ex3_2.post;

import chapter03.ex3_2.SolutionTemplate;
import utils.exceptions.EmptyStackException;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    protected StackElement top;
    protected StackElement topMin;

    public Solution() {
        super();
    }

    public Solution(Integer[] numbers, Boolean[] minAndPops) {
        super(numbers, minAndPops);
    }

    /**
     * Complexity: O(1)
     *
     * The solution here provided works as in pre.Solution, but we try to
     * save space by keeping min values in a separate stack in order to
     * reduce the space waste of keeping an extra slot in each stack element.
     * @param   data The value to push at the top of the stack.
     */
    @Override
    public void push(int data) {
        StackElement newElement = new StackElement(data);
        if (isEmpty()) {
            top = newElement;
            topMin = new StackElement(data);
        } else {
            newElement.setPrevious(top);
            top = newElement;
            if (data <= topMin.getData()) {
                // update min
                newElement = new StackElement(data);
                newElement.setPrevious(topMin);
                topMin = newElement;
            }
        }
    }

    /**
     * Complexity: O(1)
     *
     * @return  The top value of the stack.
     * @throws EmptyStackException If the stack is empty the pop isn't feasible.
     */
    @Override
    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Error: stack is empty.");
        }
        int toPop = top.getData();
        top = top.getPrevious();
        if (topMin.getData() == toPop) {
            // remove min from second stack
            topMin = topMin.getPrevious();
        }
        return toPop;
    }

    /**
     * Complexity: O(1)
     *
     * @return  The min value in the stack.
     * @throws  EmptyStackException If the stack is empty no min value exists.
     */
    @Override
    public int min() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Error: stack is empty.");
        }
        return topMin.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    /**
     * @return  The stack in string format.
     */
    @Override
    public String stackToString() {
        StackElement runner = top;
        StringBuilder sb = new StringBuilder().append("|");
        while (runner != null) {
            sb.append(runner.getData()).append("|");
            runner = runner.getPrevious();
        }
        return sb.toString();
    }
}