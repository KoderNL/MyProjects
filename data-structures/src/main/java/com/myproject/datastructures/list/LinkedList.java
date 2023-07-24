package com.myproject.datastructures.list;

import java.util.Iterator;

public class LinkedList<T> implements List<T>{
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public class LinkedList {
        Node head;

        public LinkedList() {
            this.head = null;
        }

        // Метод для добавления элемента в конец списка
        public void append(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
}
