package chapter03.ex3_1.post;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class StackInfo {
    protected Integer stackNumber, start, size, capacity;
    protected Integer[] stack;

    public StackInfo(Integer[] stack, Integer stackNumber, Integer start, Integer capacity) {
        this.stack = stack;
        this.stackNumber = stackNumber;
        this.start = start;
        this.capacity = capacity;
        this.size = 0;
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
