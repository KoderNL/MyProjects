package com.myproject.datastructures.queue;

public class ArrayQueue implements Queue {
    //capacity method write
    private int size;
    private Object[] array;
    public ArrayQueue(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void enqueue(Object value) {
        ensureCapacity();

        array[size] = value;
        size++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        Object result = array[0];
        for (int i = 0; i < size; i++) {
            array[i] = array[i + 1];
        }
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if(i == 0){
                stringBuilder.append("[");
            }
            stringBuilder.append(array[i]);
            if(i == size - 1){
                stringBuilder.append("]");
                break;
            }
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
    private void ensureCapacity() {
        Object[] newArray = new Object[(int) Math.round(array.length * 1.5)];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
