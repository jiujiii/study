package com.pattern.memento;

import com.pattern.memento.standard.Caretaker;
import com.pattern.memento.standard.Originator;
import org.junit.Test;

public class MementoTest {

    @Test
    public void standard(){
        Originator originator = new Originator("state 1");
        System.out.println(originator.getState());

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState("state 2");
        System.out.println(originator.getState());

        originator.restoreMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }

}
