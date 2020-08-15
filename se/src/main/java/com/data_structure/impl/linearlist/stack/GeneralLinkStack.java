package com.data_structure.impl.linearlist.stack;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/6/22 15:43
 */
public class GeneralLinkStack<T> implements Stack<T> {

    private Node<T> top;

    public GeneralLinkStack() {
    }

    @Override
    public boolean push(T t) {
        top = new Node<>(
                t,
                top
        );
        return true;
    }

    @Override
    public boolean pop() {
        if (top == null) {
            return false;
        } else {
            top = top.next;
            return true;
        }
    }

    @Override
    public T peek() {
        return top == null ? null : top.t;
    }

    private static class Node<T> {
        private T t;
        private Node<T> next;

        public Node(T t,
                    Node<T> next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
            this(
                    t,
                    null
            );
        }
    }
}
