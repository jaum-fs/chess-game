package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch x = new ChessMatch();
		UI.printBoard(x.getPieces());
	}

}
