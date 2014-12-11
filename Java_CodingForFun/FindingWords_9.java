package codingForFun;

// Write a program for a word search. If there is an NxN grid with one letter in each cell.
// Let the user enter a word and the letters of the word are said to be found in the grid either the letters match vertically,
// horizontally or diagonally in the grid. If the word is found, print the coordinates of the letters as output.
public class FindingWords_9 {
/*
	public class Solution {
		// recursion
		public boolean exist(char[][] board, String word) {
			if (board == null || board.length == 0)
				return false;
			if (word.length() == 0)
				return true;

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == word.charAt(0)) {
						boolean rst = find(board, i, j, word, 0);
						if (rst)
							return true;
					}
				}
			}
			return false;
		}

		private boolean find(char[][] board, int i, int j, String word, int start) {
			if (start == word.length())
				return true;

			if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
				return false;
			}

			board[i][j] = '#'; // should remember to mark it
			boolean rst = find(board, i - 1, j, word, start + 1) || find(board, i, j - 1, word, start + 1) || find(board, i + 1, j, word, start + 1) || find(board, i, j + 1, word, start + 1);
			board[i][j] = word.charAt(start);
			return rst;
		}
	}
*/
	public String[] getWordIndices(char[][] grid, String word) {
		// Assuming search in all directions is possible
		int length = word.length(); // word length
		String[] indices = new String[length]; // final indices
		boolean found = false; // to indicate whether the word is found

		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				// find 1st character in the word
				if (grid[i][j] == word.charAt(0)) {
					// search up left
					if (i >= length - 1 && j >= length - 1) 
					{
						found = true;
						for (int k = 0; k < length; k++) {
							if (grid[i - k][j - k] == word.charAt(k))
								indices[k] = (i - k) + "," + (j - k);
							else {
								found = false;
								break;
							}
						}
						if (found)
							return indices;
					}
					
					// search up
					if (i >= length - 1) { 
						found = true;
						for (int k = 0; k < length; k++) {
							if (grid[i - k][j] == word.charAt(k))
								indices[k] = (i - k) + "," + j;
							else {
								found = false;
								break;
							}
						}
						if (found)
							return indices;
					}
					
					// search up right
					if (i >= length - 1 && grid.length - j >= length) {
						found = true;
						for (int k = 0; k < length; k++) {
							if (grid[i - k][j + k] == word.charAt(k))
								indices[k] = (i - k) + "," + (j + k);
							else {
								found = false;
								break;
							}
						}
						if (found)
							return indices;
					}
					
					// search left
					if (j >= length - 1) 
					{
						found = true;
						for (int k = 0; k < length; k++) {
							if (grid[i][j - k] == word.charAt(k))
								indices[k] = i + "," + (j - k);
							else {
								found = false;
								break;
							}
						}
						if (found)
							return indices;
					}
					
					if (grid.length - j >= length) // search right
					{
						found = true;
						for (int k = 0; k < length; k++) {
							if (grid[i][j + k] == word.charAt(k))
								indices[k] = i + "," + (j + k);
							else {
								found = false;
								break;
							}
						}
						if (found)
							return indices;
					}
					
					// search down left
					if (grid.length - i >= length && j >= length - 1) {
						found = true;
						for (int k = 0; k < length; k++) {
							if (grid[i + k][j - k] == word.charAt(k))
								indices[k] = (i + k) + "," + (j - k);
							else {
								found = false;
								break;
							}
						}
						if (found)
							return indices;
					}

					// search down
					if (grid.length - i >= length) 
					{
						found = true;
						for (int k = 0; k < length; k++) {
							if (grid[i + k][j] == word.charAt(k))
								indices[k] = (i + k) + "," + j;
							else {
								found = false;
								break;
							}
						}
						if (found)
							return indices;
					}
					
					// search down right
					if (grid.length - i >= length && grid.length - j >= length) {
						found = true;
						for (int k = 0; k < length; k++) {
							if (grid[i + k][j + k] == word.charAt(k))
								indices[k] = (i + k) + "," + (j + k);
							else {
								found = false;
								break;
							}
						}
						if (found)
							return indices;
					}
				}
			}
		return null;
	}
	
	public static void main(String[] args)
	{
		FindingWords_9 fw = new FindingWords_9();
		char[][] grid = { 
				{ 'a', 'b', 'c', 'd' }, 
				{ 'i', 'f', 'e', 'h' },
				{ 'e', 'j', 'j', 'l' }, 
				{ 'm', 'n', 'o', 'p' } };

		String[] indices = fw.getWordIndices(grid, "oje");
		if (indices != null)
			for (String index : indices)
				System.out.println(index);
	}
}

