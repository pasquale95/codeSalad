package chapter03.ex3_1;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    private static final int STACKS = 3;
    private final int[] numbers;
    private static int[] stack;
    private static int[] stackIndicator;
    private static int stackSize;

    public Before(int[] numbers, int length) {
        this.numbers = numbers;
        allocateStack(length);
    }

    @Override
    public void run() {
        // TODO
    }

    /**
     * Complexity: O(1)
     *
     * @param   data The data to push in the stack.
     * @param   stackNumber The stack number.
     * @throws  StackOverflowException Thrown if stack is already full.
     */
    private static void pushToStack(int data, int stackNumber) throws StackOverflowException {
        checkStackDimensions();
        stack[stackSize] = data;
        stackIndicator[stackSize++] = stackNumber;
    }

    /**
     * Complexity: O(n)
     *
     * @param   stackNumber The stack number.
     * @return  The data at the top of the chosen stack.
     * @throws  EmptyStackException Thrown if stack is already empty.
     */
    private static int popFromStack(int stackNumber) throws EmptyStackException {
        for (int i = 0; i < stackIndicator.length; i++) {
            if (stackIndicator[i] == stackNumber) {
                int val = stack[i];
                shiftArrayToLeft(i);
                return val;
            }
        }
        throw new EmptyStackException("Error: Stack " + stackNumber + " is empty.");
    }

    /**
     * Shift array to left by 1 starting from pos.
     * @param   pos The position from where to start the shift (the element at pos is lost).
     */
    private static void shiftArrayToLeft(int pos) {
        for (; pos < stackSize - 1; pos++) {
            stack[pos] = stack[pos+1];
            stackIndicator[pos] = stackIndicator[pos+1];
        }
        stackSize--;
    }

    /**
     * @param   stackNumber The stack number.
     * @return  The stack in string format.
     */
    private static String stackToString(int stackNumber) {
        StringBuilder sb = new StringBuilder().append("| ");
        for (int i = 0; i < stackSize; i++) {
            if (stackIndicator[i] == stackNumber) {
                sb.append(stack[i]).append(" | ");
            }
        }
        return sb.toString();
    }

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
        stackIndicator = new int[size];
    }

    public static void pushFirstStack(int data) throws StackOverflowException {
        pushToStack(data, 1);
    }

    public static void pushSecondStack(int data) throws StackOverflowException {
        pushToStack(data, 2);
    }

    public static void pushThirdStack(int data) throws StackOverflowException {
        pushToStack(data, 3);
    }

    public static int popFirstStack() throws EmptyStackException {
        return popFromStack(1);
    }

    public static int popSecondStack() throws EmptyStackException {
        return popFromStack(2);
    }

    public static int popThirdStack() throws EmptyStackException {
        return popFromStack(3);
    }

    public static String firstStackToString() {
        return "Stack 1: " + stackToString(1);
    }

    public static String secondStackToString() {
        return "Stack 2: " + stackToString(2);
    }

    public static String thirdStackToString() {
        return "Stack 3: " + stackToString(3);
    }
}