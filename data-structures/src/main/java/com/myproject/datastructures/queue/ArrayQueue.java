package com.myproject.datastructures.queue;

import java.util.StringJoiner;

public class ArrayQueue implements Queue {
    //capacity method write
    private int size;
    private Object[] array;
    public ArrayQueue(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void enqueue(Object value) {
        if(size == array.length ) {
            grow();
        }

        array[size] = value;
        size++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        Object result = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object peek() {
        return array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            Object ValueInQueue = array[i];
            if(value.equals(ValueInQueue)){
                return true;
            }
        }
        return false;
    }
    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(", ","[","]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }
    private void grow() {
        Object[] newArray = new Object[(int) Math.round(array.length * 1.5)];
        System.arraycopy(array,0,newArray,0,size);
        array = newArray;
    }
}
