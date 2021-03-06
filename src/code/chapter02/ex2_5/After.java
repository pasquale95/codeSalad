package chapter02.ex2_5;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    private final LinkedListNode[] addends;

    public After(LinkedListNode[] addends) {
        this.addends = addends;
    }

    @Override
    public void run() {
        for (int i = 0; i < addends.length - 1; i++) {
            for (int j = i + 1; j < addends.length; j++) {
                reverseOrderSum(this.addends[i], this.addends[j]);
                forwardOrderSum(this.addends[i], this.addends[j]);
            }
        }
    }

    /**
     * Complexity: O(n)
     *
     * @param   addend1 The first addend.
     * @param   addend2 The second addend.
     * @return  The sum of the two addends in reverse order.
     */
    public static LinkedListNode reverseOrderSum(LinkedListNode addend1, LinkedListNode addend2) {
        return recursiveReverseSum(addend1, addend2, 0);
    }

    /**
     * Complexity: O(n)
     *
     * @param   addend1 The first addend.
     * @param   addend2 The second addend.
     * @return  The sum of the two addends in forward order.
     */
    public static LinkedListNode forwardOrderSum(LinkedListNode addend1, LinkedListNode addend2) {
        int diffLength = compareLength(addend1, addend2);
        if (diffLength < 0) {
            addend1 = paddingWithZeroes(addend1, Math.abs(diffLength));
        } else if (diffLength > 0) {
            addend2 = paddingWithZeroes(addend2, Math.abs(diffLength));
        }
        LinkedListNode sum = recursiveForwardSum(addend1, addend2);
        if (sum.getData() > 10) {
            LinkedListNode head = new LinkedListNode(sum.getData() / 10);
            head.append(sum);
            sum.setData(sum.getData() % 10);
            sum = head;
        }
        return sum;
    }

    /**
     * Add the required zeroes at the beginning of the given linked list.
     * @param   head The head of the linked list to pad.
     * @param   zeroes The number of zeroes to add.
     * @return  The padded linked list.
     */
    private static LinkedListNode paddingWithZeroes(LinkedListNode head, int zeroes) {
        while (zeroes > 0) {
            LinkedListNode node = new LinkedListNode(0);
            node.append(head);
            head = node;
            zeroes--;
        }
        return head;
    }

    /**
     * Compare the length of two linked lists.
     *
     * @param   a The first linked list.
     * @param   b The second linked list.
     * @return  0 if equal, >0 if a is longer than b, <0 otherwise.
     */
    private static int compareLength(LinkedListNode a, LinkedListNode b) {
        int diffSize = 0;
        while (a != null || b != null) {
            if (a != null) {
                a = a.getNext();
                diffSize += 1;
            }
            if (b != null) {
                b = b.getNext();
                diffSize -= 1;
            }
        }
        return diffSize;
    }

    private static LinkedListNode recursiveForwardSum(LinkedListNode addend1, LinkedListNode addend2) {
        if (addend1.isTail() && addend2.isTail()) {
            return new LinkedListNode(addend1.getData()+addend2.getData());
        }
        LinkedListNode next = recursiveForwardSum(addend1.getNext(), addend2.getNext());
        LinkedListNode current = new LinkedListNode(addend1.getData() + addend2.getData() + next.getData() / 10);
        next.setData(next.getData() % 10);
        current.append(next);
        return current;
    }

    private static LinkedListNode recursiveReverseSum(LinkedListNode addend1, LinkedListNode addend2, int carry) {
        if (addend1 == null && addend2 == null && carry == 0) {
            return null;
        }
        if (addend1 != null) {
            carry += addend1.getData();
        }
        if (addend2 != null) {
            carry += addend2.getData();
        }
        LinkedListNode node = new LinkedListNode(carry % 10);
        if (addend1 != null || addend2 != null) {
            node.append(recursiveReverseSum(
                    addend1 == null ? null : addend1.getNext(),
                    addend2 == null ? null : addend2.getNext(),
                    carry / 10)
            );
        }
        return node;
    }
}