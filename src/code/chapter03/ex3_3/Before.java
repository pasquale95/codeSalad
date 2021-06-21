package chapter03.ex3_3;

import utils.EmptyStackException;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    static class StackElement {
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

    static class Stack {
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

    public static class SetOfStacks {
        private Stack top;
        private final int threshold;
        private int stacks;

        public SetOfStacks(int threshold) {
            this.threshold = threshold;
        }

        /**
         * Push element in the current stack, if not full yet.
         * Otherwise create a new stack and link previous one to current.
         * @param   data The data to push in the stack.
         */
        public void push(int data) {
            if (isEmpty()) {
                this.top = new Stack(threshold);
                this.stacks++;
            }
            if (this.top.isFull()) {
                Stack newStack = new Stack(threshold);
                newStack.setPrevious(this.top);
                this.top = newStack;
                this.stacks++;
            }
            this.top.push(new StackElement(data));
        }

        /**
         * Pop in the classic way (i.e. pop from the last created stack).
         * @return  The top of the last created stack.
         * @throws  EmptyStackException If the setOfStacks does not contain any stack.
         */
        public int pop() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException("Error: SetOfStacks is empty.");
            }
            int toPop = this.top.pop().getData();
            // remove stack if empty after pop and set new top
            if (this.top.isEmpty()) {
                this.top = this.top.getPrevious();
                this.stacks--;
            }
            return toPop;
        }

        /**
         * Pop element from the stack at the given index (stack 0 is the first one created,
         * i.e. at the end of the chain).
         * @param   index The index of the stack to pop from.
         * @return  The top of the chosen stack.
         * @throws  EmptyStackException If the chosen stack does not exist.
         */
        public int popAt(int index) throws EmptyStackException {
            // stacks are numbered as FIFO -> first stack being created is stack 0
            int stacksToPop = this.stacks - index - 1;
            if (stacksToPop < 0) {
                throw new EmptyStackException("Error: stack " + index + " does not exist");
            }
            Stack current = this.top;
            Stack aboveCurrent = null;
            // find stack to pop from and its previous one
            while (stacksToPop > 0) {
                aboveCurrent = current;
                current = aboveCurrent.getPrevious();
                stacksToPop--;
            }
            // pop data
            int toPop = current.pop().getData();
            // evict current stack if empty and link its previous to its aboveCurrent
            if (current.isEmpty() && aboveCurrent != null) {
                aboveCurrent.setPrevious(current.getPrevious());
                this.stacks--;
            }
            return toPop;
        }

        public boolean isEmpty() {
            return stacks == 0;
        }

        public String toString() {
            Stack runner = this.top;
            StringBuilder sb = new StringBuilder("* ");
            while (runner != null) {
                sb.append(runner.toString()).append(" ** ");
                runner = runner.getPrevious();
            }
            return sb.toString();
        }
    }

    @Override
    public void run() {
        // TODO
    }
}