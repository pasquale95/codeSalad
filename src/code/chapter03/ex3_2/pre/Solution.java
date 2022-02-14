package chapter03.ex3_2.pre;

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
    protected Integer size = 0;

    public Solution() {
        super();
    }

    public Solution(Integer[] numbers, Boolean[] minAndPops) {
        super(numbers, minAndPops);
    }

    /**
     * Complexity: O(1)
     *
     * Push the data at the top of the stack and update the min value of the stack.
     * @param   data The value to push at the top of the stack.
     */
    @Override
    public void push(int data) {
        if (isEmpty()) {
            top = new StackElement(data, data);
        } else {
            StackElement newElement;
            int min = top.getMin();
            if (data < min) {
                newElement = new StackElement(data, data);
            } else {
                newElement = new StackElement(data, min);
            }
            newElement.setPrevious(top);
            top = newElement;
        }
        size++;
    }

    /**
     * Complexity: O(1)
     *
     * @return  The top value of the stack.
     * @throws  EmptyStackException If the stack is empty the pop isn't feasible.
     */
    @Override
    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Error: stack is empty.");
        }
        int toPop = top.getData();
        top = top.getPrevious();
        size--;
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
        return top.getMin();
    }

    public boolean isEmpty() {
        return size == 0;
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