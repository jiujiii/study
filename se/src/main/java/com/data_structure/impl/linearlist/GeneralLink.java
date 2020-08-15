package com.data_structure.impl.linearlist;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/6/28 17:43
 */
public class GeneralLink<E> implements ILinearList<E> {

    private int count;

    private Node<E> head;

    public GeneralLink() {
        head = new Node<>();
        count = 0;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clearList() {
        head = new Node<>();
        count = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        checkQueryIndex(index);
        Node n = head.next;
        for (int i = 1; i <= index; i++) {
            n = n.next;
        }
        return (E) n.value;
    }

    @Override
    public int indexOf(E t) {
        Node n = head.next;
        if (n.value.equals(t)) {
            return 0;
        }
        for (int i = 1; i < this.count; i++) {
            n = n.next;
            if (n.value.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void listInsert(int index,
                           E t) {
        checkInsertIndex(index);
        Node n = this.head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        Node next = n.next;
        n.next = new Node<>(
                t,
                next
        );
        count++;
    }

    @Override
    public void listDelete(int index) {
        checkQueryIndex(index);
        Node n = this.head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        if (this.count - 1 == index) {
            n.next = null;
        } else {
            n.next = n.next.next;
        }
        count--;
    }

    @Override
    public int listLength() {
        return this.count;
    }

    private class Node<E> {

        private E value;

        private Node next;

        public Node(E value,
                    Node next) {
            this.value = value;
            this.next = next;
        }

        public Node() {
            this.value = null;
            this.next = null;
        }
    }

    private void checkQueryIndex(int index) {
        // 0 ~ count - 1
        if (index > this.count - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkInsertIndex(int index) {
        // 0 ～ count
        if (index > this.count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

}
