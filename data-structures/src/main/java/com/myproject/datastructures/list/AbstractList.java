package com.myproject.datastructures.list;

public abstract class AbstractList<T> implements List<T> {
    private int size;
    @Override
    public void add(T value) {
        add(value, size);
    }

}
