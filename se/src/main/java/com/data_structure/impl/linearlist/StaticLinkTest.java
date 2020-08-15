package com.data_structure.impl.linearlist;

import com.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaticLinkTest {

    private StaticLink<Node> sl = null;

    @Before
    public void init(){
        sl = new StaticLink<>();
    }

    @Test
    public void isEmpty() {
        assertTrue(sl.isEmpty());
        sl.listInsert(0,new Node(0));
        assertFalse(sl.isEmpty());
    }

    @Test
    public void clearList() {
        assertTrue(sl.isEmpty());
        sl.listInsert(0,new Node(0));
        sl.clearList();
        assertTrue(sl.isEmpty());
    }

    @Test
    public void get() {
        sl.listInsert(0,new Node(0));
        assertEquals(sl.get(0).value(),0);
    }

    @Test
    public void indexOf() {
        sl.listInsert(0,new Node(0));
        assertEquals(sl.indexOf(new Node(0)),0);
    }

    @Test
    public void listInsert() {
        assertTrue(sl.isEmpty());
        sl.listInsert(0,new Node(0));
        assertFalse(sl.isEmpty());
    }

    @Test
    public void listDelete() {
        assertTrue(sl.isEmpty());
        sl.listInsert(0,new Node(0));
        sl.listDelete(0);
        assertTrue(sl.isEmpty());
    }

    @Test
    public void listLength() {
        sl.listInsert(0,new Node(0));
        assertEquals(sl.listLength(),1);
    }
}