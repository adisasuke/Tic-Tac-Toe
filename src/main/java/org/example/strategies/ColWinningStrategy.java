package org.example.strategies;

import org.example.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{

    private Map<Integer, HashMap<Symbol,Integer>> mp;
    private int dimension;

    public ColWinningStrategy(int dimension) {
        this.dimension = dimension;
        mp = new HashMap<>();
    }

    public void update(int row, int col, Symbol symbol)
    {
        if(mp.get(col) == null)
        {
            mp.put(col, new HashMap<>());
            mp.get(col).put(symbol, 1);
        }
        else{
            mp.get(col).put(symbol, mp.get(col).getOrDefault(symbol,0) + 1);
        }

    }

    public boolean checkWinner(int row, int col, Symbol symbol)
    {
        return mp.get(col).get(symbol) == dimension;
    }

    public void undo(int row, int col, Symbol symbol)
    {
     mp.get(col).put(symbol, mp.get(col).getOrDefault(symbol,0) - 1);
    }
}
