package com.myproject.datastructures.stack;

public class ArrayStack implements Stack {//пишем реализацию интерфейса стек
    private int size = 0;
    private Object[] array;
    public ArrayStack(int initialCapacity) {
        array = new Object[initialCapacity];
    }
    @Override
    public void push(Object value) {
        ensureCapacity();

        array[size] = value;
        size++;
    }

    @Override
    public Object pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        Object result = array[size - 1];
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {// проверка на отсутсвие значений.
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public Object peek() {
        return array[size - 1];
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < array.length; i++) {
            Object ValueInStack = array[i];
            if(value.equals(ValueInStack)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        Object[] newArray = new Object[array.length * 2];
        for(int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
       array = newArray;
    }

}
