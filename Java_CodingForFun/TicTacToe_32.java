package codingForFun;

// N*N matrix is given with input red or black.You can move horizontally, vertically or diagonally. If 3 consecutive same color found,
// that color will get 1 point. So if 4 red are vertically then pointis 2. Find the winner.
public class TicTacToe_32 {

	public void findWinner(char[][] matrix, char red, char black) {
		int countRed = countColor(matrix, red);
		int countBlack = countColor(matrix, black);
		if (countRed > countBlack) {
			System.out.println("Red is the winner: " + countRed + ", while Black is the loser: " + countBlack);
		}
		else if (countRed < countBlack) {
			System.out.println("Black is the winner: " + countBlack + ", while Red is the loser: " + countRed);
		}
		else {
			System.out.println("No winner, because both equal to: " + countRed);
		}
	}
	
	public int countColor(char[][] matrix, char color) {
		if (matrix == null || matrix.length < 3 || matrix[0].length < 3) {
			return 0;
		}
		int len = matrix.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 2; j++) {
				if (matrix[i][j] == color && matrix[i][j + 1] == color && matrix[i][j + 2] == color) {
					count++;
				}
			}
		}
		
		for (int i = 0; i < len - 2; i++) {
			for (int j = 0; j < len; j++) {
				if (matrix[i][j] == color && matrix[i + 1][j] == color && matrix[i + 2][j] == color) {
					count++;
				}
			}
		}
		
		for (int i = 0; i < len - 2; i++) {
			for (int j = 0; j < len - 2; j++) {
				if (matrix[i][j] == color && matrix[i + 1][j + 1] == color && matrix[i + 2][j + 2] == color) {
					count++;
				}
			}
		}
		
		for (int i = len - 1; i >= 2; i--) {
			for (int j = 0; j < len - 2; j++) {
				if (matrix[i][j] == color && matrix[i - 1][j + 1] == color && matrix[i - 2][j + 2] == color) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		TicTacToe_32 ttt = new TicTacToe_32();
		char[][] matrix = new char[][] { { 'r', 'r', 'r', 'b' }, { 'b', 'r', 'b', 'r' }, { 'b', 'r', 'r', 'b' }, { 'b', 'r', 'b', 'b' } };
		ttt.findWinner(matrix, 'r', 'b');
	}
}
