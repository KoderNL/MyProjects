package com.myproject.datastructures.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @Test
    public void testLinkedListIsEmptyAfterInitialization() {
        Assertions.assertTrue(list.isEmpty());
    }
}
