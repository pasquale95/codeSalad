package chapter03.ex3_4.post;

import chapter03.ex3_4.MyQueueStrategy;
import utils.Stack;
import utils.exceptions.EmptyQueueException;
import utils.exceptions.EmptyStackException;

public class MyQueue implements MyQueueStrategy {
    protected final Stack<Integer> stack1, stack2;

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
    @Override
    public void add(Integer data) {
        this.stack1.push(data);
    }

    /**
     * Complexity: O(n)
     *
     * Returns and removes the first element in the queue.
     * @return The first element in the queue.
     */
    @Override
    public Integer remove() throws EmptyQueueException {
        try {
            if (isEmpty()) {
                throw new EmptyQueueException();
            }
            if (stack2.isEmpty()) {
                fillStack2();
            }
            return stack2.pop();
        } catch (EmptyStackException ex) {
            throw new EmptyQueueException();
        }
    }

    /**
     * Complexity: O(n)
     *
     * @return The first element in the queue.
     */
    @Override
    public Integer peek() throws EmptyQueueException {
        try {
            if (stack2.isEmpty()) {
                fillStack2();
            }
            return stack2.peek();
        } catch (EmptyStackException ex) {
            throw new EmptyQueueException();
        }
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    protected void fillStack2() {
        try {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        } catch (EmptyStackException ex) {
            ex.printStackTrace();
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
