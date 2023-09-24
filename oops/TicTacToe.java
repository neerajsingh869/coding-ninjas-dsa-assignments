package oops;

import java.util.Scanner;

public class TicTacToe {
	private Player player1;
	private Player player2;
	private TicTacToeBoard board;
	private int numPlayers = 0;
	
	public void startGame() {
		// Take Player Inputs
		Scanner sc = new Scanner(System.in);
		player1 = takePlayerInput(++numPlayers );
		player2 = takePlayerInput(++numPlayers);
		while(player2.getSymbol() == player1.getSymbol()) {
			System.out.println("Symbol already taken. Please enter different symbol: ");
			player2.setSymbol(sc.next().charAt(0));
		}
		// Initialize Board
		board = new TicTacToeBoard(player1.getSymbol(), player2.getSymbol());
		// Play game until game is finished
		boolean isPlayer1Turn = true;
		int status = TicTacToeBoard.INCOMPLETE;
		while(status == TicTacToeBoard.INCOMPLETE || status == TicTacToeBoard.INVALIDMOVE) {
			int row, col;
			if(isPlayer1Turn) {
				System.out.println("Player 1 - " + player1.getName() + "'s turn");
				System.out.println("Enter x: ");
				row = sc.nextInt();
				System.out.println("Enter y: ");
				col = sc.nextInt();
				status = board.move(player1.getSymbol(), row, col);
				if(status == TicTacToeBoard.INVALIDMOVE) {
					System.out.println("Invalid Move. Re-enter: ");
					continue;
				}
				else {
					isPlayer1Turn = false;
				}
			}
			else {
				System.out.println("Player 2 - " + player2.getName() + "'s turn");
				System.out.println("Enter x: ");
				row = sc.nextInt();
				System.out.println("Enter y: ");
				col = sc.nextInt();
				status = board.move(player2.getSymbol(), row, col);
				if(status == TicTacToeBoard.INVALIDMOVE) {
					System.out.println("Invalid Move. Re-enter: ");
					continue;
				}
				else {
					isPlayer1Turn = true;
				}
			}
			board.print();
		}
		if(status == TicTacToeBoard.PLAYER1WINS) {
			System.out.println("Hurray! Player 1 "  + player1.getName() + " wins.");
		}
		else if(status == TicTacToeBoard.PLAYER2WINS) {
			System.out.println("Hurray! Player 2 "  + player2.getName() + " wins.");
		}
		else {
			System.out.println("The game is Draw. Better luck next time.");
		}
	}
	
	public Player takePlayerInput(int playerNum) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Player " + playerNum + " name: ");
		String name = sc.nextLine();
		System.out.println("Enter Player " + playerNum + " symbol: ");
		char symbol = sc.next().charAt(0);
		return new Player(name, symbol);
	}
	
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		t.startGame();
	}
	
}
