import java.util.Scanner;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	private static char player = 'X';
	private static char board[][] = new char[3][3];
	private static int sor;
	private static int oszlop;
	
	public static void main(String[] args) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = '_';
			}
		}
		
		
		play();
		
	}
	
	public static void printBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(j == 0) {
					System.out.print(" | ");
				}
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
		
	}
	
	public static void play() {
		boolean playing = true;
		
		while(playing) {
			
			boolean ex = true;
			System.out.println("Player " + player + " please type in the row and the column: ");
			
			while(ex) {
			try {
			sor = scan.nextInt()-1;
			oszlop = scan.nextInt()-1;
			board[sor][oszlop] = player;
			ex = false;
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Values should be from 1 to 3! Player " + player + " 's turn!");
				printBoard();
			}
			
			}
			
			
			printBoard();
			
			if(gameEnds(sor, oszlop)) {
				playing = false;
				System.out.println("GAME OVER! Player " + player + " wins the game!");
			}
			
			
			if(player == 'X') {
				player = 'O';
			}
			else {
				player = 'X';
			}
			
		}
		
		
	}
	
	public static boolean gameEnds(int sor, int oszlop) {
		
		if(board[0][oszlop] == board[1][oszlop] && board[0][oszlop] == board[2][oszlop])
			return true;
		if(board[sor][0] == board[sor][1] && board[sor][0] == board[sor][2])
			return true;
		if(board [0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_')
			return true;
		if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_')
			return true;
		
		return false;
	}
	

}
