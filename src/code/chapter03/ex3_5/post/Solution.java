package chapter03.ex3_5.post;

import chapter03.ex3_5.SolutionTemplate;
import utils.Stack;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {
    private final Integer[] numbers;

    public Solution(Integer[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        Stack<Integer> stack = new Stack<>();
        for (int number : numbers) {
            stack.push(number);
        }
        sortStack(stack);
    }

    /**
     * Complexity: O(n^2)
     *
     * @param   stack The stack to sort.
     */
    public static void sortStack(Stack<Integer> stack) {
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
    }

    @Override
    public void solveSortStack(Stack<Integer> stack) {
        sortStack(stack);
    }
}