package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {																	// Movimentos possíveis da peça
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
				
		Position p = new Position(0, 0);
		
		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			// Significa que o peão branco pode ir para frente (1º se a posição existe 2º se tem um oponente lá)
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiene(p)) {								
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			// Significa que o peão branco pode ir para frente 2 casas para frente (3º e se a posição é inicio)
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiene(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiene(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// Significa que o peão branco pode ir para a esquerda (1º se a posição existe 2º se existe oponente)
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {								
				mat[p.getRow()][p.getColumn()] = true;
			}
			// Significa que o peão branco pode ir para a direira (1º se a posição existe 2º se existe oponente)
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {								
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		else {
			// Movimentos para o Peão Preto
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiene(p)) {								
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiene(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiene(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {								
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {								
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}
