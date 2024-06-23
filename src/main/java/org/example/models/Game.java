package org.example.models;

import org.example.exception.InvalidRowAndColumn;
import org.example.strategies.ColWinningStrategy;
import org.example.strategies.DiagWinningStrategy;
import org.example.strategies.RowWinningStrategy;
import org.example.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Game {

    private Player winner;
    private GAMESTATUS gamestatus;
    private Board board;
    private List<Player> players;
    private int nextPlayerIndex;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;

    //Todo : Take dimension and initiate board
    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {

        gamestatus = GAMESTATUS.INPROGRESS;

        this.players = players;
        this.board = new Board(dimension);
        this.winningStrategies = winningStrategies;
        this.nextPlayerIndex = 0;
        this.moves = new ArrayList<>();
        board.print();
    }

    public void undo() {

        if(moves.size() == 0) {
            System.out.println("Nothing to undo");
            return;
        }

        Move m = moves.get(moves.size() - 1);
        moves.remove(moves.size() - 1);
        Cell cell = board.getCells().get(m.getRow()).get(m.getColumn());


        int row = cell.getRow();
        int col = cell.getCol();
        Symbol symbol = cell.getPlayer().getSymbol();
        for(WinningStrategy strategy : winningStrategies) {
            strategy.undo(row, col, symbol);
        }

        cell.setCelltype(CELLTYPE.EMPTY);
        cell.setPlayer(null);
        nextPlayerIndex = (nextPlayerIndex -1 + players.size())%players.size();
    }


    public static class Builder
    {
        int dimension;
        List<Player> players;
        List<WinningStrategy> winningStrategies;

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Game build() {
            return new Game(dimension, players, winningStrategies);
        }

    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    private boolean validate(int x,int y)
    {
        int n = board.getDimension();
        Cell cell = board.getCells().get(x).get(y);

        if(x<0 || x>=n || y<0 || y>=n)
            return false;
        if(cell.getCelltype() == CELLTYPE.FILLED)
            return false;

        return true;
    }

    public void makeMove() {

        if(gamestatus == GAMESTATUS.COMPLETED)
        {
            System.out.println("Game Over");
            return;
        }


        Player p = players.get(nextPlayerIndex);
        System.out.println("Player "+p.getName()+" turn with symbol "+ p.getSymbol().getSymbol());





        Move mv = p.makeMove(board);

        int row = mv.getRow();
        int col = mv.getColumn();

        if(!validate(row, col))
        {
            System.out.println("Invalid row or col");
            throw new InvalidRowAndColumn();
        }

        Cell cell = board.getCells().get(row).get(col);
        cell.setPlayer(p);
        cell.setCelltype(CELLTYPE.FILLED);

        for(WinningStrategy strategy : winningStrategies)
        {
            strategy.update(row, col, p.getSymbol());
        }

        moves.add(mv);
        checkWinning();
        board.print();
        nextPlayerIndex++;
        nextPlayerIndex %= players.size();
    }

    private boolean checkWinning() {

        int index = moves.size()-1;

        Move mv = moves.get(index);
        int row = mv.getRow();
        int col = mv.getColumn();
        Symbol symbol = board.getCells().get(row).get(col).getPlayer().getSymbol();

        for(WinningStrategy strategy : winningStrategies)
        {
            if(strategy.checkWinner(row, col, symbol))
            {
                winner = board.getCells().get(row).get(col).getPlayer();
                System.out.println("Player "+winner.getName()+" won");
                gamestatus = GAMESTATUS.COMPLETED;
                return true;
            }

        }
        return false;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GAMESTATUS getGamestatus() {
        return gamestatus;
    }

    public void printBoard() {
        board.print();
    }

    public void setGamestatus(GAMESTATUS gamestatus) {
        this.gamestatus = gamestatus;
    }

}
