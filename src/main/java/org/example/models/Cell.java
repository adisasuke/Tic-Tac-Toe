package org.example.models;

public class Cell {

    private int row;
    private int col;
    private CELLTYPE celltype = CELLTYPE.EMPTY;
    private Player player=null;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void print()
    {
        if(getCelltype() == CELLTYPE.EMPTY)
        {
            System.out.print(" | _ | ");
        }
        else
        {
            Symbol s = getPlayer().getSymbol();
            System.out.print(" | "  + s.getSymbol() + " | ");
        }
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CELLTYPE getCelltype() {
        return celltype;
    }

    public void setCelltype(CELLTYPE celltype) {
        this.celltype = celltype;
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

}
