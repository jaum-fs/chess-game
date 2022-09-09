package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch x = new ChessMatch();
		
		
		while(true) {
			try {
				UI.clearScreen();
				
				UI.printBoard(x.getPieces());
				System.out.println();
				System.out.println("Source position: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				System.out.println();
				System.out.println("Target position: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = x.performChessMove(source,target);
			}
			catch (ChessException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			
		}
	}
}
