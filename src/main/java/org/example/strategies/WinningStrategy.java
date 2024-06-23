package org.example.strategies;

import org.example.models.Game;
import org.example.models.Symbol;

public interface WinningStrategy {
    void update(int row, int col, Symbol symbol);
    boolean checkWinner(int row, int col, Symbol symbol);
}
