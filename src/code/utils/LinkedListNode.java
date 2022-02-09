package utils;

import org.json.simple.JSONObject;

import java.util.function.Supplier;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class LinkedListNode<T> implements Cloneable {

    private T data;
    private LinkedListNode<T> prev;
    private LinkedListNode<T> next;

    /**
     * Homemade double-linked list to use for our exercises on lists.
     * @param   data The node data.
     */
    public LinkedListNode(T data) {
        this.data = data;
    }

    /**
     * Create and append new node to current one.
     * @param   data The node data.
     * @return  The appended node.
     */
    public LinkedListNode<T> append(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data);
        this.append(node);
        return node;
    }

    /**
     * Create and prepend new node to current one.
     * @param   data The node data.
     * @return  The prepended node.
     */
    public LinkedListNode<T> prepend(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data);
        this.prepend(node);
        return node;
    }

    /**
     * Append node to current one.
     * @param   node The node to append.
     */
    public void append(LinkedListNode<T> node) {
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
    public void prepend(LinkedListNode<T> node) {
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
        LinkedListNode<T> runner = this;
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
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public LinkedListNode<T> clone() {
        LinkedListNode<T> clone = new LinkedListNode<>(this.data);
        LinkedListNode<T> headCloned = clone;
        for (LinkedListNode<T> node = this; !node.isTail(); node = node.getNext()) {
            clone = clone.append(node.next.getData());
        }
        return headCloned;
    }

    /**
     * Return a linked list of the specified length.
     *
     * @param   length The linked list number of nodes.
     * @param   supplier The supplier function which generates the object T.
     * @return  The head of the generated linked list.
     */
    public static <T> LinkedListNode<T> createLinkedList(
            int length,
            Supplier<T> supplier
    ) {
        LinkedListNode<T> head = null;
        if (length > 0) {
            LinkedListNode<T> node = new LinkedListNode<>(supplier.get());
            head = node;
            for (int i = 1; i < length; i++) {
                node = node.append(supplier.get());
            }
        }
        return head;
    }

    /**
     * Return a linked list of the specified length.
     *
     * @param   params Set of parameters to use for generating a linked list.
     * @param   supplier The supplier function which generates the object T.
     * @return  The head of the generated linked list.
     */
    public static <T> LinkedListNode<T> createLinkedList(
            JSONObject params,
            Supplier<T> supplier
    ) {
        return createLinkedList(
                ((Long) params.get("listSize")).intValue(),
                supplier
        );
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
        LinkedListNode<T> node = this;
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
    public LinkedListNode<T> getNext() {
        return this.next;
    }

    /**
     * Return previous node
     */
    public LinkedListNode<T> getPrev() {
        return this.prev;
    }

    /**
     * Get node content
     */
    public T getData() {
        return data;
    }

    /**
     * Change node data
     * @param   data The node data.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Complexity: O(N)
     * @return List size starting from current node.
     */
    public Integer getSize() {
        Integer size = 0;
        LinkedListNode<T> runner = this;

        while (runner != null) {
            size++;
            runner = runner.getNext();
        }

        return size;
    }

    @Override
    public boolean equals(Object node) {
        if (!(node instanceof LinkedListNode<?>)) {
            return false;
        }
        LinkedListNode<?> runner = this;
        LinkedListNode<?> runner1 = (LinkedListNode<?>) node;
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
