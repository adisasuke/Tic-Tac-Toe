package org.example.strategies;

import org.example.models.Symbol;

import java.util.HashMap;
import java.util.Map;


public class DiagWinningStrategy implements WinningStrategy{

    private Map<Symbol, Integer> leftdiag;
    private Map<Symbol, Integer> rightdiag;
    private int dimension;

    public DiagWinningStrategy(int dimension) {
        leftdiag = new HashMap<>();
        rightdiag = new HashMap<>();
        this.dimension = dimension;
    }


    @Override
    public void update(int row, int col, Symbol symbol) {


        if(row == col)
        {
            leftdiag.put(symbol, leftdiag.getOrDefault(symbol, 0) + 1);
        }
        if(row + col == dimension-1){
            rightdiag.put(symbol, rightdiag.getOrDefault(symbol, 0) + 1);
        }


    }


    @Override
    public boolean checkWinner(int row, int col, Symbol symbol) {

        if(row == col) {
            if(leftdiag.get(symbol) == dimension) {
                return true;
            }
        }

        if(row + col == dimension - 1) {
            if(rightdiag.get(symbol) == dimension) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void undo(int row, int column, Symbol symbol) {

        if(row == column)
        {
            leftdiag.put(symbol, leftdiag.getOrDefault(symbol, 0) - 1);
        }

        if(row + column == dimension-1){
            rightdiag.put(symbol, rightdiag.getOrDefault(symbol, 0) - 1);
        }

    }
}

