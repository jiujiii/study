package com.data_structure.impl.linearlist;

/**
 * <p>
 * 静态链表
 * <ul>
 *     <li>eles[0],eles[eles.length-1]两个节点为辅助节点，不实际存数据</li>
 *     <li>eles[0]的游标始终指向空闲节点的数组下标</li>
 *     <li>eles[eles.length-1]无元素时指向下标0，有元素时指向第一个元素</li>
 *     <li>游标为0的元素为链表最后一个元素</li>
 * </ul>
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/4 10:21
 */
public class StaticLink<T> implements ILinearList<T> {

    private static final int DEFAULT_SIZE = 12;

    private final Element[] eles;

    private int count = 0;

    private static class Element<T> {
        public T data;
        private int cur;

        public Element(T t,
                       int cur) {
            this.data = t;
            this.cur = cur;
        }
    }

    public StaticLink() {
        eles = new Element[DEFAULT_SIZE];
        for (int i = 0; i < eles.length; i++) {
            eles[i] = new Element(
                    null,
                    i + 1
            );
        }
        eles[eles.length - 1].cur = 0;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clearList() {
        eles[0].cur = 1;
        eles[eles.length - 1].cur = 0;
        count = 0;
    }

    @Override
    public T get(int index) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int eCount = 0;
        int eCur = eles[eles.length - 1].cur;
        while (eCur != 0) {
            eCount++;
            if (eCount == index + 1) {
                return (T) eles[eCur].data;
            }
            eCur = eles[eCur].cur;
        }
        return null;
    }

    @Override
    public int indexOf(T t) {
        int index = -1;
        int eCur = eles[eles.length - 1].cur;
        while (eCur != 0) {
            index++;
            Element e = eles[eCur];
            if (e.data.equals(t)) {
                return index;
            }
            eCur = eles[eCur].cur;
        }
        return -1;
    }

    @Override
    public void listInsert(int index,
                           T t) {
        if (index > count || index < 0) {
            // 确定索引范围
            throw new IndexOutOfBoundsException();
        }
        if (count >= eles.length - 2) {
            // 链表已满
            throw new IndexOutOfBoundsException();
        }
        count++;
        // 拿到空闲的下标
        int unUsedIndex = eles[0].cur;
        // 更新第一个元素的游标指向新的空闲元素
        eles[0].cur = eles[unUsedIndex].cur;
        // 插入的索引为0
        int firstElementIndex = eles[eles.length - 1].cur;
        if (firstElementIndex == 0) {
            eles[1] = new Element(t, 0);
            eles[eles.length - 1].cur = 1;
        } else {
            int cur = firstElementIndex;
            for (int i = 0; i < index; i++) {
                cur = eles[cur].cur;
            }
            Element eTarget = eles[cur];
            if (index == count) {
                // 在尾部插入
                eles[unUsedIndex] = new Element(t, 0);
                eTarget.cur = unUsedIndex;
            } else if (index == 0) {
                //  在头部插入
                eles[unUsedIndex] = new Element(t, cur);
                eles[eles.length - 1].cur = unUsedIndex;
            } else {
                // 在中间插入
                int curBefore = 0;
                for (int i = 0; i < index - 1; i++) {
                    curBefore = eles[cur].cur;
                }
                eles[curBefore].cur = unUsedIndex;
                eles[unUsedIndex] = new Element(t, cur);
            }
        }
    }

    @Override
    public void listDelete(int index) {
        if (index > count - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int firstElementIndex = eles[eles.length - 1].cur;
        count--;
        if (index == count) {
            // 尾部删
            int curBefore = firstElementIndex;
            for (int i = 0; i < index - 1; i++) {
                curBefore = eles[curBefore].cur;
            }
            eles[curBefore].cur = 0;
            int curTarget = eles[curBefore].cur;
            eles[curTarget].cur = eles[0].cur;
            eles[0].cur = curTarget;
        } else if (index == 0) {
            //头部删
            int curTarget = eles[eles.length - 1].cur;
            int nextTarget = eles[curTarget].cur;
            eles[0].cur = curTarget;
            eles[eles.length - 1].cur = nextTarget;
        } else {
            //中间删
            int curBefore = firstElementIndex;
            for (int i = 0; i < index - 1; i++) {
                curBefore = eles[curBefore].cur;
            }
            int curTarget = eles[curBefore].cur;
            eles[curBefore].cur = eles[curTarget].cur;
        }
    }

    @Override
    public int listLength() {
        return count;
    }
}
