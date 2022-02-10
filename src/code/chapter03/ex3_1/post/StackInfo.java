package chapter03.ex3_1.post;

import utils.exceptions.EmptyStackException;
import utils.exceptions.StackOverflowException;

public class StackInfo {
    final int stackNumber;
    int[] stack;
    int start;
    int size;
    int capacity;

    public StackInfo(int[] stack, int stackNumber, int start, int capacity) {
        this.stack = stack;
        this.stackNumber = stackNumber;
        this.start = start;
        this.capacity = capacity;
    }

    /**
     * @return  True if the current stack has no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return  True if the current element is full.
     */
    public boolean isFull() {
        return size == capacity;
    }
}
