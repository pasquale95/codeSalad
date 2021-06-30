package utils;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class StackNode {
    private final int data;
    private StackNode previous;

    public StackNode(int data) {
        this.data = data;
    }

    public StackNode getPrevious() {
        return previous;
    }

    public void setPrevious(StackNode previous) {
        this.previous = previous;
    }

    public int getData() {
        return data;
    }
}
