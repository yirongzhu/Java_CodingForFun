package codingForFun;

import java.util.*;

// find longest increasing sub sequence in 2d array. (bit more expl..) 
// ex: finding length of the snake in snake game 
// --------- 
// the sequence must not be diagonally. 
// but it can be any like top-bootm,bottom-left-top ........ 
// increasing means one step 
// ex: 10,11,12,13 (correct) 
// 12,14,15,20(wrong) 
// Ex: input: consider 4x4 grid 
// 2 3 4 5 
// 4 5 10 11 
// 20 6 9 12 
// 6 7 8 40 
// output : 4 5 6 7 8 9 10 11 12
public class SnakeSequence_16 {

	public static void main(String[] args) {
		SnakeSequence_16 ss = new SnakeSequence_16();
		int[][] matrix = new int[][] {{2,3,4,5},{4,5,10,11},{20,6,9,12},{6,7,8,40}};
		ArrayList<ArrayList<Integer>> snakes = ss.findallsnakes(matrix);
		for (ArrayList<Integer> snake : snakes) {
			System.out.println(snake);
		}
	}
	
	//2,loop the matrix for filling
	public int filldp(int[][] grid, int[][] dp) {
		if (grid.length == 0 || grid[0].length == 0) {
			throw new IllegalArgumentException();
		}
		int rows = grid.length, cols = grid[0].length;
		int max = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dp[i][j] == 0) {
					max = Math.max(max, fill(grid, i, j, dp));
				}
				else {
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}
	
	// 1,fill the dp matrix
	public int fill(int[][] grid, int r, int c, int[][] dp) {
		if (r <= 0 || c <= 0 || r > grid.length - 1 || c > grid[0].length - 1) {
			return 0;
		}
		if (dp[r][c] != 0) {
			return dp[r][c];
		}
		int left = 0, right = 0, down = 0, up = 0;
		if (r - 1 >= 0 && grid[r - 1][c] == grid[r][c] + 1) {
			up = fill(grid, r - 1, c, dp);
		}
		if (r + 1 < grid.length && grid[r + 1][c] == grid[r][c] + 1) {
			down = fill(grid, r + 1, c, dp);
		}
		if (c - 1 >= 0 && grid[r][c - 1] == grid[r][c] + 1) {
			left = fill(grid, r, c - 1, dp);
		}
		if (c + 1 < grid.length && grid[r][c + 1] == grid[r][c] + 1) {
			right = fill(grid, r, c + 1, dp);
		}
		dp[r][c] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
		return dp[r][c];
	}
	
	// 4, DFS for finding snake paths
	public void findall(int[][] grid, int[][] dp, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> one, int r, int c) {
		if (dp[r][c] == 1) {
			one.add(grid[r][c]);
			paths.add(one);
			System.out.println(one);
			return;
		}
		one.add(grid[r][c]);
		if (r - 1 >= 0 && dp[r - 1][c] == dp[r][c] - 1 && grid[r - 1][c] == grid[r][c] + 1)
			findall(grid, dp, paths, new ArrayList<Integer>(one), r - 1, c);
		if (r + 1 < grid.length && dp[r + 1][c] == dp[r][c] - 1 && grid[r + 1][c] == grid[r][c] + 1)
			findall(grid, dp, paths, new ArrayList<Integer>(one), r + 1, c);
		if (c - 1 >= 0 && dp[r][c - 1] == dp[r][c] - 1 && grid[r][c - 1] == grid[r][c] + 1)
			findall(grid, dp, paths, new ArrayList<Integer>(one), r, c - 1);
		if (c + 1 < grid[0].length && dp[r][c + 1] == dp[r][c] - 1 && grid[r][c + 1] == grid[r][c] + 1)
			findall(grid, dp, paths, new ArrayList<Integer>(one), r, c + 1);
	}
	
	// 3,main func for finding all the snake seqs
	// assume we just need to find the elements along the snake paths not the
	// coordinates
	public ArrayList<ArrayList<Integer>> findallsnakes(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			throw new IllegalArgumentException();
		ArrayList<ArrayList<Integer>> snakes = new ArrayList<ArrayList<Integer>>();
		int rows = grid.length, cols = grid[0].length;
		int[][] dp = new int[rows][cols];
		int max = filldp(grid, dp);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dp[i][j] == max) {
					findall(grid, dp, snakes, new ArrayList<Integer>(), i, j);
				}
			}
		}
		return snakes;
	}
}
