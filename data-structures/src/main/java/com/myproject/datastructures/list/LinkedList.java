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
        T result = null;//will put result
        Node current = head;;//указатель на первый елемент
        for (int i = 0; i < index; i++) {
            current = current.next;//на каждой итерации ложим  в указатель ссылку на следующий
            if(current.index == index) {//проверяем если в ноде по индексу совпадает верни нам эту ноду
                result = (T) current;
            }
        }
        return result;
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть отрицательным: " + index);
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }

            current = current.next;
            currentIndex++;
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
        int index = 0;
        Node<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.getData().equals(value)) {
                return index;
            }

            currentNode = currentNode.getNext();
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        int index = size() - 1;
        Node<T> currentNode = tail;

        while (currentNode != null) {
            if (currentNode.getData().equals(value)) {
                return index;
            }

            currentNode = currentNode.getPrev();
            index--;
        }

        return -1;
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
