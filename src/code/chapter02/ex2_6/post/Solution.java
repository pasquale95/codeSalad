package chapter02.ex2_6.post;

import chapter02.ex2_6.SolutionTemplate;
import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    private final LinkedListNode<Integer> head;

    public Solution(LinkedListNode<Integer> head) {
        this.head = head;
    }

    @Override
    public void run() {
        isPalindrome(head);
    }

    @Override
    public boolean solve(LinkedListNode<Integer> head) {
        return isPalindrome(head);
    }

    /**
     * Complexity: O(n)
     *
     * @param   head The head of the linked list to check.
     * @return  True if the linked list is palindrome.
     */
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        int size = head != null ? head.getListLength() : 0;
        if (size > 1) {
            // empty list or with 1 single element are palindrome by definition
            return checkPalindromeRecursively(head, size) != null;
        }
        return true;
    }

    /**
     * Recursive method which returns the tail of the linked list
     * if palindrome, null otherwise.
     *
     * @param   node The current node to evaluate.
     * @param   length The linked list size.
     * @return  The tail node if palindrome, null otherwise.
     */
    private static LinkedListNode<Integer> checkPalindromeRecursively(LinkedListNode<Integer> node, int length) {
        if (length <= 0 || (length == 1 && node.isTail())) {
            // if list is long 1 node we must not return null, otherwise it will be considered as not palindrome
            return node;
        } else if (length == 1) {
            return node.getNext();
        }

        LinkedListNode<Integer> mirrored = checkPalindromeRecursively(node.getNext(), length - 2);
        if (mirrored != null && mirrored.getData().equals(node.getData())) {
            if (mirrored.isTail()) {
                return mirrored;
            } else {
                return mirrored.getNext();
            }
        }
        return null;
    }
}