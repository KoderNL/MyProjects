package com.myproject.datastructures.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest extends AbstractListTest {
    private LinkedList linkedList;
    @BeforeEach
    protected void setUp() { //Этот метод будет вызываться перед каждым тестовым методом
        linkedList = new LinkedList();
    }
    @Override
    protected List getList() {
        return new LinkedList();
    }

    @DisplayName("Linked list is empty after initialization")
    @Test
    public void testLinkedListIsEmptyAfterInitialization() {
        Assertions.assertTrue(linkedList.isEmpty());
    }
}
