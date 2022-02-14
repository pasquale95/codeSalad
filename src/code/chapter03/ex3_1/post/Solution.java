package chapter03.ex3_1.post;

import chapter03.ex3_1.SolutionTemplate;
import utils.exceptions.EmptyStackException;
import utils.exceptions.StackOverflowException;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    protected StackInfo[] stackInfo;
    protected Integer stackSize;

    public Solution(Integer stackSize) {
        super(stackSize);
    }

    public Solution(Integer[] numbers, Integer[] stackSequence) {
        super(numbers, stackSequence);
    }

    /**
     * Complexity: O(n) when stack is full, O(1) otherwise
     *
     * @param   data The data to push in the stack.
     * @param   stackNumber The stack number.
     * @throws  StackOverflowException Thrown if stack is already full.
     */
    @Override
    public void pushToStack(Integer data, Integer stackNumber) throws StackOverflowException {
        if (areAllFull()) {
            throw new StackOverflowException();
        }
        StackInfo currentStack = stackInfo[stackNumber];
        if (currentStack.isFull()) {
            // my stack is full, but at least another one is not -> expand current one
            expandStack(stackNumber);
            currentStack.capacity++;
        }
        stackSize++;
        currentStack.size++;
        stack[lastStackElementIndex(currentStack)] = data;
    }

    /**
     * Complexity: O(1)
     *
     * @param   stackNumber The stack number.
     * @return  The data at the top of the chosen stack.
     * @throws  EmptyStackException Thrown if stack is already empty.
     */
    @Override
    public Integer popFromStack(Integer stackNumber) throws EmptyStackException {
        if (areAllEmpty()) {
            throw new EmptyStackException("Error: Stacks are empty.");
        }
        StackInfo currentStack = stackInfo[stackNumber];
        if (currentStack.isEmpty()) {
            throw new EmptyStackException("Error: Stack " + stackNumber + " is empty.");
        }
        int popped = stack[lastStackElementIndex(currentStack)];
        currentStack.size--;
        stackSize--;
        return popped;
    }

    /**
     * Expand a stack adding 1 slot.
     * @param   stackNumber The stack number to expand.
     */
    protected void expandStack(int stackNumber) {
        shrinkAndShiftStack((stackNumber + 1) % STACKS);
    }

    /**
     * Shift claimed stack and shrink it if possible, otherwise go ahead until a stack can be shrunk.
     * @param   stackNumber The stack number to shift and shrink.
     */
    protected void shrinkAndShiftStack(int stackNumber) {
        StackInfo currentStack = stackInfo[stackNumber];
        if (currentStack.isFull()) {
            // cannot shrink this stack, we must proceed with next
            shrinkAndShiftStack((stackNumber + 1) % STACKS);
            currentStack.capacity++;
        }
        // shift stack elements one pos right
        int destination = nextIndex(lastStackElementIndex(currentStack));
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
     * Allocate stack array and stackIndicator.
     * @param   capacity The stack capacity.
     */
    @Override
    public void allocateStack(Integer capacity) {
        stack = new Integer[capacity];
        stackInfo = new StackInfo[STACKS];
        stackSize = 0;
        int defaultCapacity = capacity / STACKS + (capacity % STACKS) / (STACKS - 1);
        int i;
        for (i = 0; i < STACKS-1; i++) {
            stackInfo[i] = new StackInfo(stack, i, i*defaultCapacity, defaultCapacity);
        }
        stackInfo[i] = new StackInfo(stack, i, i*defaultCapacity, capacity - defaultCapacity * (STACKS - 1));
    }

    /**
     * @return  True if all stacks are full.
     */
    protected boolean areAllFull() {
        return stack.length == stackSize;
    }

    /**
     * @return  True if all stacks are empty.
     */
    protected boolean areAllEmpty() {
        return stackSize == 0;
    }

    /**
     * @param   stackNumber The stack number.
     * @return  The stack in string format.
     */
    @Override
    public String stackToString(Integer stackNumber) {
        StringBuilder sb = new StringBuilder().append("|");
        StackInfo currentStack = stackInfo[stackNumber];
        for (int i = currentStack.size - 1; i >= 0; i--) {
            sb.append(stack[adjustIndex(currentStack.start + i)]).append("|");
        }
        return sb.toString();
    }

    /**
     * @param   stack The stack
     * @return  Index of last inserted element; -1 if empty
     */
    protected int lastStackElementIndex(StackInfo stack) {
        return adjustIndex(stack.start + stack.size - 1);
    }

    /**
     * Adjust index for circular stack.
     * @param   index The index to adjust.
     * @return  The index correctly adjusted.
     */
    protected int adjustIndex(int index) {
        int capacity = stack.length;
        // use this formula to prevent issues with negative integers (e.g. -1 % 5 = -1)
        return ((index % capacity) + capacity) % capacity;
    }

    /**
     * Return next index in circular stack
     * @param   index The current index
     * @return  The next index
     */
    protected int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    /**
     * Return previous index in circular stack
     * @param   index The current index
     * @return  The previous index
     */
    protected int previousIndex(int index) {
        return adjustIndex(index - 1);
    }
}