package com.myproject.datastructures.list;

import java.util.StringJoiner;

public class ArrayList implements List {
    public ArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
    }
    private Object[] array;
    private int size;
    @Override
    public void add(Object value) {
        add(value,size);
    }

    @Override
    public void add(Object value, int index) {
        indexOutOfBoundsExceptionVerification(index,size);
        if(size == array.length) {
            grow();
        }
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        Object removed;
        indexOutOfBoundsExceptionVerification(index,size);
        removed = array[index];
        if(index != size - 1) {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
        }
        array[size - 1] = null;
        size--;
        return removed;
    }

    @Override
    public Object get(int index) {
        indexOutOfBoundsExceptionVerification(index,size);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        indexOutOfBoundsExceptionVerification(index,size);
        Object oldValue;
        oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            Object valueOfIndex = array[i];
            if(value.equals(valueOfIndex)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = indexOf(value) + 1; i < size; i++) {
            Object valueOfIndex = array[i];
            if(value.equals(valueOfIndex)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean contains(Object value) {
        if (indexOf(value) != -1){
            return true;
        }
        return false;
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
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
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

    private void indexOutOfBoundsExceptionVerification(int index, int size) {
        if(index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        if(index > size){
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
    }
}

