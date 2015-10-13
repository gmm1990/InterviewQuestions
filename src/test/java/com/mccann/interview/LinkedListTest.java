package com.mccann.interview;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by Gerard on 10/12/2015.
 */
public class LinkedListTest {
    private static int TEST_LIST_SIZE = 10;

    @Test
    public void testAdd() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        Integer firstNewItem = new Random().nextInt();
        Integer secondNewItem = new Random().nextInt();
        list.add(firstNewItem);
        list.add(secondNewItem);


        Integer[] correctList = {firstNewItem, secondNewItem};
        Integer[] testList = new Integer[2];
        testList[0] = list.get(0);
        testList[1] = list.get(1);
        assertArrayEquals(correctList, testList);
    }

    @Test
    public void testAddMiddle() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i <= TEST_LIST_SIZE; i++) {
            list.add(i);
        }
        Random random = new Random();
        Integer firstNewItem = random.nextInt();
        Integer secondNewItem = random.nextInt();
        list.add(firstNewItem, 2);
        list.add(secondNewItem, 3);

        Integer[] correctList = {1, 2, firstNewItem, secondNewItem, 3, 4, 5, 6, 7, 8 ,9, 10};
        Integer[] testList = new Integer[TEST_LIST_SIZE + 2];
        for(int i = 0; i < TEST_LIST_SIZE + 2; i++) {
            testList[i] = list.get(i);
        }

        assertArrayEquals(correctList, testList);
    }

    @Test
    public void testAddBeginning() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= TEST_LIST_SIZE; i++) {
            list.add(i);
        }

        Random random = new Random();
        Integer firstNewItem = random.nextInt();
        Integer secondNewItem = random.nextInt();
        list.add(firstNewItem, 0);
        list.add(secondNewItem, 0);

        Integer[] correctList = {secondNewItem, firstNewItem};
        Integer[] testList = new Integer[2];
        testList[0] = list.get(0);
        testList[1] = list.get(1);
        assertArrayEquals(correctList, testList);
    }

    @Test
    public void testRemoveIndex() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= TEST_LIST_SIZE; i++) {
            list.add(i);
        }

        list.remove(2);
        list.remove(0);
        Integer[] correctList = {2, 4, 5, 6, 7, 8 ,9, 10};
        Integer[] testList = new Integer[TEST_LIST_SIZE - 2];
        for(int i = 0; i < TEST_LIST_SIZE - 2; i++) {
            testList[i] = list.get(i);
        }
        assertArrayEquals(correctList, testList);
    }

    @Test
    public void testRemoveItem() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= TEST_LIST_SIZE; i++) {
            list.add(i);
        }
        list.remove(new Integer(3));
        list.remove(new Integer(7));
        Integer[] correctList = {1, 2, 4, 5, 6, 8 ,9, 10};
        Integer[] testList = new Integer[TEST_LIST_SIZE - 2];
        for(int i = 0; i < TEST_LIST_SIZE - 2; i++) {
            testList[i] = list.get(i);
        }
        assertArrayEquals(testList, correctList);
    }

    @Test
    public void testContainsNegative() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= TEST_LIST_SIZE; i++) {
            list.add(i);
        }

        assertFalse(list.contains(new Integer(12)));
    }

    @Test
    public void testContainsPositive() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= TEST_LIST_SIZE; i++) {
            list.add(i);
        }

        assertTrue(list.contains(new Integer(3)));
    }

    @Test
    public void testAddSize() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= TEST_LIST_SIZE; i++) {
            list.add(i);
        }

        assertEquals(TEST_LIST_SIZE, list.getSize());
    }

    @Test
    public void testRemoveSize() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= TEST_LIST_SIZE; i++) {
            list.add(i);
        }

        list.remove(1);
        assertEquals(TEST_LIST_SIZE - 1, list.getSize());
    }


}