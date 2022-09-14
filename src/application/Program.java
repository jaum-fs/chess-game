package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch x = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while(!x.getCheckMate()) {
			try {
				UI.clearScreen();
				
				UI.printMatch(x, captured);
				System.out.println();
				System.out.println("Source position: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = x.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(x.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.println("Target position: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = x.performChessMove(source,target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if(x.getPromoted()!=null) {
					System.out.print("Escolha uma peça para promoção (B/N/R/Q): ");
					String type = sc.nextLine().toUpperCase();
					while(!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
						System.out.print("Escolha inválida! Escolha uma peça para promoção (B/N/R/Q): ");
						type = sc.nextLine().toUpperCase();
					}
					x.replacePromotedPiece(type);
				}
				
				
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
		UI.clearScreen();
		UI.printMatch(x, captured);
	}
}
