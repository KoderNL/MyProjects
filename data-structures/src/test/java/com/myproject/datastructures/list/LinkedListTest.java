package com.myproject.datastructures.list;

import org.junit.jupiter.api.BeforeEach;

public class LinkedListTest extends AbstractListTest {
    private LinkedList linkedList;

    @BeforeEach
    protected void setUp() { //Этот метод будет вызываться перед каждым тестовым методом
        linkedList = new LinkedList<>();
    }

    @Override
    protected List getList() {
        return new LinkedList();
    }
}
