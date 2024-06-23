package org.example.models;

import org.example.strategies.BotWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bot extends Player{

    private final BotWinningStrategy botWinningStrategy;

    public Bot(String name, Symbol symbol, BOTLEVEL botlevel) {
        super(name, symbol);
        this.setPlayertype(PLAYERTYPE.BOT);
        botWinningStrategy = BotFactory.createBotWinningStrategy(botlevel);
    }

    @Override
    public Move makeMove(Board board) {
        return botWinningStrategy.makeMove(board);
    }

}
