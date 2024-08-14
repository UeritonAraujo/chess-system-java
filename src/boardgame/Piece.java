package boardgame;

public class Piece {								// Peça
	
	protected Position position;
	private Board board;
	
	public Piece( ) {
	}

	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}
}
