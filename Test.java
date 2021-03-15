import java.util.*;

public class Test {
  public static void main(String[] args) {
    char[][] board = new char[5][5];
    for(int x=0;x<board.length;x++){
        java.util.Arrays.fill(board[x], '-');
    }
    printBattleShip(board);
  }
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
