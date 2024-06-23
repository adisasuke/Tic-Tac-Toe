package org.example.controller;

import org.example.models.GAMESTATUS;
import org.example.models.Game;
import org.example.models.Player;
import org.example.models.Symbol;
import org.example.strategies.ColWinningStrategy;
import org.example.strategies.DiagWinningStrategy;
import org.example.strategies.RowWinningStrategy;
import org.example.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GameContoller {


    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> strategies)
    {

        return Game.getBuilder().setDimension(dimension).setPlayers(players).setWinningStrategies(strategies).build();

    }


    public void makeMove(Game game)
    {
        game.makeMove();
    }


    public GAMESTATUS checkState(Game game) {
        return game.getGamestatus();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void undo(Game game) {
        game.undo();
        printBoard(game);
    }

}
