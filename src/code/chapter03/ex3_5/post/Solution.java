package chapter03.ex3_5.post;

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

    public Solution(Integer[] numbers) {
        super(numbers);
    }

    /**
     * Complexity: O(n^2)
     *
     * @param   stack The stack to sort.
     */
    public static void staticSortStack(Stack<Integer> stack) {
        try {
            Stack<Integer> temporaryStack = new Stack<>();
            int tmp;
            while (!stack.isEmpty()) {
                tmp = stack.pop();
                while (!temporaryStack.isEmpty() && tmp < temporaryStack.peek()) {
                    stack.push(temporaryStack.pop());
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

    @Override
    public void sortStack(Stack<Integer> stack) {
        staticSortStack(stack);
    }
}