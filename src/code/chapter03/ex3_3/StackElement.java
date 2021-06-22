package chapter03.ex3_3;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class StackElement {
    private final int data;
    private StackElement previous;

    public StackElement(int data) {
        this.data = data;
    }

    public StackElement getPrevious() {
        return previous;
    }

    public void setPrevious(StackElement previous) {
        this.previous = previous;
    }

    public int getData() {
        return data;
    }
}
