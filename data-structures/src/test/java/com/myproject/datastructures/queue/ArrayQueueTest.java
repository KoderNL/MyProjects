package com.myproject.datastructures.queue;

public class ArrayQueueTest extends AbstractQueueTest {
    @Override
    protected Queue getQueue() {
        return new ArrayQueue(2);
    }
}