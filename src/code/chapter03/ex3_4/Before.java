package chapter03.ex3_4;

import utils.EmptyQueueException;
import utils.Stack;
import utils.StackNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    public static class MyQueue {
        private final Stack<Integer> stack1, stack2;

        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        /**
         * Complexity: O(1)
         *
         * Adds the data at the bottom of the queue.
         * @param   data The data to add.
         */
        public void add(int data) {
            stack1.push(data);
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
            invertStack(stack1, stack2);
            int toRemove = stack2.pop();
            invertStack(stack2, stack1);
            return toRemove;
        }

        /**
         * Complexity: O(n)
         *
         * @return The first element in the queue.
         */
        public int peek() {
            invertStack(stack1, stack2);
            int toPeek = stack2.peek();
            invertStack(stack2, stack1);
            return toPeek;
        }

        public boolean isEmpty() {
            return stack1.isEmpty();
        }

        private void invertStack(Stack<Integer> from, Stack<Integer> to) {
            while (!from.isEmpty()) {
                to.push(from.pop());
            }
        }

        public String toString() {
            return stack1.toString();
        }
    }

    private final int[] numbers;
    private final boolean[] remove;

    public Before(int[] numbers, boolean[] remove) {
        this.numbers = numbers;
        this.remove = remove;
    }

    @Override
    public void run() {
        try {
            MyQueue queue = new MyQueue();
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