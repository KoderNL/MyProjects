package com.myproject.datastructures.list;

import datastructures.list.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractListTest {
    private List<T> list;
    private IndexOutOfBoundsException indexOutOfBoundsException;
    IllegalArgumentException illegalArgumentException;

    @BeforeEach
    protected void before() {
        list = getList();
    }

    protected abstract List getList(); 
    @DisplayName("Constructor with custom initial capacity less zero throw IllegalArgumentException")
    @Test
    public void testConstructorWithCustomInitialCapacityLessZeroThrowIllegalArgumentException() {
        illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            list = new list(-1);
        });
        assertEquals("Invalid capacity: -1",illegalArgumentException.getMessage());
    }
    @DisplayName("Add value to index that is larger than the size of array throw IndexOutOfBoundsException")
    @Test
    public void testAddValueToIndexThatIsLargerThenTheSizeOfArrayThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("b",3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Add value to index that is less then zero throw IndexOutOfBoundsException")
    @Test
    public void testAddValueToIndexThatIsLessThenZeroThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("b",-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Remove index that is larger then size of array throw IndexOutOfBoundsException")
    @Test
    public void testRemoveIndexThatIsLargerThenSizeOfArrayThrowIndexOutOfBoundsException() {
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
    //
    @DisplayName("Set value to index that is larger then the size of array throw IndexOutOfBoundsException")
    @Test
    public void testSetValueToIndexThatIsLargerThanTheSizeOfArrayThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("VW",3);
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
    @DisplayName("Get value to index that is larger then the size of array throw IndexOutOfBoundsException")
    @Test
    public void testGetValueToIndexThatIsLargerThanTheSizeOfArrayThrowIndexOutOfBoundsException() {
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
    @DisplayName("Constructor with default initial capacity work correctly")
    @Test
    public void testConstructorWithDefaultInitialCapacityWorkCorrectly() {
        assertEquals(2, list.getCapacity());
    }
    @DisplayName("Initial capacity for constructor with zero initial capacity work correctly")
    @Test
    public void testInitialCapacityForConstructorWithZeroInitialCapacityWorkCorrectly() {
        assertEquals(0,list.size());
    }
    @DisplayName("Add and remove and change size and capacity work correctly")
    @Test
    public void testAddAndRemoveAndChangeSizeAndCapacityWorkCorrectly() {
        list.add("1000");
        list.add(2000,1);
        assertEquals(2,list.size());
        list.remove(1);//
        list.remove(0);
        assertTrue(list.isEmpty());
    }
    @DisplayName("Add different types in list and remove change size work correctly")
    @Test
    public void testAddDifferentTypesInListAndRemoveChangeSizeWorkCorrectly() {
        list.add("1000");
        list.add(2000,1);
        list.add('A',2);
        list.add(true,3);
        list.add(null,4);
        list.add(2.0,5);
        list.add(1234567890L,6);
        list.add(3.14f,7);
        list.add("CoderNL",8);
        assertEquals(9,list.size());

        assertEquals("CoderNL",list.remove(8));
        assertEquals(3.14f,list.remove(7));
        assertEquals(1234567890L,list.remove(6));
        assertEquals(2.0,list.remove(5));
        assertNull(list.remove(4));
        assertEquals(true,list.remove(3));
        assertEquals('A',list.remove(2));
        assertEquals(2000,list.remove(1));
        assertEquals("1000",list.remove(0));
        assertTrue(list.isEmpty());
    }
    @DisplayName("Add many of values and change size work correctly")
    @Test
    public void testAddManyOfValuesAndChangeSizeWorkCorrectly() {
        for (int i = 1; i <= 10000000; i++) {
            list.add("number " + i);
        }
        assertTrue(list.contains("number 10000000"));
        assertEquals(10000000,list.size());
    }
    @DisplayName("IndexOf work correctly when positive expected")
    @Test
    public void testIndexOfWorkCorrectlyWhenPositiveExpected() {
        list.add(1);
        list.add(2);
        list.add(2);
        assertEquals(1,list.indexOf(2));
    }
    @DisplayName("IndexOf work correctly when negative expected")
    @Test
    public void testIndexOfWorkCorrectlyWhenNegativeExpected() {
        list.add(1);
        list.add(2);
        list.add(2);
        assertEquals(-1,list.indexOf(3));
    }
    @DisplayName("LastIndexOf work correctly when positive expected")
    @Test
    public void testLastIndexOfWork() {
        list.add(1);
        list.add(2);
        list.add(2);
        assertEquals(2,list.lastIndexOf(2));
    }
    @DisplayName("Set value")
    @Test
    public void testSetValue() {
        list.add(1);
        list.add(1,1);
        list.set(111,1);
        assertEquals(111,list.get(1));
    }
    @DisplayName("Get value")
    @Test
    public void testGetValue() {
        list.add(404);
        list.add(404,1);
        assertEquals(404,list.get(1));
    }
    @DisplayName("Clear work correctly")
    @Test
    public void testClearWorkCorrectly() {
        list.add(1);
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
        list.add("V");
        list.add("W");
        list.add("T5");
        list.add(null);
        assertEquals("[V, W, T5, null]",list.toString());
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
