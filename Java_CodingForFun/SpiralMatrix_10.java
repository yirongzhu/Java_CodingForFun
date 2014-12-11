package codingForFun;

import java.util.*;

// Given aNXN matrix, starting from the upper right corner of the matrix start printing values in a counter-clockwise fashion. 
public class SpiralMatrix_10 {
	
	public List<Character> spiralOrder(char[][] matrix) {
		List<Character> result = new ArrayList<Character> ();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int len = matrix.length;
		int i = 0;
		int j = len - 1;
		while ((i - 1 >= 0 && !result.contains(matrix[i - 1][j])) || (j - 1 >= 0 && !result.contains(matrix[i][j - 1])) || (i + 1 < len && !result.contains(matrix[i + 1][j])) || (j + 1 < len && !result.contains(matrix[i][j + 1]))) {
			while (j - 1 >= 0 && !result.contains(matrix[i][j - 1])) {
				result.add(matrix[i][j]);
				j--;
			}
			while (i + 1 < len && !result.contains(matrix[i + 1][j])) {
				result.add(matrix[i][j]);
				i++;
			}
			while (j + 1 < len && !result.contains(matrix[i][j + 1])) {
				result.add(matrix[i][j]);
				j++;
			}
			while (i - 1 >= 0 && !result.contains(matrix[i - 1][j])) {
				result.add(matrix[i][j]);
				i--;
			}
		}
		result.add(matrix[i][j]);
		return result;
	}
	
	public static void main(String[] args) {
		SpiralMatrix_10 sm = new SpiralMatrix_10();
		char[][] matrix = new char[][] {{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'}, {'i', 'j', 'k', 'l'}, {'m', 'n', 'o', 'p'}};
		List<Character> l = sm.spiralOrder(matrix);
		for(Character c : l) {
			System.out.print(c);
		}
	}
}
