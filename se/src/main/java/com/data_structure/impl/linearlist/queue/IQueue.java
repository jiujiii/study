package com.data_structure.impl.linearlist.queue;

public interface IQueue<T> {

    boolean isEmpty();

    void enQueue(T t);

    T deQueue();

    int length();

}
