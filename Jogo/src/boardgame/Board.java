package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns){
        if(rows < 1 || columns < 1){
            throw new BoardException("Erro criando tabuleiro: é necessário ao menos 1 linha e uma coluna!");
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


    public Piece piece(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("ERRO: Posição não existente no tabuleiro!");
        }
        return pieces[row][column];
    }

    //sobrecarga//
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("ERRO: Posição não existente no tabuleiro!");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw  new BoardException("Erro: Já tem uma peça na posição " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;

    }

    public Piece removePiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Posição não encontrada no tabuleiro!");
        }
        if (piece(position) == null){
            return null;
        }

        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    // testa se a posição existe
    public boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    // testa se tem uma peça nesta posição, e testa se aposição existe
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("ERRO: Posição não existente no tabuleiro!");
        }
        return piece(position) != null;
    }
}
