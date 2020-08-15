package com.data_structure.impl.linearlist.stack;

import com.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralLinkStackTest {

    public GeneralLinkStack<Node> glsn;

    @Before
    public void init(){
        glsn = new GeneralLinkStack<>();
    }

    @Test
    public void push() {
        assertTrue(glsn.push(new Node(1)));
        assertTrue(glsn.push(new Node(2)));
        assertTrue(glsn.push(new Node(3)));
    }

    @Test
    public void pop() {
        glsn.push(new Node(1));
        glsn.push(new Node(2));
        glsn.push(new Node(3));
        assertTrue(glsn.pop());
        assertTrue(glsn.pop());
        assertTrue(glsn.pop());
        assertFalse(glsn.pop());
        assertFalse(glsn.pop());
    }

    @Test
    public void peek() {
        glsn.peek();
        glsn.push(new Node(1));
        assertEquals(glsn.peek().value(),1);
        glsn.pop();
        glsn.pop();
        assertNull(glsn.peek());
    }
}