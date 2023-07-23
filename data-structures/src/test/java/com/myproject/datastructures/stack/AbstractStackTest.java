package com.myproject.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStackTest {
    private Stack stack;
    protected abstract Stack getStack();

    @BeforeEach
    protected void before() {
        stack = getStack();
    }

    @DisplayName("Push insure capacity and pop work correctly when change size")
    @Test
    public void testPushInsureCapacityAndPopWorkCorrectlyWhenChangeSize() {
        stack.push("22");
        stack.push(33);
        stack.push(1);
        assertEquals(3,stack.size());
        assertEquals(1,stack.pop());
        assertEquals(33, stack.pop());
        assertEquals("22", stack.pop());
        assertEquals(0,stack.size());
        assertTrue(stack.isEmpty());
    }

    @DisplayName("Push and peek")
    @Test
    public void testPushAndPeek() {
        stack.push("A");
        assertEquals("A",stack.peek());
    }

    @DisplayName("Is empty return true on new stack")
    @Test
    public void testIsEmptyReturnTrueOnNewStack() {
        assertTrue(stack.isEmpty());
    }

    @DisplayName("Is empty return false on stack with data")
    @Test
    public void testIsEmptyReturnFalseOnStackWithData() {
        stack.push("A");
        assertFalse(stack.isEmpty());
    }

    @DisplayName("Is empty return true on stack after clear")
    @Test
    public void testIsEmptyReturnTrueOnStackAfterClear() {
        stack.push(1);
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @DisplayName("Contains return true")
    @Test
    public void testContainsReturnTrue() {
        stack.push("Ad");
        assertTrue(stack.contains("Ad"));
    }

    @DisplayName("Contains return False")
    @Test
    public void testContainsReturnFalse() {
        stack.push(1);
        assertFalse(stack.contains(2));
    }

    @DisplayName("Contains return false on empty stack")
    @Test
    public void testContainsReturnFalseOnEmptyStack() {
        assertFalse(stack.contains(2));
    }

    @DisplayName("Throw illegal state exception when pop on empty stack")
    @Test
    public void testThrowIllegalStateExceptionWhenPopOnEmptyStack() {
            Assertions.assertThrows(IllegalStateException.class, () -> {stack.pop();
    });
    }
}
