package org.example.strategies;

import org.example.models.Cell;
import org.example.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    private Map<Integer, HashMap<Symbol,Integer>> mp;
    private int dimension;

    public RowWinningStrategy(int dimension) {
        this.dimension = dimension;
        mp = new HashMap<>();
    }

//    public void update(int row, int col, Symbol symbol) {
//        // If the row does not exist in the map, initialize it
//        if (!mp.containsKey(row)) {
//            mp.put(row, new HashMap<>());
//        }
//
//        // Get the map for the current row
//        HashMap<Symbol, Integer> rowMap = mp.get(row);
//
//        // Update the count for the symbol
//        rowMap.put(symbol, rowMap.getOrDefault(symbol, 0) + 1);
//    }

    public void update(int row, int col, Symbol symbol)
    {
        if(mp.get(row) == null)
        {
            mp.put(row, new HashMap<>());
            mp.get(row).put(symbol, 1);
        }
        else{
            mp.get(row).put(symbol, mp.get(row).getOrDefault(symbol,0) + 1);
            int count = mp.get(row).get(symbol);
        }

    }

    public boolean checkWinner(int row, int col, Symbol symbol)
    {
        int sz = mp.get(row).get(symbol);
        return mp.get(row).get(symbol) == dimension;
    }
}
