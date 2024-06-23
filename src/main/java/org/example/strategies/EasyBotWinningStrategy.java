package org.example.strategies;

import org.example.models.Board;
import org.example.models.CELLTYPE;
import org.example.models.Cell;
import org.example.models.Move;

import java.util.List;

public class EasyBotWinningStrategy implements BotWinningStrategy {

    @Override
    public Move makeMove(Board board) {
        List<List<Cell>> cells = board.getCells();

        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if(cell.getCelltype() == CELLTYPE.EMPTY)
                {
                    return new Move(cell.getRow(),cell.getCol());
                }
            }
        }
        return null;
    }

}
