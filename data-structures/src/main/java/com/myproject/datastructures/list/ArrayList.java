package com.myproject.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ArrayList<T> extends AbstractList<T> {
    private T[] array;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 2;
    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid capacity: " + initialCapacity);
        }

        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T value) {
       add(value, size);
    }

    @Override
    public void add(T value, int index) {
        if (size == array.length) {
            ensureCapacityIfGrowNeeded();
        }
        validateIndex(index, size);
        if(index == 0 && size > 0) {
            for (int i = size; i >= 0; i--) {
                array[i + 1] = array[i];
            }
            array[index] = value;
            size++;
        } else if(index > 0 && index < size) {
            size++;
            for (int i = size - 2; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = value;
        } else {
            array[index] = value;
            size++;
        }
    }

    @Override
    public T set(T value, int index) {
        validateIndex(index, size);
        T oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public int indexOf(T value) {
        T comparableValue;
        for (int index = 0; index < size; index++) {
            comparableValue = array[index];
            if (value.equals(comparableValue)) {
                return index;
            }
        }
        throw new IllegalArgumentException("Element not found in the list");
    }

    @Override
    public int lastIndexOf(T value) {
        T lastOfIndexOf;
        for (int index = indexOf(value) + 1; index < size; index++) {
            lastOfIndexOf = array[index];
            if(value.equals(lastOfIndexOf)) {
                return index;
            }
        }
        throw new IllegalArgumentException("Element not found in the list");
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public T remove(int index) {
        validateIndex(index, size);
        T valueToRemove = array[index];
        if (index != size - 1) {
            System.arraycopy(array,index + 1,array,index,size - index - 1);
        }
        array[size - 1] = null;
        size--;
        return valueToRemove;
    }

    @Override
    public T get(int index) {
        validateIndex(index,size);
        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringJoiner listContents = new StringJoiner(", ","[","]");
        for (int i = 0; i < size; i++) {
            if(array[i] == null) {
                array[i] = (T) "null";
            }
            listContents.add(array[i].toString());
        }
        return listContents.toString();
    }
    public int getCapacity() {return array.length;}

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<T> {
        private int index;
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
                throw new IllegalStateException("Not allowed to remove");
            }
            ArrayList.this.remove(index - 1);
            index--;
            allowedToRemove = false;
        }
    }

    private void ensureCapacityIfGrowNeeded() {
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
}