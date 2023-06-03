package com.myproject.datastructures.stack;

public interface Stack {
   void push(Object value);
   Object pop();
   int size();
   void clear();
   Object peek();
   boolean contains(Object value);
   boolean isEmpty();
}
