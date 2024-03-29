package chapter02.ex2_6;

import utils.LinkedListNode;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Before implements Runnable {

    private final LinkedListNode head;

    public Before(LinkedListNode head) {
        this.head = head;
    }

    @Override
    public void run() {
        isPalindrome(head);
    }

    /**
     * Complexity: O(n)
     *
     * @param   head The head of the linked list to check.
     * @return  True if the linked list is palindrome.
     */
    public static boolean isPalindrome(LinkedListNode head) {
        int size = head != null ? head.getListLength() : 0;
        if (size > 1) {
            // empty list or with 1 single element are palindrome by definition
            return checkPalindromeRecursively(head, size, 0) != null;
        }
        return true;
    }

    /**
     * Recursive method which returns the tail of the linked list
     * if palindrome, null otherwise.
     *
     * @param   node The current node to evaluate.
     * @param   size The linked list size.
     * @param   level The actual recursion level.
     * @return  The tail node if palindrome, null otherwise.
     */
    private static LinkedListNode checkPalindromeRecursively(LinkedListNode node, int size, int level) {
        LinkedListNode mirrored;
        if (size <= 1) {
            mirrored = node;
        } else if (level >= size/2 - 1) {
            // stop recursion when we are in the middle of the list.
            mirrored = node.getNext();
            if (size % 2 != 0) {
                // if size is odd, the central node must be skipped
                mirrored = mirrored.getNext();
            }
        } else {
            // not yet in the middle, go deeper in the list
            mirrored = checkPalindromeRecursively(node.getNext(), size, level+1);
            if (mirrored != null) {
                mirrored = mirrored.getNext();
            }
        }

        if (mirrored != null && node.getData() == mirrored.getData()) {
            return mirrored;
        } else {
            return null;
        }
    }
}