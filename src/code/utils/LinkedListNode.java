package utils;

import java.util.Random;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class LinkedListNode implements Cloneable {

    private int data;
    private LinkedListNode prev;
    private LinkedListNode next;

    /**
     * Homemade double-linked list to use for our exercises on lists.
     * @param   data The node data.
     */
    public LinkedListNode(int data) {
        this.data = data;
    }

    /**
     * Create and append new node to current one.
     * @param   data The node data.
     * @return  The appended node.
     */
    public LinkedListNode append(int data) {
        LinkedListNode node = new LinkedListNode(data);
        this.append(node);
        return node;
    }

    /**
     * Create and prepend new node to current one.
     * @param   data The node data.
     * @return  The prepended node.
     */
    public LinkedListNode prepend(int data) {
        LinkedListNode node = new LinkedListNode(data);
        this.prepend(node);
        return node;
    }

    /**
     * Append node to current one.
     * @param   node The node to append.
     */
    public void append(LinkedListNode node) {
        if (this != node) {
            // prevent circular list
            this.next = node;
            if (node != null && node.prev != this) {
                node.prepend(this);
            }
        }
    }

    /**
     * Prepend node to current one.
     * @param   node The node to prepend.
     */
    public void prepend(LinkedListNode node) {
        if (this != node) {
            // prevent circular list
            this.prev = node;
            if (node != null && node.next != this) {
                node.append(this);
            }
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
     * @return  The size of the linked list with head the given node.
     */
    public int getListLength() {
        int counter = 0;
        LinkedListNode runner = this;
        while (runner != null) {
            counter++;
            runner = runner.getNext();
        }
        return counter;
    }

    /**
     * Return a cloned LinkedListNode
     * @return  A cloned Linked list starting from this node.
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
     * and with values in the range [0, dataRange).
     *
     * @param   length The random linked list number of nodes.
     * @param   dataRange The nodes can have value in the range [0, dataRange).
     * @return  The head of a random generated linked list.
     */
    public static LinkedListNode createRandomLinkedList(int length, int dataRange) {
        LinkedListNode head = null;
        if (length > 0) {
            Random r = new Random();
            LinkedListNode node = new LinkedListNode(r.nextInt(dataRange));
            head = node;
            for (int i = 1; i < length; i++) {
                node = node.append(r.nextInt(dataRange));
            }
        }
        return head;
    }

    /**
     * Return an array of random linked lists, each with values in the range [0, dataRange).
     *
     * @param   arraySize The array size.
     * @param   listLength The size of each linked list in the array.
     * @param   dataRange The nodes can have value in the range [0, dataRange).
     * @return  The array of random linked lists.
     */
    public static LinkedListNode[] createRandomLinkedListArray(int arraySize, int listLength, int dataRange) {
        LinkedListNode[] listArray = new LinkedListNode[arraySize];
        for (int i = 0; i < arraySize; i++) {
            listArray[i] = createRandomLinkedList(listLength, dataRange);
        }
        return listArray;
    }

    /**
     * Print all nodes starting from this.
     */
    public void printForward() {
        System.out.println(this);
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

    /**
     * Change node data
     * @param   data The node data.
     */
    public void setData(int data) {
        this.data = data;
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
