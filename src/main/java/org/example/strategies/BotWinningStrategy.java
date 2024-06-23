package org.example.strategies;

import org.example.models.Board;
import org.example.models.Move;

public interface BotWinningStrategy {
    Move makeMove(Board board);
}
