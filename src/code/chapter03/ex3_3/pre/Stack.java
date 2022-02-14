package chapter03.ex3_3.pre;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Stack<T> extends utils.Stack<T> {
    protected final int threshold;
    protected Stack<T> previous;

    public Stack(int threshold) {
        this.threshold = threshold;
    }

    public void setPrevious(Stack<T> previous) {
        this.previous = previous;
    }

    public Stack<T> getPrevious() {
        return this.previous;
    }

    public boolean isFull() {
        return this.size == threshold;
    }
}
