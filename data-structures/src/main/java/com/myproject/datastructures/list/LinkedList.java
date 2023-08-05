package com.myproject.datastructures.list;

import java.util.Iterator;

public class LinkedList<T> extends AbstractList<T> {
    private Node head;
    private Node tail;
    private int size;
    public LinkedList() {
        head = new Node(null);

    }
    public LinkedList(T value) {
        head = new Node(value);
        head.value = value;
    }
    @Override
    public void add(T value) {
        add(value,size);
    }

    @Override
    public void add(T value, int index) {
        validateIndex(index,size);

        Node NewNode = new Node(value);
        if(size == 0) {//add to start in empty LL
            head = tail = NewNode;
            head.value = value;
            head.index = size;
            size++;
        } else if(index == size - 1) {//add to end of LL
            NewNode.value = value;
            NewNode.prev = tail;
            NewNode.index = index;
            tail.next = NewNode;
            tail = NewNode;
            size++;
        } else if(index == 0) {//add to start of LL
            NewNode.value = value;
            NewNode.next = head;
            NewNode.index = index;
            head.prev = NewNode;
            head = NewNode;
            size++;
        }

    }

    @Override
    public T remove(int index) {
        validateIndex(index,size);
        T oldValue = null;
        Node current = head;
        for (int i = 0; i <= index; i++) {
            if (current.next.index == index) {
                oldValue = current.next.value;

                current.next = current.next.next;
                current.next.next.prev = current;

                current.next.next = null;
                current.next.prev = null;
                current.next.value = null;
            }
            current = current.next;
        }
        return oldValue;
    }

    @Override
    public T get(int index) {
        validateIndex(index,size);
        T result = null;
        Node current = head;
        for (int i = 0; i <= index; i++) {
            if(current.index == index){
                result = current.value;
                break;
            }
            current = current.next;
        }
        return result;
    }


    @Override
    public T set(T value, int index) {
        validateIndex(index,size);
        Node current = head;
        T oldValue = null;
        for (int i = 0; i <= index; i++) {
            if(current.index == index) {
                oldValue = current.value;
                current.value = value;
            }
        }
        return oldValue;
    }

    @Override
    public void clear() {
        Node current = head;
        for (int i = 0; i < size; i++) {
            Node temporary = current.next;
            current.prev = null;
            current.next = null;
            current = temporary;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        return !(indexOf(value) == -1);
    }

    @Override
    public int indexOf(T value) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if(current.value == value) {
                return current.index;
            }
            current = current.next;
        }
        return throw ;
    }

    @Override
    public int lastIndexOf(T value) {
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
