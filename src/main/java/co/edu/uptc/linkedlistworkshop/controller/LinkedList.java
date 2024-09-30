package co.edu.uptc.linkedlistworkshop.controller;

import co.edu.uptc.linkedlistworkshop.model.Moto;
import java.util.ArrayList;

public class LinkedList <T> {

    private Node<T> head;
    private Node<T> last;

    public LinkedList() {
        head = null;
        last = null;
    }

    public boolean isEmpty() {
        return head == null && last == null;
    }

    public void addNodeFirst(T info) {
        Node<T> newNode = new Node<>(info);
        if(isEmpty()) {
            head = newNode;
            last = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addNodeLast(T info) {
        Node<T> newNode = new Node<>(info);
        if(isEmpty()) {
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
        }
    }

    public void addNodeAfterTo(int id, T info) {
        Node<T> currentNode = findNode(id);
        if(currentNode != null) {
            Node<T> newNode = new Node<>(info);
            Node<T> nextNode = currentNode.getNext();

            newNode.setNext(nextNode);
            newNode.setPrevious(currentNode);
            currentNode.setNext(newNode);

            if(nextNode != null) {
                nextNode.setPrevious(newNode);
            } else {
                last = newNode;
            }
        }
    }

    public void addNodeBeforeTo(int id, T info) {
        Node<T> currentNode = findNode(id);
        if(currentNode != null) {
            Node<T> newNode = new Node<>(info);
            Node<T> previousNode = currentNode.getPrevious();

            newNode.setNext(currentNode);
            newNode.setPrevious(previousNode);
            currentNode.setPrevious(newNode);

            if(previousNode != null) {
                previousNode.setNext(newNode);
            } else {
                head = newNode;
            }
        }
    }

    public void addNodeSorted(T info) {
        addNodeLast(info);
        sortLinkedList();
    }

    public Node<T> findNode(int id) {
        Node<T> node = head;
        while (node != null) {
            if (getNodeId(node) == id){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public ArrayList<T> getLinkedList(boolean order){
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

    public T deleteNode(int id) {
        Node<T> deletedNode = findNode(id);
        if(deletedNode != null) {
            Node<T> previousNode = deletedNode.getPrevious();
            Node<T> nextNode = deletedNode.getNext();

            if(previousNode != null) {
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

    public int getSize(){
        Node<T> currentNode = head;
        int size = 0;

        while(currentNode != null) {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    public T getFist() {
        return head.getInfo();
    }

    public T getLast() {
        return last.getInfo();
    }

    public void sortLinkedList(){
        if(isEmpty() || head == null) {
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

    public int getNodeId(Node<T> node) {
        if (node.getInfo() instanceof Moto moto){
            return moto.getId();
        }
        return -1;
    }
}
