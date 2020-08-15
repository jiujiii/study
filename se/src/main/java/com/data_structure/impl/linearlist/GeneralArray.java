package com.data_structure.impl.linearlist;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/6/25 11:48
 */
public class GeneralArray<E> implements ILinearList<E> {

    /**
     * 初始数组默认大小
     */
    private final static int DEFAULT_SIZE = 12;

    /**
     * 元素内容
     */
    private E[] eles;

    /**
     * 元素个数
     */
    private int count;

    public GeneralArray() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public GeneralArray(int capacity) {
        this.eles = (E[]) new Object[capacity];
        this.count = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clearList() {
        this.eles = (E[]) new Object[eles.length];
        this.count = 0;
    }

    @Override
    public E get(int index) {
        checkQueryIndex(index);
        return eles[index];
    }

    @Override
    public int indexOf(E t) {
        for (int i = 0; i < this.count; i++) {
            E ele = eles[i];
            if (ele.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void listInsert(int index,
                           E t) {
        checkInsertIndex(index);
        grow();
        for (int i = this.count - 1; i >= index; i--) {
            eles[i + 1] = eles[i];
        }
        eles[index] = t;
        this.count++;
    }

    @Override
    public void listDelete(int index) {
        checkQueryIndex(index);
        for (int i = index; i < this.count; i++) {
            eles[i] = eles[i + 1];
        }
        this.count--;
    }

    @Override
    public int listLength() {
        return this.count;
    }

    private void grow() {
        if (this.count > eles.length * 0.75) {
            eles = Arrays.copyOf(eles,eles.length * 4 / 3);
        }
    }

    private void checkQueryIndex(int index) {
        // 0 ~ count - 1
        if (index > this.count - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void checkInsertIndex(int index) {
        // 0 ～ count
        if (index > this.count || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
