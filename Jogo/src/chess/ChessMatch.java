package chess;

import boardgame.Board;
import boardgame.Piece;
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

   public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
      Position source = sourcePosition.toPosition();
      Position target = targetPosition.toPosition();
      validateSourcePosition(source);
      Piece capturedPiece = makeMove(source, target);
      return (ChessPiece)capturedPiece;
   }

   private Piece makeMove(Position source, Position target){
      Piece p = board.removePiece(source);
      Piece capturedPiece = board.removePiece(target);
      board.placePiece(p, target);
      return capturedPiece;

   }
   private void validateSourcePosition(Position position){
      if(!board.thereIsAPiece(position)){
         throw new ChessException("There's no piece on source position!");
      }
   }

   private void PlaceNewPiece(char column, int row, ChessPiece piece){
      board.placePiece(piece, new ChessPosition(column, row).toPosition());
   }
   private void inicialSetup(){
      PlaceNewPiece('c', 1, new Rook(board, Color.WHITE));
      PlaceNewPiece('c', 2, new Rook(board, Color.WHITE));
      PlaceNewPiece('d', 2, new Rook(board, Color.WHITE));
      PlaceNewPiece('e', 2, new Rook(board, Color.WHITE));
      PlaceNewPiece('e', 1, new Rook(board, Color.WHITE));
      PlaceNewPiece('d', 1, new King(board, Color.WHITE));
      PlaceNewPiece('c', 7, new Rook(board, Color.BLACK));
      PlaceNewPiece('c', 8, new Rook(board, Color.BLACK));
      PlaceNewPiece('d', 7, new Rook(board, Color.BLACK));
      PlaceNewPiece('e', 7, new Rook(board, Color.BLACK));
      PlaceNewPiece('e', 8, new Rook(board, Color.BLACK));
      PlaceNewPiece('d', 8, new King(board, Color.BLACK));
   }
}
