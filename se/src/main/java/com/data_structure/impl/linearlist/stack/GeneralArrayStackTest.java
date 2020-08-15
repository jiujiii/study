package com.data_structure.impl.linearlist.stack;

import com.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralArrayStackTest {

    final GeneralArrayStack<Node> nodeGeneralArrayStack = new GeneralArrayStack<>();

    @Before
    public void demo1(){
        for (int i = 0; i < 12; i++) {
            nodeGeneralArrayStack.push(new Node(i));
        }
        assertEquals(nodeGeneralArrayStack.size(),12);
    }

    @Test
    public void demo2(){
        assertEquals(nodeGeneralArrayStack.peek().value(),11);
        nodeGeneralArrayStack.pop();
        nodeGeneralArrayStack.pop();
        assertEquals(nodeGeneralArrayStack.peek().value(),9);
    }

}