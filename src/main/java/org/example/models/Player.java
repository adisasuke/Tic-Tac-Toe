package org.example.models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PLAYERTYPE playertype;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.playertype = PLAYERTYPE.PLAYER;
    }

    public Move makeMove() {
        int row;
        int col;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row ");
        row = scanner.nextInt();
        System.out.println("Enter col ");
        col = scanner.nextInt();

        return new Move(row, col);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PLAYERTYPE getPlayertype() {
        return playertype;
    }

    public void setPlayertype(PLAYERTYPE playertype) {
        this.playertype = playertype;
    }
}
