package com.myproject.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

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
        else if(index > 0 && index < size - 1) {
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
        Node current = null;
        if(index == 0 && size == 1) {
            oldValue = head.value;
            head.value = null;
            tail = head = null;
        }

        if(index == 0 && size != 1) {
            current = head.next;
            current.prev = null;
            oldValue = head.value;
            head.next = null;
            head.value = null;
            head = current;
            for (int i = 0; i < size; i++) {
                current.index = current.index - 1;
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
        }

        if(index == size - 1 && size != 1) {
            current = tail.prev;
            current.next = null;
            oldValue = tail.value;
            tail.next = null;
            tail.prev = null;
            tail = current;
        }
        if(index != size - 1 && size != 1) {
            current = head;
            for (int i = 0; i < index; i++) {
                if(current.next.index == index) {
                    oldValue = current.next.value;
                    current.next.next.prev = current;
                    current.next = current.next.next;
                    current.next.prev = null;
                    current.next.next = null;
                    current.next.value = null;
                }
                current = current.next;
            }
            for (int i = 0; i < size; i++) {
                current.index = current.index - 1;
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
        }
        size--;
        return oldValue;
    }

    @Override
    public T get(int index) {
        validateIndex(index,size);
        T result = null;
        Node current = head;
        if (current.index == index) {
            result = current.value;
        }
        for (int i = 0; i < index; i++) {
            if(current.next.index == index) {
                result = current.next.value;
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
        for (int i = 0; i < index; i++) {
            if(current.next.index == index) {
                oldValue = current.next.value;
                current.next.value = value;
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
        int lastIndexOf = indexOf(value);
        Node current = head;
        for (int i = indexOf(value) + 1; i < size; i++) {
                if(current.value.equals(value)) {
                    lastIndexOf = current.index;
                }
            current = current.next;
        }
        return lastIndexOf;
    }

    @Override
    public String toString() {
        StringJoiner listContents = new StringJoiner(", ","[","]");
        Node current = head;
        for (int i = 0; i < size; i++) {
            if(current.value == null) {
                current.value = (T) "null";
            }
            listContents.add(current.value.toString());
            current = current.next;
        }
        return listContents.toString();
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
