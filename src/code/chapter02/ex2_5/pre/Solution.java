package chapter02.ex2_5.pre;

import chapter02.ex2_5.SolutionTemplate;
import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    private final LinkedListNode<Integer>[] addends;

    public Solution(LinkedListNode<Integer>[] addends) {
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
     * @param   addend2 The second addend
     * @return  The sum of the two addends in reverse order.
     */
    public static LinkedListNode<Integer> reverseOrderSum(LinkedListNode<Integer> addend1, LinkedListNode<Integer> addend2) {
        LinkedListNode<Integer> result = null, runner = null;
        int tmp, carry = 0;
        // sum digit by digit
        while (addend1 != null || addend2 != null) {
            if (addend1 != null && addend2 != null) {
                tmp = addend1.getData() + addend2.getData() + carry;
                addend1 = addend1.getNext();
                addend2 = addend2.getNext();
            } else if (addend1 != null) {
                tmp = addend1.getData() + carry;
                addend1 = addend1.getNext();
            } else {
                tmp = addend2.getData() + carry;
                addend2 = addend2.getNext();
            }
            carry = tmp / 10;
            if (runner == null) {
                runner = new LinkedListNode<>(tmp % 10);
                result = runner;
            } else {
                runner = runner.append(tmp % 10);
            }
        }
        // if carry on the last sum, add extra digit to result.
        if (carry > 0) {
            runner.append(carry);
        }
        return result;
    }

    /**
     * Complexity: O(n)
     *
     * @param   addend1 The first addend.
     * @param   addend2 The second addend
     * @return  The sum of the two addends in forward order.
     */
    public static LinkedListNode<Integer> forwardOrderSum(LinkedListNode<Integer> addend1, LinkedListNode<Integer> addend2) {
        // cloning here since we're not supposed to change the original addend
        return invertLinkedList(reverseOrderSum(invertLinkedList(addend1.clone()), invertLinkedList(addend2.clone())));
    }

    /**
     * Invert a linked list (e.g. 1->3->5 becomes 5->3->1).
     * @param   head The linked list starting node.
     * @return  The inverted linked list.
     */
    private static LinkedListNode<Integer> invertLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> runner = head;
        while (!runner.isTail()) {
            LinkedListNode<Integer> next = runner.getNext();
            runner.append(next.getNext());
            next.append(head);
            head = next;
        }
        return head;
    }

    @Override
    public LinkedListNode<Integer> solve(LinkedListNode<Integer> addend1, LinkedListNode<Integer> addend2) {
        return reverseOrderSum(addend1, addend2);
    }

    @Override
    public LinkedListNode<Integer> solveFollowUp(LinkedListNode<Integer> addend1, LinkedListNode<Integer> addend2) {
        return forwardOrderSum(addend1, addend2);
    }
}