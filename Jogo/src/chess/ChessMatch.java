package chess;

import boardgame.Board;
import boardgame.Position;
import chess.piece.King;
import chess.piece.Rook;

public class ChessMatch {

   private Board board;
   public ChessMatch(){
      board = new Board(8, 8);
      inicialSetup();
   }



// metodo que retorn a matriz de peça da sua partida de xadrez
   public ChessPiece[][] getPieces() {
      ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
      for(int i = 0; i<board.getRows(); i++){
         for (int j = 0; j<board.getColumns(); j++){
            mat[i][j] = (ChessPiece) board.piece(i, j);
         }
      }
      return mat;
   }

   private void PlaceNewPiece(char column, int row, ChessPiece piece){
      board.placePiece(piece, new ChessPosition(column, row).toPosition());
   }
   private void inicialSetup(){
      PlaceNewPiece('b', 4, new Rook(board, Color.WHITE));
      PlaceNewPiece('a', 8, new King(board, Color.BLACK));
   }
}
