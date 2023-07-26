package com.myproject.datastructures.list;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {
    private Node head;
    private int size;
    @Override
    public void add(T value) {
        add(value,size);
    }

    @Override
    public void add(T value, int index) {

    }

    @Override
    public T remove(int index) {
        T result= null;
        Node current = head;
        for (int i = 0; i <= index; i++) {
            if(current.index == index) {
                result = (T) current;
            }
        }
        return result;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(T value, int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public int indexOf(T value) {
        return 0;
    }

    @Override
    public int lastIndexOf(T value) {
        return 0;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
    private class Node {
        T value;
        Node next;
        Node prev;
        int index;

        public Node(T value){
            this.value = value;
        }
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
