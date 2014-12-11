package codingForFun;

// Given a M * N matrix, if the element in the matrix is larger than other 8 elements who stay around it, then named that element be mountain point. Print all the mountain points.
public class MountainPoint_17 {
	
	public void printMountain(int[][] matrix) {
		if (matrix == null || matrix.length < 3 || matrix[0].length < 3) {
			return;
		}
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (((i - 1 < 0) || (j - 1 < 0) || (i - 1 >= 0 && j - 1 >= 0 && matrix[i][j] > matrix[i - 1][j - 1]))
					&& ((i - 1 < 0) || (i - 1 >= 0 && matrix[i][j] > matrix[i - 1][j]))
					&& ((i - 1 < 0) || (j + 1 > n) || (i - 1 >= 0 && j + 1 <= n && matrix[i][j] > matrix[i - 1][j + 1]))
					&& ((j - 1 < 0) || (j - 1 >= 0 && matrix[i][j] > matrix[i][j - 1]))
					&& ((j + 1 > n) || (j + 1 <= n && matrix[i][j] > matrix[i][j + 1]))
					&& ((i + 1 > m) || (j - 1 < 0) || (i + 1 <= m && j - 1 >= 0 && matrix[i][j] > matrix[i + 1][j - 1]))
					&& ((i + 1 > m) || (i + 1 <= m && matrix[i][j] > matrix[i + 1][j]))
					&& ((i + 1 > m) || (j + 1 > n) || (i + 1 <= m && j + 1 <= n && matrix[i][j] > matrix[i + 1][j + 1]))) {
					System.out.println(matrix[i][j]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MountainPoint_17 mp = new MountainPoint_17();
		int[][] matrix = new int[][] {{12, 18, 26, 20}, {33, 20, 97, 37}, {19, 16, 23, 28}, {15, 27, 22, 86}};
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		mp.printMountain(matrix);
	}
}
