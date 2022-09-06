package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch x = new ChessMatch();
		
		
		while(true) {
			UI.printBoard(x.getPieces());
			System.out.println();
			System.out.println("Posição de origem: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.println("Posição de destino: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = x.performChessMove(source,target);
		}

	}

}
