package com.myproject.datastructures.list;

import java.util.StringJoiner;

public class ArrayList implements List {
    private static final int DEFAULT_INITIAL_CAPACITY = 2;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid capacity: " + initialCapacity);
        }
        if(initialCapacity == 0) {
            throw new IndexOutOfBoundsException("Index " + initialCapacity + " out of bounds size " + getCapacity());
        }
        array = new Object[initialCapacity];
        }

    private Object[] array;
    private int size;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        validateIndex(index, size);
        if (size == array.length) {
            increaseCapacity();
        }
        array[index] = value;
        size++;
    }

    @Override
    public Object get(int index) {
        validateIndex(index, size);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        validateIndex(index, size);
        Object oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public Object remove(int index) {
        Object valueToRemove;
        validateIndex(index, size);
        valueToRemove = array[index];
        if (index != size - 1) {
            System.arraycopy(array,index + 1,array,index,size - index - 1);
        }
        array[size - 1] = null;
        size--;
        return valueToRemove;
    }

    @Override
    public int indexOf(Object value) {
        for (int index = 0; index < size; index++) {
            Object firstOfIndex = array[index];
            if (value.equals(firstOfIndex)) {
                return index;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object value) {
        for (int index = indexOf(value) + 1; index < size; index++) {
            Object lastOfIndex = array[index];
            if(value.equals(lastOfIndex)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if(array[i] != null){
                return false;
            }
            if(i == size - 1){
                size = 0;
            }
        }
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        StringJoiner listContents = new StringJoiner(", ","[","]");
        for (int i = 0; i < size; i++) {
            //через обжект добавлять
            listContents.add(array[i].toString());
        }
        return listContents.toString();
    }

    private void increaseCapacity() {
        @SuppressWarnings("unchecked")
        Object[] newArray = new Object[(int) Math.round(array.length * 1.5)];
        System.arraycopy(array,0,newArray,0,size);
        array = newArray;
    }

    private void validateIndex(int index, int size) {
        if(index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds size " + size);
        }
        if(index > size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds size " + size);
        }
    }
    int getCapacity() {return array.length;}
}


