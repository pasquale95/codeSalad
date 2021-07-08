package utils;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Stack {

    private final int threshold;
    private Stack previous;
    private StackNode top;
    private int size;

    public Stack() {
        this.threshold = Integer.MAX_VALUE;
    }

    public Stack(int threshold) {
        this.threshold = threshold;
    }

    public void push(StackNode element) {
        element.setPrevious(this.top);
        this.top = element;
        this.size++;
    }

    public StackNode pop() {
        StackNode toPop = this.peek();
        this.top = this.top.getPrevious();
        this.size--;
        return toPop;
    }

    public StackNode peek() {
        return this.top;
    }

    public void setPrevious(Stack previous) {
        this.previous = previous;
    }

    public Stack getPrevious() {
        return this.previous;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == threshold;
    }

    public String toString() {
        StackNode runner = this.top;
        StringBuilder sb = new StringBuilder("|");
        while (runner != null) {
            sb.append(runner.getData()).append("|");
            runner = runner.getPrevious();
        }
        return sb.toString();
    }
}
