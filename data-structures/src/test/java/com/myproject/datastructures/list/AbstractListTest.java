package com.myproject.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractListTest {
    private List list;
    protected abstract List getList();
    private IndexOutOfBoundsException indexOutOfBoundsException;
    IllegalArgumentException illegalArgumentException;

    @BeforeEach
    protected void before() {
        list = getList();
    }

    @DisplayName("Add value to index that is less then zero throw IndexOutOfBoundsException")
    @Test
    public void testAddValueToIndexThatIsLessThenZeroThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("b",-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }

    @DisplayName("Remove index that is larger then size of list throw IndexOutOfBoundsException")
    @Test
    public void testRemoveIndexThatIsLargerThenSizeOfListThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }

    @DisplayName("Remove index that is less then zero  throw IndexOutOfBoundsException")
    @Test
    public void testRemoveIndexThatIsLessThenZeroThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }

    @DisplayName("Set value to index that is larger then the size of list throw IndexOutOfBoundsException")
    @Test
    public void testSetValueToIndexThatIsLargerThanTheSizeOfListThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("VW",3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }

    @DisplayName("Add value to index that is larger than the size of list throw IndexOutOfBoundsException")
    @Test
    public void testAddValueToIndexThatIsLargerThenTheSizeOfListThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("b",3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }

    @DisplayName("Set value to index that is less then zero throw IndexOutOfBoundsException")
    @Test
    public void testSetValueToIndexThatIsLessThenZeroThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("VW",-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }

    @DisplayName("Get value to index that is larger then the size of list throw IndexOutOfBoundsException")
    @Test
    public void testGetValueToIndexThatIsLargerThanTheSizeOfListThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }

    @DisplayName("Get value to index that is less then zero throw IndexOutOfBoundsException")
    @Test
    public void testGetValueToIndexThatIsLessThenZeroThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }

    @DisplayName("Try Send to IndexOf element that is not in the list throw ElementNotFoundException")
    @Test
    public void testTrySendToIndexOfElementThatIsNotInTheListThrowElementNotFoundException() {
        illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            list.add(100);
            list.indexOf(101);
            list.lastIndexOf(101);
        });
        assertEquals("Element not found in the list", illegalArgumentException.getMessage());
    }

    @DisplayName("Try Send to Last IndexOf element that is not in the list throw ElementNotFoundException")
    @Test
    public void testTrySendToLastIndexOfElementThatIsNotInTheListThrowElementNotFoundException() {
        illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            list.add(100);
            list.lastIndexOf(101);
        });
        assertEquals("Element not found in the list", illegalArgumentException.getMessage());
    }

    @DisplayName("Add to start of list and size work correctly")
    @Test
    public void testAddToStartOfListAndSizeWorkCorrectly() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(100,0);
        assertEquals(100,list.get(0));
        assertEquals(10,list.get(1));
        assertEquals(20,list.get(2));
        assertEquals(30,list.get(3));
        assertEquals(4,list.size());
    }

    @DisplayName("Add to end of list and size work correctly")
    @Test
    public void testAddToEndOfListAndSizeWorkCorrectly() {
        list.add(10);
        assertEquals(10,list.get(0));
        list.add(20);
        assertEquals(20,list.get(1));
        list.add(30,2);
        assertEquals(30,list.get(2));
        assertEquals(20,list.get(1));
        assertEquals(10,list.get(0));
        assertEquals(3,list.size());
    }

    @DisplayName("Add to middle of list and size work correctly")
    @Test
    public void testAddToMiddleOfListAndSizeWorkCorrectly() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(1000,2);
        assertEquals(10,list.get(0));
        assertEquals(20,list.get(1));
        assertEquals(1000,list.get(2));
        assertEquals(30,list.get(3));
        assertEquals(40,list.get(4));
        assertEquals(5,list.size());
    }

    @DisplayName("Remove from start of list and size work correctly")
    @Test
    public void testRemoveFromStartOfListAndSizeWorkCorrectly() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        assertEquals(10,list.remove(0));
        assertEquals(20,list.remove(0));
        assertEquals(30,list.remove(0));
        assertEquals(40,list.remove(0));
        assertEquals(0,list.size());
        assertTrue(list.isEmpty());
    }

    @DisplayName("Remove from end of list and size work correctly")
    @Test
    public void testRemoveFromEndOfListAndSizeWorkCorrectly() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        assertEquals(40,list.remove(3));
        assertEquals(30,list.remove(2));
        assertEquals(20,list.remove(1));
        assertEquals(1,list.size());
    }

    @DisplayName("Remove from middle of list and size work correctly")
    @Test
    public void testRemoveFromMiddleOfListAndSizeWorkCorrectly() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        assertEquals(30,list.remove(2));
        assertEquals(20,list.remove(1));
        assertEquals(2,list.size());
    }

    @DisplayName("Add different types in list and size work correctly")
    @Test
    public void testAddDifferentTypesInListAndSizeWorkCorrectly() {
        list.add("1000");
        list.add(2000,1);
        list.add('A',2);
        list.add(true,3);
        list.add(null,4);
        list.add(2.0,5);
        list.add(1234567890L,6);
        list.add(3.14f,7);
        list.add("CoderNL",8);
        assertEquals("CoderNL",list.get(8));
        assertEquals(3.14f,list.get(7));
        assertEquals(1234567890L,list.get(6));
        assertEquals(2.0,list.get(5));
        assertNull(list.get(4));
        assertEquals(true,list.get(3));
        assertEquals('A',list.get(2));
        assertEquals(2000,list.get(1));
        assertEquals("1000",list.get(0));
        assertEquals(9,list.size());
    }

    @DisplayName("IndexOf work correctly when positive expected")
    @Test
    public void testIndexOfWorkCorrectlyWhenPositiveExpected() {
        list.add(1);
        list.add(2);
        list.add(2);
        assertEquals(1,list.indexOf(2));
    }

    @DisplayName("LastIndexOf work correctly when positive expected")
    @Test
    public void testLastIndexOfWorkCorrectlyWhenPositiveExpected() {
        list.add(20);
        list.add(10);
        list.add(30);
        list.add(10);
        list.add(50);
        list.add(10);
        assertEquals(3,list.lastIndexOf(10));
    }

    @DisplayName("Set value")
    @Test
    public void testSetValue() {
        list.add(0);
        list.add(20,1);
        list.set(30,1);
        assertEquals(30,list.get(1));
    }

    @DisplayName("Get value")
    @Test
    public void testGetValue() {
        list.add(10);
        list.add(20,1);
        assertEquals(20,list.get(1));
    }

    @DisplayName("Clear work correctly")
    @Test
    public void testClearWorkCorrectly() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @DisplayName("Contains value")
    @Test
    public void testContainsValue() {
        list.add(1);
        list.add("2",1);
        assertTrue(list.contains("2"));
    }

    @DisplayName("String output")
    @Test
    public void testStringOutput() {
        list.add("1000");
        list.add(2000,1);
        list.add('A',2);
        list.add(true,3);
        list.add(null,4);
        list.add(2.0,5);
        list.add("CoderNL",6);
        assertEquals("[1000, 2000, A, true, null, 2.0, CoderNL]", list.toString());
    }

    @DisplayName("List is empty after initialization")
    @Test
    public void listIsEmptyAfterInitialization() {
        Assertions.assertTrue(list.isEmpty());
    }

    @DisplayName("Iterator work correctly")
    @Test
    public void testIteratorWorkCorrectly() {
        list.add("Test Message #1");
        list.add("Test Message #2");
        Iterator iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Test Message #1",iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Test Message #2",iterator.next());
        assertFalse(iterator.hasNext());
    }
}

