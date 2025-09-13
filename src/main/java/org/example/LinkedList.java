package org.example;

public class LinkedList {
    private class Node {
        int value;
        Node next;
    }

    Node head = null;
    int size = 0;

    public LinkedList() {
    }

    public int peek(int index) {
        // TODO: Please implement me
        return 0;
    }
    public boolean isEmpty() {
        // TODO: Please implement me
        if( head == null ) {
            return true;
        }
        return false;
    }

    public LinkedList add(int value) {
        // TODO: Please implement me

        Node newNode = new Node();
        newNode.value = value;
        newNode.next = head;
        head = newNode ;

        size++;

        return this;
    }

    public LinkedList remove(int index) {
        // TODO: Please implement me
        
        return this;
    }
}