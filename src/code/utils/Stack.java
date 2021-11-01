package utils;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Stack<T> {

    private final int threshold;
    private Stack<T> previous;
    private StackNode<T> top;
    private int size;

    public Stack() {
        this.threshold = Integer.MAX_VALUE;
    }

    public Stack(int threshold) {
        this.threshold = threshold;
    }

    public void push(T data) {
        StackNode<T> element = new StackNode<>(data);
        element.setPrevious(this.top);
        this.top = element;
        this.size++;
    }

    public T pop() {
        T toPop = this.peek();
        this.top = this.top.getPrevious();
        this.size--;
        return toPop;
    }

    public T peek() {
        return this.top.getData();
    }

    public void setPrevious(Stack<T> previous) {
        this.previous = previous;
    }

    public Stack<T> getPrevious() {
        return this.previous;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == threshold;
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
}
