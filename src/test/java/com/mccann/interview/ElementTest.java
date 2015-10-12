package com.mccann.interview;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gerard on 10/11/2015.
 */
public class ElementTest {

    @Test
    public void testGetData() throws Exception {
        Integer inputData = 1;
        Element<Integer> element = new Element<>(inputData);

        assertEquals(inputData, element.getData());
    }

    @Test
    public void testSetNext() throws Exception {
        Element<Integer> firstElement = new Element<>(1);
        Element<Integer> nextElement = new Element<>(2);
        firstElement.setNext(nextElement);

        assertEquals(firstElement.getNext(), nextElement);

    }

    @Test
    public void testSetPrevious() throws Exception {
        Element<Integer> secondElement = new Element<>(2);
        Element<Integer> previousElement = new Element<>(1);
        secondElement.setPrevious(previousElement);

        assertEquals(secondElement.getPrevious(), previousElement);
    }


}