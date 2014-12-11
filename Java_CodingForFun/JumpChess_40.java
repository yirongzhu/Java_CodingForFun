package codingForFun;
import java.util.*;
// There¡¯s a N*N board, two players join the jump game. The chess could go vertically and horizontally. If the adjacent chess is opponent player¡¯s and the spot beside that is empty,
// then the chess could jump to that spot. One chess could not been jumped twice. Given the position of the spot on the board, write the program to count the longest length that
// chess could go.
public class JumpChess_40 {

	private int[][] matrix;
	private ArrayList<ArrayList<Integer>> check;
	
	public boolean checkInBound(int i, int j) {
		return (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length);
	}
	
	public int longestJumpPath(int i, int j, int player) {
		int down = 0;
		int up = 0;
		int left = 0;
		int right = 0;
		if (checkInBound(i + 1, j) && checkInBound(i + 2, j)) {
			if (matrix[i + 1][j] != 0 && matrix[i + 1][j] != player && matrix[i + 2][j] == 0) {
				ArrayList<Integer> pair = new ArrayList<Integer>(Arrays.asList(i + 1, j));
				if (!check.contains(pair)) {
					check.add(pair);
					matrix[i][j] = 0;
					matrix[i + 2][j] = player;
					down = 2 + longestJumpPath(i + 2, j, player);
					check.remove(pair);
				}
			}
		}
		if (checkInBound(i - 1, j) && checkInBound(i - 2, j)) {
			if (matrix[i - 1][j] != 0 && matrix[i - 1][j] != player && matrix[i - 2][j] == 0) {
				ArrayList<Integer> pair = new ArrayList<Integer>(Arrays.asList(i - 1, j));
				if (!check.contains(pair)) {
					check.add(pair);
					matrix[i][j] = 0;
					matrix[i - 2][j] = player;
					up = 2 + longestJumpPath(i - 2, j, player);
					check.remove(pair);
				}
			}
		}
		if (checkInBound(i, j - 1) && checkInBound(i, j - 2)) {
			if (matrix[i][j - 1] != 0 && matrix[i][j - 1] != player && matrix[i][j - 2] == 0) {
				ArrayList<Integer> pair = new ArrayList<Integer>(Arrays.asList(i, j - 1));
				if (!check.contains(pair)) {
					check.add(pair);
					matrix[i][j] = 0;
					matrix[i][j - 2] = player;
					left = 2 + longestJumpPath(i, j - 2, player);
					check.remove(pair);
				}
			}
		}
		if (checkInBound(i, j + 1) && checkInBound(i, j + 2)) {
			if (matrix[i][j + 1] != 0 && matrix[i][j + 1] != player && matrix[i][j + 2] == 0) {
				ArrayList<Integer> pair = new ArrayList<Integer>(Arrays.asList(i, j + 1));
				if (!check.contains(pair)) {
					check.add(pair);
					matrix[i][j] = 0;
					matrix[i][j + 2] = player;
					right = 2 + longestJumpPath(i, j + 2, player);
					check.remove(pair);
				}
			}
		}
		return Math.max(Math.max(Math.max(down, up), left), right);
	}
	
	public static void main(String[] args) {
		JumpChess_40 jc = new JumpChess_40();
		jc.matrix = new int[][] {{0,0,0,0,0,0}, {0,0,2,1,2,0}, {0,2,0,2,0,0}, {0,0,2,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}};
		for (int i = 0; i < jc.matrix.length; i++) {
			for (int j = 0; j < jc.matrix[0].length; j++) {
				System.out.print(jc.matrix[i][j] + " ");
			}
			System.out.println();
		}
		jc.check = new ArrayList<ArrayList<Integer>>();
		System.out.println(jc.longestJumpPath(1, 3, jc.matrix[1][3]));
	}
}
