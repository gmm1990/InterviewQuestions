package com.mccann.interview;

/**
 * Created by Gerard on 10/9/2015.
 */
public class Node <T>{
    private Node next;
    final private T data;


    Node(T data) {
        this.data = data;
    }


    public T getData() {
        return data;
    }


    public void setNext(Node next) {
        this.next = next;
    }


    public Node getNext() {
        return next;
    }
}
