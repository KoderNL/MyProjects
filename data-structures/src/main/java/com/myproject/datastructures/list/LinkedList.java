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
        if(size == 0) {
            head = tail = NewNode;
            head.value = value;
            head.index = size;
            size++;
        } else if(index == size ) {
            NewNode.value = value;
            NewNode.prev = tail;
            NewNode.index = index;
            tail.next = NewNode;
            tail = NewNode;
            size++;
        } else if(index == 0) {
            NewNode.value = value;
            NewNode.next = head;
            NewNode.index = index;
            head.prev = NewNode;
            head = NewNode;
            size++;
            Node current = head.next;
            for (int i = 1; i < size; i++) {
                current.index = current.index + 1;
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
        }
        else if(index > 0 && index < size - 1) {//add to middle
            Node current = head;
            for (int i = 0; i < index; i++) {
                if (i == index - 1) {
                    NewNode.index = index;
                    NewNode.value = value;
                    NewNode.next = current.next;
                    NewNode.prev = current;
                    current.next = NewNode;
                    current.next.next.prev = NewNode;
                    size++;
                }
                current = current.next;
            }
            current = current.next;

            for (int i = current.index; i < size; i++) {
                current.index = current.index + 1;
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
        }
    }

    @Override
    public T remove(int index) {
        validateIndex(index,size);
        T oldValue = null;
        Node current = head;
        if(index == 0) {
            oldValue = current.value;
            current.value = null;
            head = current.next;
            current.next = null;
            current = head;
            for (int i = 0; i < size; i++) {
                current.index = current.index - 1;
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
        }
        if(index == size - 1) {
            current = tail;
            oldValue = current.value;
            tail = current.prev;
            tail.next = null;
            current.prev = null;
            current.value = null;
        }
        size--;
        return oldValue;
    }

    @Override
    public T get(int index) {
        validateIndex(index,size);
        T result = null;
        Node current = head;
        for (int i = 0; i <= index; i++) {
            if(current.index == index) {
                result = current.value;
                break;
            }
            if(head.next == null){
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
            if(current.next != null){
                current = current.next;
            }
        }
        return oldValue;
    }

    @Override
    public void clear() {
        Node current = head;
        Node temporary = null;
        for (int i = 0; i < size; i++) {
            if(current.next == null) {
                current.prev = null;
                current.value = null;
                break;
            }
            temporary = current.next;
            current.prev = null;
            current.next = null;
            current.value = null;
            current = temporary;
        }
        head = tail = null;
        size = 0;
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
        throw new IllegalArgumentException("Element not found in the list");
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
    private void indexCorrection() {

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
