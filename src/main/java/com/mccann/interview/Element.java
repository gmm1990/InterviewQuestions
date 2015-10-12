package com.mccann.interview;

/**
 * Created by Gerard on 10/9/2015.
 */
class Element<T> {
    private Element<T> next;
    private Element<T> previous;
    final private T data;


    Element(T data) {
        this.data = data;
    }


    T getData() {
        return data;
    }


    void setNext(Element<T> next) {
        this.next = next;
    }


    Element<T> getNext() {
        return next;
    }


    void setPrevious(Element<T> previous) {
        this.previous = previous;
    }


    Element<T> getPrevious() {
        return previous;
    }
}
