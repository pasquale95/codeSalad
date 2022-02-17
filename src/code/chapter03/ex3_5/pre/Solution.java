package chapter03.ex3_5.pre;

import chapter03.ex3_5.SolutionTemplate;
import utils.Stack;
import utils.exceptions.EmptyStackException;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    /**
     * @see SolutionTemplate#SolutionTemplate(Stack)
     */
    public Solution(Stack<Integer> stack) {
        super(stack);
    }

    /**
     * Complexity: O(n^2)
     *
     * @param   stack The stack to sort.
     */
    @Override
    public void sortStack(Stack<Integer> stack) {
        try {
            Stack<Integer> temporaryStack = new Stack<>();
            int tmp;
            while (!stack.isEmpty()) {
                tmp = stack.pop();
                if (!temporaryStack.isEmpty() && tmp < temporaryStack.peek()) {
                    while (!temporaryStack.isEmpty() && tmp < temporaryStack.peek()) {
                        stack.push(temporaryStack.pop());
                    }
                }
                temporaryStack.push(tmp);
            }
            while (!temporaryStack.isEmpty()) {
                stack.push(temporaryStack.pop());
            }
        } catch (EmptyStackException ex) {
            ex.printStackTrace();
        }
    }
}