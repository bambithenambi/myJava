import java.util.*;
import java.io.*;

public class Battleship {
	public static void main(String[] args) {
    System.out.println("Welcome to Battleship!\n");
    Scanner input = new Scanner(System.in);

    System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");
    char[][] player1 = initBoard(5,5);
    for (int i=1; i<6; i++) {
      while (true) {
        System.out.println("Enter ship "+i+" location:");
        int row = input.nextInt();
        int col = input.nextInt();
        if (addToBoard(player1, row, col)) {
          player1[row][col]='@';
          break;
        }
      }
    }
    printBattleShip(player1);
		printLines(100);
    System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");
    char[][] player2 = initBoard(5,5);
    for (int i=1; i<6; i++) {
      while (true) {
        System.out.println("Enter ship "+i+" location:");
        int row = input.nextInt();
        int col = input.nextInt();
        if (addToBoard(player2, row, col)) {
          player2[row][col]='@';
          break;
        }
      }
    }
    printBattleShip(player2);
		printLines(100);

		char[][] player1TargetHistory = initBoard(5,5);
		char[][] player2TargetHistory = initBoard(5,5);
		while (true) {
			while (true) {
				System.out.println("Player 1, enter hit row/column:");
				int row = input.nextInt();
				int col = input.nextInt();
				if (checkTarget(player1TargetHistory, row, col)) {
					fire(1, player1TargetHistory, player2, row, col);
					break;
				}
			}
			if (checkWinner(player1TargetHistory)) {
				System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
				break;
			}
			while (true) {
				System.out.println("Player 2, enter hit row/column:");
				int row = input.nextInt();
				int col = input.nextInt();
				if (checkTarget(player2TargetHistory, row, col)) {
					fire(2, player2TargetHistory, player1, row, col);
					break;
				}
			}
			if (checkWinner(player2TargetHistory)) {
				System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
				break;
			}
		}
		System.out.println("Final boards:\n");
		printBattleShip(player1);
		System.out.println("");
		printBattleShip(player2);
	}

  private static boolean addToBoard(char[][] board, int row, int col) {
    if (row>4 || col>4 || row<0 || col<0) {
      System.out.println("Invalid coordinates. Choose different coordinates.");
      return false;
    }
    else if (board[row][col]=='@') {
      System.out.println("You already have a ship there. Choose different coordinates.");
      return false;
    }
    else {
      return true;
    }
  }
  private static char[][] initBoard(int rows, int cols) {
    char[][] board = new char[rows][cols];
    for(int x=0;x<board.length;x++){
        java.util.Arrays.fill(board[x], '-');
    }
    return board;
  }
	private static boolean checkTarget(char[][] target, int row, int col) {
		if (row>4 || col>4 || row<0 || col<0) {
      System.out.println("Invalid coordinates. Choose different coordinates.");
      return false;
    }
    else if (target[row][col]=='O' || target[row][col]=='X') {
      System.out.println("You already fired on this spot. Choose different coordinates.");
      return false;
    }
    else {
      return true;
    }
	}
	private static void fire(int id, char[][] target, char[][] oppBoard, int row, int col) {
		int opID = 1;
		if (id==1){
			opID = 2;
		}
		if (oppBoard[row][col]=='@'){
			System.out.println("PLAYER "+id+" HIT PLAYER "+opID+"’s SHIP!");
			target[row][col]='X';
			oppBoard[row][col]='X';
		}
		else {
			System.out.println("PLAYER "+id+" MISSED!");
			target[row][col]='O';
			oppBoard[row][col]='O';
		}
		printBattleShip(target);
		System.out.println("");
	}
	private static boolean checkWinner(char[][] target) {
		int counter = 0;
		for (int c = 0; c < target[0].length; c++) {
      for (int r = 0; r < target.length; r++) {
				if (target[r][c]=='X') {
					counter++;
				}
			}
		}
		if (counter==5) {
			return true;
		}
		else {
			return false;
		}
	}
	private static void printLines(int limit) {
		int c = 0;
		do {
			System.out.println("");
			c++;
		}
    while (c<limit);
	}
    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}
