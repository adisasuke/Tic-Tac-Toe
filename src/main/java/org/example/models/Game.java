package org.example.models;

import org.example.exception.InvalidRowAndColumn;
import org.example.strategies.ColWinningStrategy;
import org.example.strategies.DiagWinningStrategy;
import org.example.strategies.RowWinningStrategy;
import org.example.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
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
    public Game() {

        int dimension = 3;
        List<Player> players = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        gamestatus = GAMESTATUS.INPROGRESS;

        Symbol s = new Symbol('X');
        Symbol o = new Symbol('O');
        Player p1 = new Player("Adi",s);
        Player p2 = new Bot("Kim",o,BOTLEVEL.EASY);
        players.add(p1);
        players.add(p2);
        WinningStrategy w1 = new ColWinningStrategy(dimension);
        WinningStrategy w2 = new RowWinningStrategy(dimension);
//        WinningStrategy w3 = new DiagWinningStrategy();
        winningStrategies.add(w1);
        winningStrategies.add(w2);
//        winningStrategies.add(w3);


        this.players = players;
        this.board = new Board(dimension);
        this.winningStrategies = winningStrategies;
        this.nextPlayerIndex = 0;
        this.moves = new ArrayList<>();
        board.print();
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

    public void setGamestatus(GAMESTATUS gamestatus) {
        this.gamestatus = gamestatus;
    }

}
