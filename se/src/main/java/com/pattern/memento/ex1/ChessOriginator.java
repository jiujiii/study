package com.pattern.memento.ex1;

public class ChessOriginator {

    private ChessMan chessMan;

    private ChessMemento chessMemento;

    public ChessOriginator(ChessMan chessMan, ChessMemento chessMemento) {
        this.chessMan = chessMan;
        this.chessMemento = chessMemento;
    }

    public void createMemento(){
        this.chessMemento = new ChessMemento();
        chessMemento.add(this.chessMan);
    }

}
