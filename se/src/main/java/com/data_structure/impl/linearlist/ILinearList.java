package com.data_structure.impl.linearlist;

public interface ILinearList<E> {

    /**
     * 是否为空
     * @return false 不为空，true 为空
     */
    boolean isEmpty();

    /**
     * 清空线性表
     */
    void clearList();

    /**
     * 返回指定位置的元素
     */
    E get(int index);

    /**
     * 返回元素所在的位置
     * @return 0 表示不存在
     */
    int indexOf(E t);

    /**
     * 在指定位置插入元素
     */
    void listInsert(int index,E t);

    /**
     * 删除指定位置的元素
     */
    void listDelete(int index);

    /**
     * 返回线性表元素个数
     */
    int listLength();
}
