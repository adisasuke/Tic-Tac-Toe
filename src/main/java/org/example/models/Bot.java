package org.example.models;

public class Bot extends Player{

    public Bot(String name, Symbol symbol) {
        super(name, symbol);
        this.setPlayertype(PLAYERTYPE.BOT);
    }


}
