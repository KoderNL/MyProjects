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
    public void testAddValueToIndexThatIsLargerThanTheSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("b",3);
        });
        assertEquals("IndexOutOfBoundsException",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Add value to index that is less than size of array")
    @Test
    public void testAddValueToIndexThatIsLessThanSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("b",-1);
        });
        assertEquals("IndexOutOfBoundsException",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Remove index that is larger than size of array")
    @Test
    public void testRemoveIndexThatIsLargerThanSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(3);
        });
        assertEquals("IndexOutOfBoundsException",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Remove index that is less than size of array")
    @Test
    public void testRemoveIndexThatIsLessThanSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(-1);
        });
        assertEquals("IndexOutOfBoundsException",indexOutOfBoundsException.getMessage());
    }
    //
    @DisplayName("Set value to index that is larger than the size of array")
    @Test
    public void testSetValueToIndexThatIsLargerThanTheSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("VW",3);
        });
        assertEquals("IndexOutOfBoundsException",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Set value to index that is less than size of array")
    @Test
    public void testSetValueToIndexThatIsLessThanSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("VW",-1);
        });
        assertEquals("IndexOutOfBoundsException",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Get value to index that is larger than the size of array")
    @Test
    public void testGetValueToIndexThatIsLargerThanTheSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(3);
        });
        assertEquals("IndexOutOfBoundsException",indexOutOfBoundsException.getMessage());
    }
    @DisplayName("Get value to index that is less than size of array")
    @Test
    public void testGetValueToIndexThatIsLessThanSizeOfArray() {
        indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(-1);
        });
        assertEquals("IndexOutOfBoundsException",indexOutOfBoundsException.getMessage());
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    @DisplayName("Add and remove and change size correctly")
    @Test
    public void testAddAndRemoveAndChangeSizeCorrectly() {
        arrayList.add("1");
        arrayList.add(2,1);
        assertEquals(2,arrayList.size());
        arrayList.remove(1);
        arrayList.remove(0);
        assertTrue(arrayList.isEmpty());
    }
    @DisplayName("Add value over initial capacity and remove work correctly change size")
    @Test
    public void testAddValueOverInitialCapacityAndRemoveWorkCorrectlyChangeSize() {
        arrayList.add(1);
        arrayList.add(2,1);
        arrayList.add(3,2);
        arrayList.remove(2);
        arrayList.remove(1);
        arrayList.remove(0);
        assertTrue(arrayList.isEmpty());
    }
    @DisplayName("Get value")
    @Test
    public void testGetValue() {
        arrayList.add(1);
        arrayList.add(1,2);
        assertEquals(1,arrayList.get(2));
    }
    @DisplayName("Set value")
    @Test
    public void testSetValue() {
        arrayList.add(1);
        arrayList.add(1,2);
        arrayList.set(111,2);
        assertEquals(111,arrayList.get(2));
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
