package com.data_structure.impl.linearlist;

import com.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralLinkTest {

    public GeneralLink<Node> gln;

    @Before
    public void init(){
        gln = new GeneralLink<>();
    }


    @Test
    public void isEmpty() {
        assertTrue(gln.isEmpty());
    }

    @Test
    public void clearList() {
        gln.listInsert(0,new Node(0));
        gln.clearList();
        assertTrue(gln.isEmpty());
        gln.listInsert(0,new Node(0));
        assertFalse(gln.isEmpty());
    }

    @Test
    public void get() {
        gln.listInsert(0,new Node(0));
        gln.listInsert(1,new Node(1));
        assertEquals(gln.get(1).value(),1);
        assertEquals(gln.get(0).value(),0);
    }

    @Test
    public void indexOf() {
        gln.listInsert(0,new Node(0));
        gln.listInsert(1,new Node(1));
        assertEquals(gln.indexOf(new Node(1)),1);
        assertEquals(gln.indexOf(new Node(0)),0);
    }

    @Test
    public void listInsert() {
        gln.listInsert(0,new Node(0));
        gln.listInsert(1,new Node(1));
        assertFalse(gln.isEmpty());
    }

    @Test
    public void listDelete() {
        gln.listInsert(0,new Node(0));
        gln.listInsert(1,new Node(1));
        gln.listDelete(0);
        assertEquals(gln.get(0).value(),1);
    }

    @Test
    public void listLength() {
        gln.listInsert(0,new Node(0));
        assertEquals(gln.listLength(),1);
    }
}