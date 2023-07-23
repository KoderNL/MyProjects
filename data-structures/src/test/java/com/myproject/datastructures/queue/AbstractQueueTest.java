package com.myproject.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractQueueTest {
    private Queue queue;
    protected abstract Queue getQueue();
    @BeforeEach
    protected void before(){
        queue = getQueue();
    };
    @DisplayName("Dequeue empty queue")
    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyStack() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            queue.dequeue();
        });
    }
    @DisplayName("Empty queue")
    @Test
    public void testEmptyQueue() {
        queue.enqueue(1);
        queue.clear();
        assertTrue(queue.isEmpty());
    }
    @DisplayName("Peek value")
    @Test
    public void testPeekValue() {
        queue.enqueue(1);
        queue.enqueue("a");
        assertEquals(1,queue.peek());
    }
    @DisplayName("Enqueue and dequeue work correctly and change size")
    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2,queue.size());

        assertEquals(1,queue.dequeue());
        assertEquals(2,queue.dequeue());
        assertEquals(0,queue.size());
        assertTrue(queue.isEmpty());
    }
    @DisplayName("Enqueue over initial capacity and dequeue work correctly and change size")
    @Test
    public void testEnqueueOverInitialCapacityAndDequeueWorkCorrectlyAndChangeSize() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3,queue.size());

        assertEquals(1,queue.dequeue());
        assertEquals(2,queue.dequeue());
        assertEquals(3,queue.dequeue());
        assertEquals(0,queue.size());
        assertTrue(queue.isEmpty());
    }
    @DisplayName("Clear queue")
    @Test
    public void testClearQueue() {
        queue.enqueue(1);
        queue.enqueue("a");
        queue.clear();
        assertTrue(queue.isEmpty());
    }
    @DisplayName("String output")
    @Test
    public void testStringOutput() {
        queue.enqueue("V");
        queue.enqueue("W");
        queue.enqueue("T5");
        assertEquals("[V, W, T5]",queue.toString());
    }
    @DisplayName("Contains value")
    @Test
    public void testContainsValue() {
        queue.enqueue("V");
        queue.enqueue("W");
        queue.enqueue("T5");
        assertTrue(queue.contains("W"));
    }
}