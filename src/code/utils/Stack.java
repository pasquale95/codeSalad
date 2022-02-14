package utils;

import utils.exceptions.EmptyStackException;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Stack<T> {
    protected StackNode<T> top;
    protected int size;

    public void push(T data) {
        StackNode<T> element = new StackNode<>(data);
        element.setPrevious(this.top);
        this.top = element;
        this.size++;
    }

    public T pop() throws EmptyStackException {
        T toPop = this.peek();
        this.top = this.top.getPrevious();
        this.size--;
        return toPop;
    }

    public T peek() throws EmptyStackException {
        if (this.top == null) {
            throw new EmptyStackException();
        }
        return this.top.getData();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String toString() {
        StackNode<T> runner = this.top;
        StringBuilder sb = new StringBuilder("|");
        while (runner != null) {
            sb.append(runner.getData()).append("|");
            runner = runner.getPrevious();
        }
        return sb.toString();
    }

    public String toStringReversed() {
        StackNode<T> runner = this.top;
        StringBuilder sb = new StringBuilder("|");
        while (runner != null) {
            sb.insert(0, runner.getData()).insert(0, "|");
            runner = runner.getPrevious();
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Stack<?>)) {
            return false;
        }
        Stack<?> other = (Stack<?>) o;
        if (other.size != this.size) {
            return false;
        }
        StackNode<T> runner = this.top;
        StackNode<?> otherRunner = other.top;
        while (runner != null && otherRunner != null) {
            if (!runner.equals(otherRunner)) {
                return false;
            }
            runner = runner.getPrevious();
            otherRunner = otherRunner.getPrevious();
        }
        return true;
    }
}
