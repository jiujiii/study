package com.pattern.memento.instance1;

import lombok.Data;

@Data
public class Chessman {

    private String label;

    private int x;

    private int y;

    public ChessmanMemento save(){
        return new ChessmanMemento(this.label,this.x,this.y);
    }

}
