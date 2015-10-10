package com.mccann.interview;

/**
 * Created by Gerard on 10/9/2015.
 */
public class Node <T> {
    private Node<T> next;
    private Node<T> last;
    final private T data;


    Node(T data) {
        this.data = data;
    }


    public T getData() {
        return data;
    }


    public void setNext(Node<T> next) {
        this.next = next;
    }


    public Node<T> getNext() {
        return next;
    }


    public void setLast(Node<T> last) {
        this.last = last;
    }


    public Node<T> getLast() {
        return last;
    }
}
