package com.myproject.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 2;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid capacity: " + initialCapacity);
        }
        if(initialCapacity == 0) {
            throw new IndexOutOfBoundsException("Index " + initialCapacity + " out of bounds size " + getCapacity());
        }
        array = (T[]) new Object[initialCapacity];
    }

    private T[] array;
    private int size;

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        validateIndex(index, size);
        if (size == array.length) {
            increaseCapacity();
        }
        array[index] = value;
        size++;
    }

    @Override
    public T get(int index) {
        validateIndex(index, size);
        return array[index];
    }

    @Override
    public T set(T value, int index) {
        validateIndex(index, size);
        T oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public T remove(int index) {
        T valueToRemove;
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
    public int indexOf(T value) {
        for (int index = 0; index < size; index++) {
            T firstOfIndex = array[index];
            if (value.equals(firstOfIndex)) {
                return index;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(T value) {
        for (int index = indexOf(value) + 1; index < size; index++) {
            T lastOfIndex = array[index];
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
        T[] newArray = (T[]) new Object[(int) Math.round(array.length * 1.5)];
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

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<T> {
        private int index = 0;
        private boolean allowedToRemove;
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("No elements for iterate");
            };
            allowedToRemove = true;
            return array[index++];
        }

        @Override
        public void remove() {
            if (!allowedToRemove) {
                throw new IllegalStateException("not allowed to remove");
            }
            ArrayList.this.remove(index - 1);
            index--;
            allowedToRemove = false;
        }
    }
}