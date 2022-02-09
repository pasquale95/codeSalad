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

    static class StackElement {
        private final int data, min;
        private StackElement previous;

        public StackElement(int data, int min) {
            this.data = data;
            this.min = min;
        }

        public void setPrevious(StackElement previous) {
            this.previous = previous;
        }

        public StackElement getPrevious() {
            return this.previous;
        }

        public int getMin() {
            return min;
        }

        public int getData() {
            return data;
        }
    }

    private static StackElement top;
    private static int size = 0;
    private final Integer[] numbers;
    private final Boolean[] minAndPops;

    public Solution(Integer[] numbers, Boolean[] minAndPops) {
        this.numbers = numbers;
        this.minAndPops = minAndPops;
    }

    @Override
    public void run() {
        try {
            for (int data : numbers) {
                push(data);
            }
            for (boolean isPop : minAndPops) {
                if (isPop) {
                    pop();
                } else {
                    min();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Complexity: O(1)
     *
     * Push the data at the top of the stack and update the min value of the stack.
     * @param   data The value to push at the top of the stack.
     */
    public static void push(int data) {
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
    public static int pop() throws EmptyStackException {
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
    public static int min() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Error: stack is empty.");
        }
        return top.getMin();
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void solvePush(int data) {
        push(data);
    }

    @Override
    public int solvePop() throws EmptyStackException {
        return pop();
    }

    @Override
    public int solveMin() throws EmptyStackException {
        return min();
    }

    /**
     * @return  The stack in string format.
     */
    @Override
    public String solveStackToString() {
        StackElement runner = top;
        StringBuilder sb = new StringBuilder().append("|");
        while (runner != null) {
            sb.append(runner.getData()).append("|");
            runner = runner.getPrevious();
        }
        return sb.toString();
    }
}