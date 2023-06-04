package com.myproject.datastructures.queue;

public interface Queue {
    void enqueue(Object value);
    Object dequeue();
    int size();
    Object peek();
    boolean isEmpty();
    void clear();
    boolean contains(Object value);
    String toString();
}
