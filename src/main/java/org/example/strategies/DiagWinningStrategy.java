package org.example.strategies;

import org.example.models.Symbol;

public class DiagWinningStrategy implements WinningStrategy{

    @Override
    public void update(int row, int col, Symbol symbol) {

    }

    @Override
    public boolean checkWinner(int row, int col, Symbol symbol) {
        return false;
    }

    @Override
    public void undo(int row, int column, Symbol symbol) {

    }
}
