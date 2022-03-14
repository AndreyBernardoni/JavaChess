package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "T";
    }

    @Override
    public boolean[][] possibleMoves(){
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        Position p = new Position(0,0);

        p.setValues(position.getRow() - 1 , position.getColumn());

        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        return mat;
    }

    
}
