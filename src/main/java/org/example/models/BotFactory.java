package org.example.models;

import org.example.strategies.BotWinningStrategy;
import org.example.strategies.EasyBotWinningStrategy;
import org.example.strategies.HardBotWinningStrategy;
import org.example.strategies.MediumBotWinningStrategy;

public class BotFactory {

    public static BotWinningStrategy createBotWinningStrategy(BOTLEVEL botlevel) {

        switch (botlevel) {
            case EASY -> {
                return new EasyBotWinningStrategy();
            }
            case MEDIUM -> {
                return new MediumBotWinningStrategy();
            }
            case HARD -> {
                return new HardBotWinningStrategy();
            }
        }

        return null;
    }
}
