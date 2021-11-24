package chapter03.ex3_4;

import utils.exceptions.EmptyQueueException;
import utils.Stack;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    public static class MyQueue {

        private final Stack<Integer> stack1, stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Complexity: O(1)
         *
         * Adds the data at the bottom of the queue.
         * @param   data The data to add.
         */
        public void add(int data) {
            this.stack1.push(data);
        }

        /**
         * Complexity: O(n)
         *
         * Returns and removes the first element in the queue.
         * @return The first element in the queue.
         */
        public int remove() throws EmptyQueueException {
            if (isEmpty()) {
                throw new EmptyQueueException("Error: queue is empty.");
            }
            if (stack2.isEmpty()) {
                fillStack2();
            }
            return stack2.pop();
        }

        /**
         * Complexity: O(n)
         *
         * @return The first element in the queue.
         */
        public int peek() {
            if (stack2.isEmpty()) {
                fillStack2();
            }
            return stack2.peek();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        private void fillStack2() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        public String toString() {
            // bottom comes from stack1
            StringBuilder sb = new StringBuilder();
            if (!stack1.isEmpty()) {
                sb.append(stack1);
            }
            // then add stack2 content reversed
            if (!stack2.isEmpty()) {
                sb.append(stack2.toStringReversed().substring(1));
            }
            return sb.toString();
        }
    }

    private final int[] numbers;
    private final boolean[] remove;

    public After(int[] numbers, boolean[] remove) {
        this.numbers = numbers;
        this.remove = remove;
    }

    @Override
    public void run() {
        try {
            Before.MyQueue queue = new Before.MyQueue();
            for (int i = 0; i < numbers.length; i++) {
                queue.add(numbers[i]);
                if (remove[i]) {
                    queue.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}