package chapter03.ex3_1.pre;

import chapter03.ex3_1.SolutionTemplate;
import utils.exceptions.EmptyStackException;
import utils.exceptions.StackOverflowException;

import java.util.Objects;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    protected Integer[] stackIndicator;
    protected Integer stackSize;


    /**
     * @see SolutionTemplate#SolutionTemplate(Integer[], Integer[])
     */
    public Solution(Integer[] numbers, Integer[] stackSequence) {
        super(numbers, stackSequence);
    }

    /**
     * Complexity: O(1)
     *
     * @param   data The data to push in the stack.
     * @param   stackNumber The stack number.
     * @throws StackOverflowException Thrown if stack is already full.
     */
    @Override
    public void pushToStack(Integer data, Integer stackNumber) throws StackOverflowException {
        checkStackDimensions();
        stack[stackSize] = data;
        stackIndicator[stackSize++] = stackNumber;
    }

    /**
     * Complexity: O(n)
     * WARNING: pop from stack should be O(1)!
     *
     * @param   stackNumber The stack number.
     * @return  The data at the top of the chosen stack.
     * @throws EmptyStackException Thrown if stack is already empty.
     */
    @Override
    public Integer popFromStack(Integer stackNumber) throws EmptyStackException {
        for (int i = stackSize - 1; i >= 0; i--) {
            if (Objects.equals(stackIndicator[i], stackNumber)) {
                int val = stack[i];
                shiftArrayToLeft(i);
                return val;
            }
        }
        throw new EmptyStackException("Error: Stack " + stackNumber + " is empty.");
    }

    /**
     * Shift array to left by 1 starting from pos.
     * @param   pos The position from where to start the shift (the element at pos is lost).
     */
    protected void shiftArrayToLeft(int pos) {
        for (; pos < stackSize - 1; pos++) {
            stack[pos] = stack[pos+1];
            stackIndicator[pos] = stackIndicator[pos+1];
        }
        stackSize--;
    }

    /**
     * Check stack dimensions.
     * @throws  StackOverflowException Thrown if stack is already full.
     */
    protected void checkStackDimensions() throws StackOverflowException {
        if (stackSize >= stack.length) {
            throw new StackOverflowException();
        }
    }

    /**
     * Allocate stack array and stackIndicator.
     * @param   size The stack size.
     */
    @Override
    public void allocateStack(Integer size) {
        stack = new Integer[size];
        stackIndicator = new Integer[size];
        stackSize = 0;
    }

    /**
     * @param   stackNumber The stack number.
     * @return  The stack in string format.
     */
    @Override
    public String stackToString(Integer stackNumber) {
        StringBuilder sb = new StringBuilder().append("|");
        for (int i = stackSize - 1; i >= 0; i--) {
            if (Objects.equals(stackIndicator[i], stackNumber)) {
                sb.append(stack[i]).append("|");
            }
        }
        return sb.toString();
    }
}