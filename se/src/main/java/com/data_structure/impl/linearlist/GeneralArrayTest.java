package com.data_structure.impl.linearlist;

import com.Node;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GeneralArrayTest {

    private GeneralArray<Node> gan;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void init(){
        gan = new GeneralArray<>();
    }

    @Test
    public void isEmpty() {
        assertEquals(gan.isEmpty(),true);
    }

    @Test
    public void clearList() {
        gan.listInsert(0,new Node(1));
        gan.clearList();
        assertEquals(gan.isEmpty(),true);
    }

    @Test
    public void get() {
        gan.listInsert(0,new Node(1));
        assertEquals(gan.get(0),new Node(1));
    }

    @Test
    public void indexOf() {
        gan.listInsert(0,new Node(1));
        assertEquals(gan.indexOf(new Node(1)),0);
    }

    @Test
    public void listInsertForException() {
        expectedEx.expect(ArrayIndexOutOfBoundsException.class);
        gan.listInsert(-1,new Node());
    }

    @Test
    public void listInsert() {
        gan.listInsert(gan.listLength(),new Node(1));
        assertEquals(gan.get(0).value(),1);
    }

    @Test
    public void listDelete() {
        gan.listInsert(gan.listLength(),new Node(1));
        gan.listDelete(0);
        assertEquals(gan.listLength(),0);
    }

    @Test
    public void listLength() {
        gan.listInsert(gan.listLength(),new Node(1));
        assertEquals(gan.listLength(),1);
    }

    @Test
    public void resize(){
        gan.listInsert(gan.listLength(),new Node(1));
        gan.listInsert(gan.listLength(),new Node(2));
        gan.listInsert(gan.listLength(),new Node(3));
        gan.listInsert(gan.listLength(),new Node(4));
        gan.listInsert(gan.listLength(),new Node(5));
        gan.listInsert(gan.listLength(),new Node(6));
        gan.listInsert(gan.listLength(),new Node(7));
        gan.listInsert(gan.listLength(),new Node(8));
        gan.listInsert(gan.listLength(),new Node(9));
        gan.listInsert(gan.listLength(),new Node(10));
        gan.listInsert(gan.listLength(),new Node(11));
        gan.listInsert(gan.listLength(),new Node(12));
    }
}