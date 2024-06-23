package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Cell>> cells;
    private int dimension;

    public Board(int dimension) {
        this.dimension = dimension;

        cells = new ArrayList<>();

        for(int i=0;i<dimension;i++) {
            List<Cell> row = new ArrayList<>();
            for(int j=0;j<dimension;j++) {
                row.add(new Cell(i, j));
            }
            cells.add(row);
        }

    }

    public void print()
    {
        for(int i=0;i<dimension;i++)
        {
            for(int j=0;j<dimension;j++)
            {
                Cell cell = cells.get(i).get(j);
                if(cell.getCelltype() == CELLTYPE.EMPTY)
                {
                    System.out.print("_" + " ");
                }
                else
                {
                    Symbol s = cells.get(i).get(j).getPlayer().getSymbol();
                    System.out.print(s.getSymbol() + " ");
                }
            }
            System.out.println();
        }

        System.out.println("**********************************************************************");
    }



    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }
}
