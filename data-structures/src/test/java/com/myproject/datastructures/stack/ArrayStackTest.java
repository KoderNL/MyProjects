package com.myproject.datastructures.stack;

public class ArrayStackTest extends AbstractStackTest {

    @Override
    protected Stack getStack() {
        return new ArrayStack(10);
    }
}
