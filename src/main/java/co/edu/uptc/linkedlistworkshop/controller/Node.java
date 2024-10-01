package co.edu.uptc.linkedlistworkshop.controller;

/**
 * A generic Node class for representing an element in a doubly linked list.
 * Each node contains a reference to the stored data (info), the next node, and the previous node.
 * @param <T> the type of data stored in this Node.
 */
public class Node<T> {
    private T info;
    private Node<T> next;
    private Node<T> previous;

    /**
     * Constructor to create a new Node with the specified data.
     * Initializes the next and previous nodes as null.
     * @param info the data stored in this node.
     */
    public Node(T info) {
        this.info = info;
        this.next = null;
        this.previous = null;
    }

    /**
     * Retrieves the data stored in this node.
     * @return the data stored in this node.
     */
    public T getInfo() {
        return info;
    }

    /**
     * Sets the data stored in this node.
     * @param info the new data to be stored in this node.
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Retrieves the next node in the linked list.
     * @return the next node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the reference to the next node in the linked list.
     * @param next the next node to be set.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Retrieves the previous node in the linked list.
     * @return the previous node.
     */
    public Node<T> getPrevious() {
        return previous;
    }

    /**
     * Sets the reference to the previous node in the linked list.
     * @param previous the previous node to be set.
     */
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}