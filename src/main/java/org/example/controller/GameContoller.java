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



    //Todo : Take dimension players and strategy list all in this function only
    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> strategies)
    {

        return new Game(dimension, players, strategies);

    }


    //Todo : take input and validate input and then pass to the game
    public void makeMove(Game game)
    {
        game.makeMove();
    }



}
