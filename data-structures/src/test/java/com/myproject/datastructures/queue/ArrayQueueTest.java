package com.myproject.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
    private ArrayQueue arrayQueue;
    @BeforeEach
    protected void setUp() { //Этот метод будет вызываться перед каждым тестовым методом
        arrayQueue = new ArrayQueue(2);
    }
    @DisplayName("Dequeue empty queue")
    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyStack() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }
    @DisplayName("Empty queue")
    @Test
    public void testEmptyQueue() {
        arrayQueue.enqueue(1);
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }
    @DisplayName("Peek value")
    @Test
    public void testPeekValue() {
        arrayQueue.enqueue(1);
        arrayQueue.enqueue("a");
        assertEquals(1,arrayQueue.peek());
    }
    @DisplayName("Enqueue and dequeue work correctly and change size")
    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        assertEquals(2,arrayQueue.size());

        assertEquals(1,arrayQueue.dequeue());
        assertEquals(2,arrayQueue.dequeue());
        assertEquals(0,arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }
    @DisplayName("Enqueue over initial capacity and dequeue work correctly and change size")
    @Test
    public void testEnqueueOverInitialCapacityAndDequeueWorkCorrectlyAndChangeSize() {
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        assertEquals(3,arrayQueue.size());

        assertEquals(1,arrayQueue.dequeue());
        assertEquals(2,arrayQueue.dequeue());
        assertEquals(3,arrayQueue.dequeue());
        assertEquals(0,arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }
    @DisplayName("Clear queue")
    @Test
    public void testClearQueue() {
        arrayQueue.enqueue(1);
        arrayQueue.enqueue("a");
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }
    @DisplayName("String output")
    @Test
    public void testStringOutput() {
        arrayQueue.enqueue("V");
        arrayQueue.enqueue("W");
        arrayQueue.enqueue("T5");
        assertEquals("[V, W, T5]",arrayQueue.toString());
    }
    @DisplayName("Contains value")
    @Test
    public void testContainsValue() {
        arrayQueue.enqueue("V");
        arrayQueue.enqueue("W");
        arrayQueue.enqueue("T5");
        assertTrue(arrayQueue.contains("W"));
    }
}