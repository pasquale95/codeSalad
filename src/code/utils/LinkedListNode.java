package utils;

import java.util.Random;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class LinkedListNode {

    private final int data;
    private LinkedListNode prev;
    private LinkedListNode next;

    /**
     * Homemade double-linked list to use for our exercises on lists.
     * @param data
     */
    public LinkedListNode(int data) {
        this.data = data;
    }

    /**
     * Create and append new node to current one.
     * @param data
     */
    public LinkedListNode append(int data) {
        LinkedListNode node = new LinkedListNode(data);
        this.append(node);
        return node;
    }

    /**
     * Create and prepend new node to current one.
     * @param data
     */
    public LinkedListNode prepend(int data) {
        LinkedListNode node = new LinkedListNode(data);
        this.prepend(node);
        return node;
    }

    /**
     * Append node to current one.
     * @param node
     */
    public void append(LinkedListNode node) {
        if (this != node && node != null) {
            // connect rest of the list to new element
            if (!this.isTail()) {
                node.next = this.next;
                node.next.prev = node;
            }
            this.next = node;
            node.prev = this;
        }
    }

    /**
     * Prepend node to current one.
     * @param node
     */
    public void prepend(LinkedListNode node) {
        if (this != node && node != null) {
            // prevent circular list
            if (!this.isHead()) {
                node.prev = this.prev;
                node.prev.next = node;
            }
            this.prev = node;
            node.next = this;
        }
    }

    /**
     * Delete current node from list
     */
    public void delete() {
        if (!this.isHead()) {
            prev.next = this.next;
        }
        if (!this.isTail()) {
            next.prev = this.prev;
        }
    }

    /**
     * Return a cloned LinkedListNode
     */
    public LinkedListNode clone() {
        LinkedListNode clone = new LinkedListNode(this.data);
        LinkedListNode headCloned = clone;
        for (LinkedListNode node = this; !node.isTail(); node = node.getNext()) {
            clone = clone.append(node.next.getData());
        }
        return headCloned;
    }

    /**
     * Return a random linked list of the specified length
     * and with values in the range [0, dataRange)
     *
     * @param length
     * @param dataRange
     */
    public static LinkedListNode createRandomLinkedList(int length, int dataRange) {
        Random r = new Random();
        LinkedListNode node = new LinkedListNode(r.nextInt(dataRange));
        LinkedListNode head = node;
        for (int i = 1; i < length; i++) {
            node = node.append(r.nextInt(dataRange));
        }
        return head;
    }

    /**
     * Print all nodes starting from this.
     */
    public void printForward() {
        System.out.println(this.toString());
    }

    /**
     * Print all nodes starting from this.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedListNode node = this;
        while (!node.isTail()) {
            stringBuilder.append(node.getData()).append(" -> ");
            node = node.getNext();
        }
        stringBuilder.append(node.getData());
        return stringBuilder.toString();
    }

    /**
     * Return true if head of linked list.
     */
    public boolean isHead() {
        return prev == null;
    }

    /**
     * Return true if tail of linked list.
     */
    public boolean isTail() {
        return next == null;
    }

    /**
     * Return next node
     */
    public LinkedListNode getNext() {
        return this.next;
    }

    /**
     * Return previous node
     */
    public LinkedListNode getPrev() {
        return this.prev;
    }

    /**
     * Get node content
     */
    public int getData() {
        return data;
    }

    @Override
    public boolean equals(Object node) {
        if (!(node instanceof LinkedListNode)) {
            return false;
        }
        LinkedListNode runner = this;
        LinkedListNode runner1 = (LinkedListNode) node;
        while (runner != null || runner1 != null) {
            if (runner == null || runner1 == null) {
                // linked list with different length
                return false;
            }
            if (runner.getData() != runner1.getData()) {
                // nodes with different data
                return false;
            }
            runner = runner.getNext();
            runner1 = runner1.getNext();
        }
        return true;
    }
}
