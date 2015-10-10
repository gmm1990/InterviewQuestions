package com.mccann.interview;

/**
 * Created by Gerard on 10/9/2015.
 */
public class LinkedList <T> {
    Node<T> head;
    Node<T> tail;
    int size;


    LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    public void add(T element) {
        Node<T> newItem = new Node<>(element);
        if(head == null) {
            head = newItem;
            tail = newItem;
        } else {
            newItem.setLast(tail);
            tail.setNext(newItem);
            tail = newItem;
        }
        size++;
    }


    public void add(T element, int position) {
        if(position > size) {
            add(element);
        } else {
            Node<T> newItem = new Node<>(element);
            Node<T> currentItem = get(position);
            Node<T> lastItem = currentItem.getLast();
            newItem.setNext(currentItem);
            currentItem.setLast(newItem);
            lastItem.setNext(newItem);
            size++;
        }
    }


    public void remove(int position) {
        Node<T> item = get(position);
        Node<T> lastItem;
        Node<T> nextItem;
        lastItem = item.getLast();
        nextItem = item.getNext();
        lastItem.setNext(nextItem);
        nextItem.setLast(lastItem);
        size--;
    }


    //TODO add remove with element type

    public Node<T> get(int position) {
        if(position > size) {
            return null;
        }
        Node<T> item = head;
        while(position > 0) {
            item = item.getNext();
            position--;
        }
        return item;
    }
}
