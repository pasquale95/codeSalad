package chapter03.ex3_3.post;

import chapter03.ex3_3.SetOfStacksStrategy;
import utils.exceptions.EmptyStackException;

import java.util.ArrayList;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class SetOfStacks implements SetOfStacksStrategy {
    final ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    protected final int threshold;

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    protected Stack<Integer> getLastStack() throws EmptyStackException {
        if (this.stacks.isEmpty()) {
            throw new EmptyStackException("Error: SetOfStacks is empty.");
        }
        return this.stacks.get(this.stacks.size() - 1);
    }

    /**
     * Complexity: O(1)
     *
     * Push element in the current stack, if not full yet.
     * Otherwise, create a new stack and link previous one to current.
     * @param   data The data to push in the stack.
     */
    public void push(int data)  {
        try {
            if (this.stacks.isEmpty()) {
                stacks.add(new Stack<>(this.threshold));
            }
            Stack<Integer> stack = this.getLastStack();
            if (stack.isFull()) {
                stack = new Stack<>(this.threshold);
                stacks.add(stack);
            }
            stack.push(data);
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
    }

    /**
     * Complexity: O(1)
     *
     * Pop in the classic way (i.e. pop from the last created stack).
     * @return  The top of the last created stack.
     * @throws  EmptyStackException If the setOfStacks does not contain any stack.
     */
    public int pop() throws EmptyStackException {
        Stack<Integer> stack = this.getLastStack();
        int toPop = stack.pop();
        if (stack.isEmpty()) {
            this.stacks.remove(stack);
        }
        return toPop;
    }

    /**
     * Complexity: O(1)
     *
     * Pop element from the stack at the given index (stack 0 is the first one created,
     * i.e. at the end of the chain).
     * The complexity O(1) is due to the use of ArrayList<>, which allows constant-time access,
     * given the element index.
     * @param   index The index of the stack to pop from.
     * @return  The top of the chosen stack.
     * @throws  EmptyStackException If the chosen stack does not exist.
     */
    public int popAt(int index) throws EmptyStackException {
        if (index < 0 || index > this.stacks.size() - 1) {
            throw new EmptyStackException("Error: stack " + index + " does not exist");
        }
        Stack<Integer> stack = this.stacks.get(index);
        int toPop = stack.pop();
        if (stack.isEmpty()) {
            this.stacks.remove(stack);
        }
        return toPop;
    }

    @Override
    public int getStacks() {
        return stacks.size();
    }

    public boolean isEmpty() {
        return stacks.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("** ");
        for (int i = stacks.size() - 1; i >= 0; i--) {
            sb.append(stacks.get(i).toString()).append(" ** ");
        }
        return sb.toString();
    }
}