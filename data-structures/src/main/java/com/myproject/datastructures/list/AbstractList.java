package com.myproject.datastructures.list;

public abstract class AbstractList<T> implements List<T> {
    public abstract void add(T value);
    public abstract void add(T value, int index);
    public abstract T remove(int index);
    public abstract T get(int index);
    public abstract T set(T value, int index);
    public abstract void clear();
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract boolean contains(T value);
    public abstract int indexOf(T value);
    public abstract int lastIndexOf(T value);
    public abstract String toString();
}
