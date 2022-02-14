package chapter03.ex3_4.pre;

import chapter03.ex3_4.MyQueueStrategy;
import utils.Stack;
import utils.exceptions.EmptyQueueException;
import utils.exceptions.EmptyStackException;

public class MyQueue implements MyQueueStrategy {
    protected final Stack<Integer> stack1, stack2;

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
    @Override
    public void add(Integer data) {
        stack1.push(data);
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
            invertStack(stack1, stack2);
            int toRemove = stack2.pop();
            invertStack(stack2, stack1);
            return toRemove;
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
            invertStack(stack1, stack2);
            int toPeek = stack2.peek();
            invertStack(stack2, stack1);
            return toPeek;
        } catch (EmptyStackException e) {
            throw new EmptyQueueException();
        }
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    protected void invertStack(Stack<Integer> from, Stack<Integer> to) throws EmptyStackException {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }

    public String toString() {
        return stack1.toString();
    }
}
