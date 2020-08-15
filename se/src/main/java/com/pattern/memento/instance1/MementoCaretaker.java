package com.pattern.memento.instance1;

import java.util.ArrayList;

public class MementoCaretaker {

    private ArrayList<ChessmanMemento> mementolist = new ArrayList<>();

    public ChessmanMemento getMemento(int i){
        return mementolist.get(i);
    }

}
