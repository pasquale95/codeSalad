package chapter03.ex3_1.post;

import utils.exceptions.EmptyStackException;
import utils.exceptions.StackOverflowException;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution implements Runnable {

    static class StackInfo {
        final int stackNumber;
        int start;
        int size;
        int capacity;

        public StackInfo(int stackNumber, int start, int capacity) {
            this.stackNumber = stackNumber;
            this.start = start;
            this.capacity = capacity;
        }

        /**
         * @return Index of last inserted element.
         */
        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        /**
         * Push data into current stack.
         * @param   data The data to push
         * @throws StackOverflowException If current stack is full and no expansion has been performed.
         */
        public void push(int data) throws StackOverflowException {
            if (!isFull()) {
                stack[adjustIndex(start + size++)] = data;
            } else {
                throw new StackOverflowException("Error: Stack " + stackNumber + " is full.");
            }
        }

        /**
         * Pop data from current stack.
         * @return  The last inserted element.
         * @throws EmptyStackException If no element is in the current stack.
         */
        public int pop() throws EmptyStackException {
            if (!isEmpty()) {
                return stack[adjustIndex(start + --size)];
            } else {
                throw new EmptyStackException("Error: Stack " + stackNumber + " is empty.");
            }
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

    public static final int STACKS = 3;
    private final Integer[] numbers, stackSequence;
    private static int[] stack;
    private static int stackSize = 0;
    private static StackInfo[] stackInfo;

    public Solution(Integer[] numbers, Integer[] stackSequence) {
        this.numbers = numbers;
        this.stackSequence = stackSequence;
        allocateStack(numbers.length);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numbers.length && i < stackSequence.length; i++) {
                pushToStack(numbers[i], stackSequence[i]);
            }
            for (int i : stackSequence) {
                popFromStack(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Complexity: O(n) when stack is full, O(1) otherwise
     *
     * @param   data The data to push in the stack.
     * @param   stackNumber The stack number.
     * @throws  StackOverflowException Thrown if stack is already full.
     */
    public static void pushToStack(int data, int stackNumber) throws StackOverflowException {
        if (areAllFull()) {
            throw new StackOverflowException("Error: Reached stack maximum capacity.");
        }
        StackInfo currentStack = stackInfo[stackNumber];
        if (currentStack.isFull()) {
            // my stack is full, but at least another one is not -> expand current one
            expandStack(stackNumber);
            currentStack.capacity++;
        }
        currentStack.push(data);
        stackSize++;
    }

    /**
     * Complexity: O(1)
     *
     * @param   stackNumber The stack number.
     * @return  The data at the top of the chosen stack.
     * @throws  EmptyStackException Thrown if stack is already empty.
     */
    public static int popFromStack(int stackNumber) throws EmptyStackException {
        if (areAllEmpty()) {
            throw new EmptyStackException("Error: Stacks are empty.");
        }
        StackInfo currentStack = stackInfo[stackNumber];
        if (currentStack.isEmpty()) {
            throw new EmptyStackException("Error: Stack " + stackNumber + " is empty.");
        }
        stackSize--;
        return currentStack.pop();
    }

    /**
     * Expand a stack adding 1 slot.
     * @param   stackNumber The stack number to expand.
     */
    private static void expandStack(int stackNumber) {
        shrinkAndShiftStack((stackNumber + 1) % STACKS);
    }

    /**
     * Shift claimed stack and shrink it if possible, otherwise go ahead until a stack can be shrunk.
     * @param   stackNumber The stack number to shift and shrink.
     */
    private static void shrinkAndShiftStack(int stackNumber) {
        StackInfo currentStack = stackInfo[stackNumber];
        if (currentStack.isFull()) {
            // cannot shrink this stack, we must proceed with next
            shrinkAndShiftStack((stackNumber + 1) % STACKS);
            currentStack.capacity++;
        }
        // shift stack elements one pos right
        int destination = nextIndex(currentStack.lastElementIndex());
        int size = currentStack.size;
        while (size > 0) {
            stack[destination] = stack[previousIndex(destination)];
            destination = previousIndex(destination);
            size--;
        }
        // shift stack beginning and decrease capacity by 1
        currentStack.start = nextIndex(currentStack.start);
        currentStack.capacity--;
    }

    /**
     * Return next index in circular stack
     * @param   index The current index
     * @return  The next index
     */
    private static int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    /**
     * Return previous index in circular stack
     * @param   index The current index
     * @return  The previous index
     */
    private static int previousIndex(int index) {
        return adjustIndex(index - 1);
    }

    /**
     * Adjust index for circular stack.
     * @param   index The index to adjust.
     * @return  The index correctly adjusted.
     */
    private static int adjustIndex(int index) {
        int capacity = stack.length;
        // use this formula to prevent issues with negative integers (e.g. -1 % 5 = -1)
        return ((index % capacity) + capacity) % capacity;
    }

    /**
     * Allocate stack array and stackIndicator.
     * @param   capacity The stack capacity.
     */
    public static void allocateStack(int capacity) {
        stack = new int[capacity];
        stackInfo = new StackInfo[STACKS];
        stackSize = 0;
        int defaultCapacity = capacity / STACKS + (capacity % STACKS) / (STACKS - 1);
        int i;
        for (i = 0; i < STACKS-1; i++) {
            stackInfo[i] = new StackInfo(i, i*defaultCapacity, defaultCapacity);
        }
        stackInfo[i] = new StackInfo(i, i*defaultCapacity, capacity - defaultCapacity * (STACKS - 1));
    }

    /**
     * @return  True if all stacks are full.
     */
    private static boolean areAllFull() {
        return stack.length == stackSize;
    }

    /**
     * @return  True if all stacks are empty.
     */
    private static boolean areAllEmpty() {
        return stackSize == 0;
    }

    /**
     * @param   stackNumber The stack number.
     * @return  The stack in string format.
     */
    public static String stackToString(int stackNumber) {
        StringBuilder sb = new StringBuilder().append("|");
        StackInfo currentStack = stackInfo[stackNumber];
        for (int i = currentStack.size - 1; i >= 0; i--) {
            sb.append(stack[adjustIndex(currentStack.start + i)]).append("|");
        }
        return sb.toString();
    }
}