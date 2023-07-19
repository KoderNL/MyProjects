package com.myproject.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.swing.text.html.HTMLDocument;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private ArrayList arrayList;
    private IndexOutOfBoundsException indexOutOfBoundsException;
    IllegalArgumentException illegalArgumentException;

    @BeforeEach
    protected void setUp() {
        arrayList = new ArrayList(2);
    }

    @DisplayName("Constructor with custom initial capacity less zero throw IllegalArgumentException")
    @Test
    public void testConstructorWithCustomInitialCapacityLessZeroThrowIllegalArgumentException() {
        illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            arrayList = new ArrayList(-1);
        });
        assertEquals("Invalid capacity: -1",illegalArgumentException.getMessage());
    }
    @DisplayName("Add value to index that is larger than the size of array throw IndexOutOfBoundsException")
    @Test
    public void testAddValueToIndexThatIsLargerThenTheSizeOfArrayThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("b",3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Add value to index that is less then zero throw IndexOutOfBoundsException")
    @Test
    public void testAddValueToIndexThatIsLessThenZeroThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("b",-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Remove index that is larger then size of array throw IndexOutOfBoundsException")
    @Test
    public void testRemoveIndexThatIsLargerThenSizeOfArrayThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Remove index that is less then zero  throw IndexOutOfBoundsException")
    @Test
    public void testRemoveIndexThatIsLessThenZeroThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    //
    @DisplayName("Set value to index that is larger then the size of array throw IndexOutOfBoundsException")
    @Test
    public void testSetValueToIndexThatIsLargerThanTheSizeOfArrayThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("VW",3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Set value to index that is less then zero throw IndexOutOfBoundsException")
    @Test
    public void testSetValueToIndexThatIsLessThenZeroThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("VW",-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Get value to index that is larger then the size of array throw IndexOutOfBoundsException")
    @Test
    public void testGetValueToIndexThatIsLargerThanTheSizeOfArrayThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Get value to index that is less then zero throw IndexOutOfBoundsException")
    @Test
    public void testGetValueToIndexThatIsLessThenZeroThrowIndexOutOfBoundsException() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Constructor with default initial capacity work correctly")
    @Test
    public void testConstructorWithDefaultInitialCapacityWorkCorrectly() {
        assertEquals(2, arrayList.getCapacity());
    }
    @DisplayName("Initial capacity for constructor with zero initial capacity work correctly")
    @Test
    public void testInitialCapacityForConstructorWithZeroInitialCapacityWorkCorrectly() {
        assertEquals(0,arrayList.size());
    }
    @DisplayName("Add and remove and change size and capacity work correctly")
    @Test
    public void testAddAndRemoveAndChangeSizeAndCapacityWorkCorrectly() {
        arrayList.add("1000");
        arrayList.add(2000,1);
        assertEquals(2,arrayList.size());
        arrayList.remove(1);//
        arrayList.remove(0);
        assertTrue(arrayList.isEmpty());
    }
    @DisplayName("Add different types in list and remove change size work correctly")
    @Test
    public void testAddDifferentTypesInListAndRemoveChangeSizeWorkCorrectly() {
        arrayList.add("1000");
        arrayList.add(2000,1);
        arrayList.add('A',2);
        arrayList.add(true,3);
        arrayList.add(null,4);
        arrayList.add(2.0,5);
        arrayList.add(1234567890L,6);
        arrayList.add(3.14f,7);
        arrayList.add("CoderNL",8);
        assertEquals(9,arrayList.size());

        assertEquals("CoderNL",arrayList.remove(8));
        assertEquals(3.14f,arrayList.remove(7));
        assertEquals(1234567890L,arrayList.remove(6));
        assertEquals(2.0,arrayList.remove(5));
        assertNull(arrayList.remove(4));
        assertEquals(true,arrayList.remove(3));
        assertEquals('A',arrayList.remove(2));
        assertEquals(2000,arrayList.remove(1));
        assertEquals("1000",arrayList.remove(0));
        assertTrue(arrayList.isEmpty());
    }
    @DisplayName("Add many of values and change size work correctly")
    @Test
    public void testAddManyOfValuesAndChangeSizeWorkCorrectly() {
        for (int i = 1; i <= 10000000; i++) {
            arrayList.add("number " + i);
        }
        assertTrue(arrayList.contains("number 10000000"));
        assertEquals(10000000,arrayList.size());
    }
    @DisplayName("IndexOf work correctly when positive expected")
    @Test
    public void testIndexOfWorkCorrectlyWhenPositiveExpected() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        assertEquals(1,arrayList.indexOf(2));
    }
    @DisplayName("IndexOf work correctly when negative expected")
    @Test
    public void testIndexOfWorkCorrectlyWhenNegativeExpected() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        assertEquals(-1,arrayList.indexOf(3));
    }
    @DisplayName("LastIndexOf work correctly when positive expected")
    @Test
    public void testLastIndexOfWork() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        assertEquals(2,arrayList.lastIndexOf(2));
    }
    @DisplayName("Set value")
    @Test
    public void testSetValue() {
        arrayList.add(1);
        arrayList.add(1,1);
        arrayList.set(111,1);
        assertEquals(111,arrayList.get(1));
    }
    @DisplayName("Get value")
    @Test
    public void testGetValue() {
        arrayList.add(404);
        arrayList.add(404,1);
        assertEquals(404,arrayList.get(1));
    }
    @DisplayName("Clear work correctly")
    @Test
    public void testClearWorkCorrectly() {
        arrayList.add(1);
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }
    @DisplayName("Contains value")
    @Test
    public void testContainsValue() {
        arrayList.add(1);
        arrayList.add("2",1);
        assertTrue(arrayList.contains("2"));
    }
    @DisplayName("String output")
    @Test
    public void testStringOutput() {
        arrayList.add("V");
        arrayList.add("W");
        arrayList.add("T5");
        arrayList.add(null);
        assertEquals("[V, W, T5, null]",arrayList.toString());
    }
    @DisplayName("Iterator work correctly")
    @Test
    public void testIteratorWorkCorrectly() {
        arrayList.add("Test Message #1");
        arrayList.add("Test Message #2");
        Iterator iterator = arrayList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Test Message #1",iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Test Message #2",iterator.next());
        assertFalse(iterator.hasNext());
    }
}
