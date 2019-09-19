package com.pattern.memento.standard;

class Memento {

    private String state;

    Memento(Originator o){
        this.state = o.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
