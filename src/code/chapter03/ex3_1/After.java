package chapter03.ex3_1;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    static class StackInfo {
        int start, size, capacity;

        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        public int lastElementIndex() {
            return start + size - 1;
        }

        public int push() {
            return start + ++size - 1;
        }

        public int pop() {
            return start + size-- - 1;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    private static final int STACKS = 3;
    private static int[] stack;
    private static int stackSize = 0;
    private static StackInfo[] stackInfo;

    public After(int size) {
        allocateStack(size);
    }

    @Override
    public void run() {
        // TODO
    }

    /**
     * Complexity: TODO
     *
     * @param   data The data to push in the stack.
     * @param   stackNumber The stack number.
     * @throws  StackOverflowException Thrown if stack is already full.
     */
    public static void pushToStack(int data, int stackNumber) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException("Error: Reached stack maximum capacity.");
        }
        StackInfo currentStack = stackInfo[stackNumber];
        if (currentStack.isFull()) {
            throw new StackOverflowException("Stack " + stackNumber + " is full.");
        }
        stack[currentStack.push()] = data;
        stackSize++;
    }

    /**
     * Complexity: TODO
     *
     * @param   stackNumber The stack number.
     * @return  The data at the top of the chosen stack.
     * @throws  EmptyStackException Thrown if stack is already empty.
     */
    public static int popFromStack(int stackNumber) throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Error: Stacks are empty.");
        }
        StackInfo currentStack = stackInfo[stackNumber];
        if (currentStack.isEmpty()) {
            throw new EmptyStackException("Error: Stack " + stackNumber + " is empty.");
        }
        stackSize--;
        return stack[currentStack.pop()];
    }

    /**
     * Shift array to left by 1 starting from pos.
     * @param   pos The position from where to start the shift (the element at pos is lost).
     */
    /*private static void shiftArrayToLeft(int pos) {
        for (; pos < stackSize - 1; pos++) {
            stack[pos] = stack[pos+1];
            stackIndicator[pos] = stackIndicator[pos+1];
        }
        stackSize--;
    }*/

    /**
     * Check stack dimensions.
     * @throws  StackOverflowException Thrown if stack is already full.
     */
    private static void checkStackDimensions() throws StackOverflowException {
        if (stackSize >= stack.length) {
            throw new StackOverflowException("Error: Reached stack maximum capacity.");
        }
    }

    /**
     * Allocate stack array and stackIndicator.
     * @param   size The stack size.
     */
    public static void allocateStack(int size) {
        stack = new int[size];
        int defaultSize = size / STACKS + (size % STACKS) / (STACKS - 1);
        int i = 0;
        for (i = 0; i < STACKS-1; i++) {
            stackInfo[i] = new StackInfo(i*defaultSize, defaultSize);
        }
        stackInfo[i] = new StackInfo(i*defaultSize, size - defaultSize * (STACKS - 1));
    }

    private static boolean isFull() {
        return stack.length == stackSize;
    }

    private static boolean isEmpty() {
        return stackSize == 0;
    }

    /**
     * @param   stackNumber The stack number.
     * @return  The stack in string format.
     */
    public static String stackToString(int stackNumber) {
        /*StringBuilder sb = new StringBuilder().append("| ");
        for (int i = 0; i < stackSize; i++) {
            if (stackIndicator[i] == stackNumber) {
                sb.append(stack[i]).append(" | ");
            }
        }
        return sb.toString();*/
        return "";
    }
}