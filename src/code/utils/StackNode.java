package utils;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class StackNode<T> {
    private final T data;
    private StackNode<T> previous;

    public StackNode(T data) {
        this.data = data;
    }

    public StackNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(StackNode<T> previous) {
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StackNode<?>)) {
            return false;
        }
        StackNode<?> other = (StackNode<?>) o;
        return other.data.equals(data);
    }
}
