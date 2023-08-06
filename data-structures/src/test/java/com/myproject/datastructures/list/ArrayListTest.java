package com.myproject.datastructures.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest extends AbstractListTest {
    private ArrayList arrayList;

    @BeforeEach
    protected void setUp() { //Этот метод будет вызываться перед каждым тестовым методом
        arrayList = new ArrayList();
    }

    @Override
    protected List getList() {
        return new ArrayList();
    }

    @DisplayName("Constructor with custom initial capacity less zero throw IllegalArgumentException")
    @Test
    public void testConstructorWithCustomInitialCapacityLessZeroThrowIllegalArgumentException() {
        illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            arrayList = new ArrayList(-1);
        });
        assertEquals("Invalid capacity: -1",illegalArgumentException.getMessage());
    }

    @DisplayName("Constructor with default initial capacity work correctly")
    @Test
    public void testConstructorWithDefaultInitialCapacityWorkCorrectly() {
        assertEquals(2, arrayList.getCapacity());
    }
}
