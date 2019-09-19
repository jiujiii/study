package com.pattern.memento.ex1;

import java.util.ArrayList;
import java.util.List;

public class ChessMemento {

    private List<ChessMan> chessMans;

    ChessMemento(){
        chessMans = new ArrayList<>();
    }

    void add(ChessMan chessMan){
        chessMans.add(chessMan);
    }

    public ChessMan pop(ChessMan chessMan){
        ChessMan pop = chessMans.get(chessMans.size() - 1);
        chessMans.remove(pop);
        return pop;
    }
}
