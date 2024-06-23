package org.example;

import org.example.controller.GameContoller;
import org.example.models.GAMESTATUS;
import org.example.models.Game;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        GameContoller gameContoller = new GameContoller();
        Game game = gameContoller.startGame();

        while(game.getGamestatus() == GAMESTATUS.INPROGRESS)
        {
            game.makeMove();
        }

    }
}