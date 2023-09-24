package oops;

public class TicTacToeBoard {
	private char p1Symbol;
	private char p2Symbol;
	private char[][] board;
	private int boardSize = 3;
	private final static char EMPTY = ' ';
	public final static int PLAYER1WINS = 1;
	public final static int PLAYER2WINS = 2;
	public final static int DRAW = 3;
	public final static int INCOMPLETE = 4;
	public final static int INVALIDMOVE = 5;
	private int count;
	
	public TicTacToeBoard(char p1Symbol, char p2Symbol) {
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
		board = new char[boardSize][boardSize];
		for(int i = 0; i<boardSize; i++) {
			for(int j = 0; j<boardSize; j++) {
				board[i][j] = EMPTY;
			}
		}
		this.count = 0;
	}

	public int move(char playerSymbol, int row, int col) {
		// Checking for invalid move
		if(row >= boardSize || col >= boardSize || col < 0 || row < 0 || 
				board[row][col] != TicTacToeBoard.EMPTY) {
			return TicTacToeBoard.INVALIDMOVE;
		}
		// Make a move since it is valid move
		board[row][col] = playerSymbol;
		count++;
		// Checking for wins & draw
		boolean isRowPattern = true;
		for(int j = 0; j<boardSize; j++) {
			if(board[row][j] != playerSymbol) {
				isRowPattern = false;
			}
		}
		boolean isColPattern = true;
		for(int i = 0; i<boardSize; i++) {
			if(board[i][col] != playerSymbol) {
				isColPattern = false;
			}
		}
		boolean isDia1Pattern = true;
		for(int i = 0; i<boardSize; i++) {
			if(board[i][i] != playerSymbol) {
				isDia1Pattern = false;
			}
		}
		boolean isDia2Pattern = true;
		for(int i = 0; i<boardSize; i++) {
			if(board[i][boardSize-i-1] != playerSymbol) {
				isDia2Pattern = false;
			}
		}
		if(isRowPattern || isColPattern || isDia1Pattern || isDia2Pattern) {
			return (p1Symbol == playerSymbol) ? TicTacToeBoard.PLAYER1WINS : TicTacToeBoard.PLAYER2WINS;
		}
		else {
			return (count == boardSize*boardSize) ? TicTacToeBoard.DRAW : TicTacToeBoard.INCOMPLETE;
		}
	}

	public void print() {
		System.out.println("-----------------");
		for(int i = 0; i<boardSize; i++) {
			for(int j = 0; j<boardSize; j++) {
				System.out.print("| " + board[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
	
}
