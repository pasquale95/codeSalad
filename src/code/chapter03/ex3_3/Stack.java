package chapter03.ex3_3;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Stack {

    private final int threshold;
    private Stack previous;
    private StackElement top;
    private int size;

    public Stack(int threshold) {
        this.threshold = threshold;
    }

    public void push(StackElement element) {
        element.setPrevious(this.top);
        this.top = element;
        this.size++;
    }

    public StackElement pop() {
        StackElement toPop = this.top;
        this.top = this.top.getPrevious();
        this.size--;
        return toPop;
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
        StackElement runner = this.top;
        StringBuilder sb = new StringBuilder("|");
        while (runner != null) {
            sb.append(runner.getData()).append("|");
            runner = runner.getPrevious();
        }
        return sb.toString();
    }
}
