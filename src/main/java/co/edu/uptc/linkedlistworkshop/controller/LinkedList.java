package co.edu.uptc.linkedlistworkshop.controller;

import co.edu.uptc.linkedlistworkshop.model.Moto;
import java.util.ArrayList;

public class LinkedList <T> {

    private Node<T> head;
    private Node<T> last;

    /**
     * Constructor for LinkedList.
     * Initializes an empty linked list with head and last set to null.
     */
    public LinkedList() {
        head = null;
        last = null;
    }

    /**
     * Checks if the linked list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null && last == null;
    }

    /**
     * Adds a new node with the provided info at the beginning of the linked list.
     *
     * @param info the information to store in the new node.
     */
    public void addNodeFirst(T info) {
        Node<T> newNode = new Node<>(info);
        if (isEmpty()) {
            head = newNode;
            last = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        }
    }

    /**
     * Adds a new node with the provided info at the end of the linked list.
     *
     * @param info the information to store in the new node.
     */
    public void addNodeLast(T info) {
        Node<T> newNode = new Node<>(info);
        if (isEmpty()) {
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
        }
    }

    /**
     * Adds a new node with the provided info after the node with the specified id.
     *
     * @param id   the id of the node after which to add the new node.
     * @param info the information to store in the new node.
     */
    public void addNodeAfterTo(int id, T info) {
        Node<T> currentNode = findNode(id);
        if (currentNode != null) {
            Node<T> newNode = new Node<>(info);
            Node<T> nextNode = currentNode.getNext();

            newNode.setNext(nextNode);
            newNode.setPrevious(currentNode);
            currentNode.setNext(newNode);

            if (nextNode != null) {
                nextNode.setPrevious(newNode);
            } else {
                last = newNode;
            }
        }
    }

    /**
     * Adds a new node with the provided info before the node with the specified id.
     *
     * @param id   the id of the node before which to add the new node.
     * @param info the information to store in the new node.
     */
    public void addNodeBeforeTo(int id, T info) {
        Node<T> currentNode = findNode(id);
        if (currentNode != null) {
            Node<T> newNode = new Node<>(info);
            Node<T> previousNode = currentNode.getPrevious();

            newNode.setNext(currentNode);
            newNode.setPrevious(previousNode);
            currentNode.setPrevious(newNode);

            if (previousNode != null) {
                previousNode.setNext(newNode);
            } else {
                head = newNode;
            }
        }
    }

    /**
     * Adds a new node with the provided info in a sorted manner.
     * Adds the node at the end of the list and then sorts the list.
     *
     * @param info the information to store in the new node.
     */
    public void addNodeSorted(T info) {
        addNodeLast(info);
        sortLinkedList();
    }

    /**
     * Finds and returns the node with the specified id.
     *
     * @param id the id of the node to find.
     * @return the node if found, or null if not found.
     */
    public Node<T> findNode(int id) {
        Node<T> node = head;
        while (node != null) {
            if (getNodeId(node) == id) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * Returns an ArrayList containing the elements of the linked list.
     * If order is true, the list is ordered from first to last.
     * If order is false, the list is ordered from last to first.
     *
     * @param order boolean to specify the order of the list.
     * @return an ArrayList with the elements of the linked list.
     */
    public ArrayList<T> getLinkedList(boolean order) {
        ArrayList<T> list = new ArrayList<>();
        if (order) {
            Node<T> current = head;
            while (current != null) {
                list.add(current.getInfo());
                current = current.getNext();
            }
        } else {
            Node<T> current = head;
            while (current != null) {
                list.add(current.getInfo());
                current = current.getPrevious();
            }
        }
        return list;
    }

    /**
     * Deletes the node with the specified id and returns its information.
     *
     * @param id the id of the node to delete.
     * @return the information of the deleted node, or null if not found.
     */
    public T deleteNode(int id) {
        Node<T> deletedNode = findNode(id);
        if (deletedNode != null) {
            Node<T> previousNode = deletedNode.getPrevious();
            Node<T> nextNode = deletedNode.getNext();

            if (previousNode != null) {
                previousNode.setNext(nextNode);
            } else {
                head = nextNode;
            }

            if (nextNode != null) {
                nextNode.setPrevious(previousNode);
            } else {
                last = previousNode;
            }
            return deletedNode.getInfo();
        }
        return null;
    }

    /**
     * Returns the size of the linked list (number of nodes).
     *
     * @return the number of nodes in the linked list.
     */
    public int getSize() {
        Node<T> currentNode = head;
        int size = 0;

        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    /**
     * Returns the first node of the linked list.
     *
     * @return the head node of the linked list.
     */
    public Node<T> getFist() {
        return head;
    }

    /**
     * Returns the last node of the linked list.
     *
     * @return the last node of the linked list.
     */
    public Node<T> getLast() {
        return last;
    }

    /**
     * Sorts the linked list based on the node id in ascending order.
     */
    public void sortLinkedList() {
        if (isEmpty() || head == null) {
            return;
        }

        boolean ordered;

        do {
            Node<T> current = head;
            ordered = false;

            while (current != null && current.getNext() != null) {
                int currentNodeId = getNodeId(current);
                int nextNodeId = getNodeId(current.getNext());

                if (currentNodeId > nextNodeId) {
                    T aux = current.getInfo();
                    current.setInfo(current.getNext().getInfo());
                    current.getNext().setInfo(aux);
                    ordered = true;
                }
                current = current.getNext();
            }
        } while (ordered);
    }

    /**
     * Returns the id of the specified node.
     *
     * @param node the node whose id is to be retrieved.
     * @return the id of the node, or -1 if the info is not of type Moto.
     */
    public int getNodeId(Node<T> node) {
        if (node.getInfo() instanceof Moto moto) {
            return moto.getId();
        }
        return -1;
    }
}
