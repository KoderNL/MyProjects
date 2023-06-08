package com.myproject.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private ArrayList arrayList;
    private IndexOutOfBoundsException indexOutOfBoundsException;

    @BeforeEach
    protected void setUp() {
        arrayList = new ArrayList(2);
    }
    @DisplayName("Add value to index that is larger than the size of array")
    @Test
    public void testAddValueToIndexThatIsLargerThenTheSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("b",3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Add value to index that is less then zero")
    @Test
    public void testAddValueToIndexThatIsLessThenZero() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("b",-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Remove index that is larger then size of array")
    @Test
    public void testRemoveIndexThatIsLargerThenSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Remove index that is less then zero")
    @Test
    public void testRemoveIndexThatIsLessThenZero() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    //
    @DisplayName("Set value to index that is larger then the size of array")
    @Test
    public void testSetValueToIndexThatIsLargerThanTheSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("VW",3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Set value to index that is less then zero")
    @Test
    public void testSetValueToIndexThatIsLessThenZero() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("VW",-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Get value to index that is larger then the size of array")
    @Test
    public void testGetValueToIndexThatIsLargerThanTheSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(3);
        });
        assertEquals("Index 3 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Get value to index that is less then zero")
    @Test
    public void testGetValueToIndexThatIsLessThenZero() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(-1);
        });
        assertEquals("Index -1 out of bounds size 0",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Add and remove and change size correctly")
    @Test
    public void testAddAndRemoveAndChangeSizeCorrectly() {
        arrayList.add("1000");
        arrayList.add(2000,1);
        assertEquals(2,arrayList.size());
        arrayList.remove(1);//
        arrayList.remove(0);
        assertTrue(arrayList.isEmpty());
    }
    @DisplayName("Add value over initial capacity and remove work correctly change size")
    @Test
    public void testAddValueOverInitialCapacityAndRemoveWorkCorrectlyChangeSize() {
        arrayList.add("1000");
        arrayList.add(null);
        arrayList.add(2000,2);
        arrayList.add('A',3);
        arrayList.add(true,4);
        arrayList.add(2.0,5);
        assertEquals(6,arrayList.size());

        assertEquals(2.0,arrayList.remove(5));
        assertEquals(true,arrayList.remove(4));
        assertEquals('A',arrayList.remove(3));
        assertEquals(2000,arrayList.remove(2));
        assertEquals("1000",arrayList.remove(0));
        assertTrue(arrayList.isEmpty());
    }
    @DisplayName("Get value")
    @Test
    public void testGetValue() {
        arrayList.add(404);
        arrayList.add(404,1);
        assertEquals(404,arrayList.get(1));
    }
    @DisplayName("Set value")
    @Test
    public void testSetValue() {
        arrayList.add(1);
        arrayList.add(1,1);
        arrayList.set(111,1);
        assertEquals(111,arrayList.get(1));
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
    @DisplayName("String output")
    @Test
    public void testStringOutput() {
        arrayList.add("V");
        arrayList.add("W");
        arrayList.add("T5");
        assertEquals("[V, W, T5]",arrayList.toString());
    }
}
