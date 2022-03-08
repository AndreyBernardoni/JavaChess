package board;

public class Board {
    private int rows, columns;
    private Piece[][] pieces;


    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Erro na criação do tabuleiro: valores de linhas e colunas devem ser maiores que 0.");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }
    public int getColumns() {
        return columns;
    }
    public int getRows() {
        return rows;
    }

    public Piece piece (int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Posição não existe no tabuleiro.");
        }
        return pieces[row][column];
    }

    public Piece piece (Position position){
        if (!positionExists(position)) {
            throw new BoardException("Posição não existe no tabuleiro.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)) {
            throw new BoardException("Já existe uma peça nessa posição.");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    private boolean positionExists(int row, int column){
            return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Posição não existe no tabuleiro.");
        }
        return piece(position) != null;
    }
}
