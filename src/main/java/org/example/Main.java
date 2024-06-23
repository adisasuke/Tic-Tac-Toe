package org.example;

import org.example.controller.GameContoller;
import org.example.exception.DuplicateSymbolException;
import org.example.exception.InvalidBotCount;
import org.example.exception.InvalidRowAndColumn;
import org.example.models.*;
import org.example.strategies.ColWinningStrategy;
import org.example.strategies.DiagWinningStrategy;
import org.example.strategies.RowWinningStrategy;
import org.example.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InvalidBotCount, InvalidRowAndColumn, DuplicateSymbolException {
        System.out.println("Tic Tac Toe");
        System.out.println("**********************************************************");

        int dimension = 3;

        Symbol s1 = new Symbol('X');
        Symbol s2 = new Symbol('O');
        Player p1 = new Player("Adi",s1,PLAYERTYPE.PLAYER);
        Player p2 = new Bot("Kim",s2, BOTLEVEL.EASY);
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);

        List<WinningStrategy> strategies = new ArrayList<>();
        strategies.add(new RowWinningStrategy(dimension));
        strategies.add(new ColWinningStrategy(dimension));
        strategies.add(new DiagWinningStrategy(dimension));


        GameContoller gameContoller = new GameContoller();
        Game game = gameContoller.startGame(dimension, players, strategies);

        while(game.getGamestatus() == GAMESTATUS.INPROGRESS)
        {
            System.out.println("Do you want to undo? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("Y"))
            {
                game.undo();
                game.printBoard();
                continue;
            }

            game.makeMove();
        }

    }
}