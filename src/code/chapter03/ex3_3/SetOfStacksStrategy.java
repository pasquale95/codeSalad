package chapter03.ex3_3;

import utils.exceptions.EmptyStackException;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public interface SetOfStacksStrategy {
    void push(int data);
    int pop() throws EmptyStackException;
    int popAt(int stack) throws EmptyStackException;
    int getStacks();
}
