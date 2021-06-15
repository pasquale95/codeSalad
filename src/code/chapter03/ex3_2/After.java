package chapter03.ex3_2;

import utils.EmptyStackException;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    static class StackElement {
        private final int data;
        private StackElement previous;

        public StackElement(int data) {
            this.data = data;
        }

        public void setPrevious(StackElement previous) {
            this.previous = previous;
        }

        public StackElement getPrevious() {
            return this.previous;
        }

        public int getData() {
            return data;
        }
    }

    private static StackElement top;
    private static StackElement topMin;
    private final int[] numbers;
    private final boolean[] minAndPops;

    public After(int[] numbers, boolean[] minAndPops) {
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
     * The solution here provided works as in Before, but we try to
     * save space by keeping min values in a separate stack in order to
     * reduce the space waste of keeping an extra slot in each stack element.
     * @param   data The value to push at the top of the stack.
     */
    public static void push(int data) {
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
    public static int pop() throws EmptyStackException {
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
    public static int min() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Error: stack is empty.");
        }
        return topMin.getData();
    }

    public static boolean isEmpty() {
        return top == null;
    }

    public static String stackToString() {
        StackElement runner = top;
        StringBuilder sb = new StringBuilder().append("| ");
        while (runner != null) {
            sb.append(runner.getData()).append(" | ");
            runner = runner.getPrevious();
        }
        return sb.toString();
    }
}