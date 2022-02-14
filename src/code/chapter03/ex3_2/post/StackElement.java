package chapter03.ex3_2.post;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class StackElement {
    protected final int data;
    protected StackElement previous;

    public StackElement(int data) {
        this.data = data;
    }

    public void setPrevious(StackElement previous) {
        this.previous = previous;
    }

    public StackElement getPrevious() {
        return this.previous;
    }

    public int getData() {
        return data;
    }
}
