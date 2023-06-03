package com.myproject.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {

    @Test
    public void testPushInsureCapacityAndPopWorkCorrectlyWhenChangeSize() {
    ArrayStack arrayStack = new ArrayStack(2);
    arrayStack.push("22");
    arrayStack.push(33);
    arrayStack.push(1);

    assertEquals(3,arrayStack.size());
    assertEquals(1,arrayStack.pop());
    assertEquals(33, arrayStack.pop());
    assertEquals("22", arrayStack.pop());

    assertEquals(0,arrayStack.size());
    assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testPushAndPeek() {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push("A");

        assertEquals("A",arrayStack.peek());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewStack() {
        ArrayStack arrayStack = new ArrayStack(10);

        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnStackWithData() {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push("A");

        assertFalse(arrayStack.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnStackAfterClear() {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(1);
        arrayStack.clear();

        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push("Ad");

        assertTrue(arrayStack.contains("Ad"));
    }

    @Test
    public void testContainsReturnFalse() {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(1);

        assertFalse(arrayStack.contains(2));
    }

    @Test
    public void testContainsReturnFalseOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack(10);

        assertFalse(arrayStack.contains(2));
    }

    @Test
    public void testThrowIllegalStateExceptionWhenPopOnEmptyStack() {

        Assertions.assertThrows(IllegalStateException.class, () -> {
            ArrayStack arrayStack = new ArrayStack( 10);
            arrayStack.pop();
        });
    }


}
