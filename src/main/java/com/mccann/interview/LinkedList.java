package com.mccann.interview;

/**
 * Created by Gerard on 10/9/2015.
 */
public class LinkedList <T> {
    private Element<T> head;
    private Element<T> tail;
    private int size;


    LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data, int position) {
        if((position > size) || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        Element<T> newElement = new Element<>(data);
        Element<T> currentElement;
        Element<T> previousElement;
        if(head == null) {
            head = newElement;
            tail = newElement;
        } else if(position == 0) {
            currentElement = head;
            currentElement.setPrevious(newElement);
            newElement.setNext(currentElement);
            head = newElement;
        } else if(position == size) {
            currentElement = tail;
            currentElement.setNext(newElement);
            newElement.setPrevious(currentElement);
            tail = newElement;
        } else {
            currentElement = find(position);
            previousElement = currentElement.getPrevious();
            previousElement.setNext(newElement);
            newElement.setNext(currentElement);
            newElement.setPrevious(previousElement);
            currentElement.setPrevious(newElement);
        }
        size++;
    }

    public void add(T data) {
        add(data, size);
    }

    public T get(int position) {
        return find(position).getData();
    }

    public void remove(int position) {
        removeLink(find(position));
    }

    public void remove(T removeItem) {
        Element<T> currentItem = head;
        while(!currentItem.getData().equals(removeItem)) {
            currentItem = currentItem.getNext();
        }

        removeLink(currentItem);
    }

    public boolean contains(T item) {
        Element<T> currentElement = head;
        while(currentElement != null) {
            if(currentElement.getData().equals(item)) {
                return true;
            }
            currentElement = currentElement.getNext();
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public void reverse() {
        if(head == null) {
            return;
        }
        Element<T> current = head;
        Element<T> oldNext = head.getNext();
        while(oldNext != null) {
            current.setNext(current.getPrevious());
            current.setPrevious(oldNext);
            current = oldNext;
            oldNext = oldNext.getNext();
        }
        current.setNext(current.getPrevious());
        current.setPrevious(null);

        tail = head;
        head = current;
    }

    private void removeLink(Element<T> item) {
        if((item.getPrevious() == null) && (item.getNext() == null)) {
            head = null;
            tail = null;
        } else if(item.getPrevious() == null) {
            head = item.getNext();
        } else if(item.getNext() == null) {
            tail = item.getPrevious();
        } else {
            Element<T> lastItem = item.getPrevious();
            Element<T> nextItem = item.getNext();
            lastItem.setNext(nextItem);
            nextItem.setPrevious(lastItem);
        }
        size--;
    }

    private Element<T> find(int position) {
        if((position > size) || (position < 0)) {
            String errorMessage = "The position" + position + " is outside the list bounds: 0-" + size;
            throw new IndexOutOfBoundsException(errorMessage);
        }
        Element<T> item = head;
        while(position > 0) {
            item = item.getNext();
            position--;
        }
        return item;
    }
}
