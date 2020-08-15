package com.data_structure.impl.linearlist.stack;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/6/19 18:36
 */
public class GeneralArrayStack<T> implements Stack<T> {

    private final static int DEFAULT_SIZE = 12;

    private Object[] t;

    private int top = 0;

    public GeneralArrayStack(T[] t) {
        this.t = t;
    }

    public GeneralArrayStack() {
        this.t = new Object[DEFAULT_SIZE];
    }

    public boolean push(T t) {
        this.grow();
        this.t[top++] = t;
        return true;
    }

    public boolean pop() {
        this.t[--top] = null;
        return true;
    }

    public T peek(){
        return (T) t[top-1];
    }

    public void grow(){
        if(t.length * 0.75 < top){
            t = Arrays.copyOf(t,t.length * 4 / 3);
        }
    }

    public int size(){
        return top;
    }
}
