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
                cell.print();
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
