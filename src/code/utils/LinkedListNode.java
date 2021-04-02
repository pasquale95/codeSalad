package utils;

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
     *
     * @param data
     */
    public LinkedListNode(int data) {
        this.data = data;
    }

    /**
     * Create and append new node to current one.
     * @param data
     */
    public void append(int data) {
        LinkedListNode node = new LinkedListNode(data);
        node.prepend(this);
    }

    /**
     * Create and prepend new node to current one.
     * @param data
     */
    public void prepend(int data) {
        LinkedListNode node = new LinkedListNode(data);
        node.prepend(this);
    }

    /**
     * Append node to current one.
     * @param node
     */
    public void append(LinkedListNode node) {
        if (this != node && node != null) {
            // prevent circular list
            this.next = node;
            node.prepend(this);
        }
    }

    /**
     * Prepend node to current one.
     * @param node
     */
    public void prepend(LinkedListNode node) {
        if (this != node && node != null) {
            // prevent circular list
            this.prev = node;
            node.append(this);
        }
    }

    /**
     * Delete current node from list
     */
    public void delete() {
        prev.next = this.next;
        next.prev = this.prev;
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
}
