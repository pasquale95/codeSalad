package chapter03.ex3_2.pre;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class StackElement {
    protected final int data, min;
    protected StackElement previous;

    public StackElement(int data, int min) {
        this.data = data;
        this.min = min;
    }

    public void setPrevious(StackElement previous) {
        this.previous = previous;
    }

    public StackElement getPrevious() {
        return this.previous;
    }

    public int getMin() {
        return min;
    }

    public int getData() {
        return data;
    }
}
