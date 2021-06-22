package chapter03.ex3_3;

import utils.EmptyStackException;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

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
            StringBuilder sb = new StringBuilder("** ");
            while (runner != null) {
                sb.append(runner).append(" ** ");
                runner = runner.getPrevious();
            }
            return sb.toString();
        }
    }

    private final int[] numbers;
    private final int threshold;

    public Before(int[] numbers, int threshold) {
        this.numbers = numbers;
        this.threshold = threshold;
    }

    @Override
    public void run() {
        try {
            SetOfStacks setOfStacks = new SetOfStacks(this.threshold);
            // measure push()
            for (int number : this.numbers) {
                setOfStacks.push(number);
            }
            // measure popAt()
            for (int i = 0; i < setOfStacks.stacks; i++) {
                setOfStacks.popAt(i);
            }
            // measure pop()
            for (int i = 0; i < this.numbers.length / 2; i++) {
                setOfStacks.pop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}