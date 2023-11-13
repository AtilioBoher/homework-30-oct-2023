package com.laba.aboher.custom;
// Java Program to Implement Generic  Linked List

// Importing all input output classes

import java.util.Iterator;

// Class 1
// Helper Class (Generic node class for LinkedList)
class Node<T> {

    // Data members
    // 1. Storing value of node
    T data;
    // 2. Storing address of next node
    Node<T> next;

    // Parameterized constructor to assign value
    Node(T data)
    {

        // This keyword refers to current object itself
        this.data = data;
        this.next = null;
    }

    public T getData()
    {
        return data;
    }

    public Node<T> getNext()
    {
        return next;
    }
}

// Class 2
// Helper class ( Generic LinkedList class)
public class CustomLinkedList<T> implements Iterable<T> {

    // Generic node instance
    Node<T> head;
    // Data member to store length of list
    private int length = 0;

    // Default constructor
    public CustomLinkedList() { this.head = null; }
    // Method
    // To add node at the end of List
    public void add(T data)
    {

        // Creating new node with given value
        Node<T> temp = new Node<>(data);

        // Checking if list is empty
        // and assigning new value to head node
        if (this.head == null) {
            head = temp;
        }

        // If list already exists
        else {

            // Temporary node for traversal
            Node<T> X = head;

            // Iterating till end of the List
            while (X.next != null) {
                X = X.next;
            }

            // Adding new valued node at the end of the list
            X.next = temp;
        }

        // Increasing length after adding new node
        length++;
    }

    // return Head
    Node<T> getHead()
    {
        return head;
    }

    // Method
    // To add new node at any given position
    public void add(int position, T data)
    {

        // Checking if position is valid
        if (position > length + 1) {

            // Display message only
            System.out.println(
                    "Position Unavailable in LinkedList");
            return;
        }

        // If new position is head then replace head node
        if (position == 1) {

            // Temporary node that stores previous head
            // value
            Node<T> temp = head;

            // New valued node stored in head
            head = new Node<T>(data);

            // New head node pointing to old head node
            head.next = temp;

            return;
        }

        // Temporary node for traversal
        Node<T> temp = head;

        // Dummy node with null value that stores previous
        // node
        Node<T> prev = new Node<T>(null);
        // iterating to the given position
        while (position - 1 > 0) {
            // assigning previous node
            prev = temp;
            // incrementing next node
            temp = temp.next;
            // decreasing position counter
            position--;
        }
        // previous node now points to new value
        prev.next = new Node<T>(data);
        // new value now points to former current node
        prev.next.next = temp;
    }
    // Method
    // To remove a node from list
    public void remove(T key)
    {

        //  NOTE
        // dummy node is used to represent the node before
        // the current node Since in a Singly Linked-List we
        // cannot go backwards from a node, we use a dummy
        // node to represent the previous node. In case of
        // head node, since there is no previous node, the
        // previous node is assigned to null.

        // Dummy node with null value
        Node<T> prev = new Node<>(null);

        // Dummy node pointing to head node
        prev.next = head;

        // Next node that points ahead of current node
        Node<T> next = head.next;

        // Temporary node for traversal
        Node<T> temp = head;

        // Boolean value that checks whether value to be
        // deleted exists or not
        boolean exists = false;

        // If head node needs to be deleted
        if (head.data == key) {
            head = head.next;

            // Node to be deleted exists
            exists = true;
        }

        // Iterating over LinkedList
        while (temp.next != null) {

            // We convert value to be compared into Strings
            // and then compare using
            // String1.equals(String2) method

            // Comparing value of key and current node
            if (String.valueOf(temp.data).equals(
                    String.valueOf(key))) {

                // If node to be deleted is found previous
                // node now points to next node skipping the
                // current node
                prev.next = next;
                // node to be deleted exists
                exists = true;

                // As soon as we find the node to be deleted
                // we exit the loop
                break;
            }

            // Previous node now points to current node
            prev = temp;

            // Current node now points to next node
            temp = temp.next;

            // Next node points the node ahead of current
            // node
            next = temp.next;
        }

        // Comparing the last node with the given key value
        if (!exists
                && String.valueOf(temp.data).equals(
                String.valueOf(key))) {

            // If found , last node is skipped over
            prev.next = null;

            // Node to be deleted exists
            exists = true;
        }

        // If node to be deleted exists
        if (exists) {

            // Length of LinkedList reduced
            length--;
        }

        // If node to be deleted does not exist
        else {

            // Print statement
            System.out.println(
                    "Given Value is not present in linked list");
        }
    }

    // Method
    // To clear the entire LinkedList
    public void clear()
    {

        // Head now points to null
        head = null;
        // length is 0 again
        length = 0;
    }

    // Method
    // Returns whether List is empty or not
    public boolean empty()
    {

        // Checking if head node points to null
        if (head == null) {
            return true;
        }
        return false;
    }
    // Method
    // Returning the length of LinkedList
    public int length() { return this.length; }

    // Method
    // To display the LinkedList
    // @Override
    public String toString()
    {

        String S = "{ ";

        Node<T> X = head;

        if (X == null)
            return S + " }";

        while (X.next != null) {
            S += String.valueOf(X.data) + " ->  ";
            X = X.next;
        }

        S += String.valueOf(X.data);
        return S + " }";
    }
    // return Iterator instance
    public Iterator<T> iterator()
    {
        return new ListIterator<T>(this);
    }
}

class ListIterator<T> implements Iterator<T> {
    Node<T> current;

    // initialize pointer to head of the list for iteration
    public ListIterator(CustomLinkedList<T> list)
    {
        current = list.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current != null;
    }

    // return current data and update pointer
    public T next()
    {
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    // implement if needed
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}