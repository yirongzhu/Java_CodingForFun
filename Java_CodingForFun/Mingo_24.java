package codingForFun;

// There is a game they termed as Mingo. A random generator (like a speaker standing in a group house game calls out a number) generates out any number from 1 to 1000. 
// There is a 10X10 matrix. A random generator assigns values to each block of this matrix(within 1 to 1000 obviously). 
// Whenever, a row or a column or a diagonal is fully filled in this 10x10 from the numbers called out by the speaker, its called a 'Mingo'. 
// Write a program that will find first Mingo, then second Mingo, then thirds Mingo...and so forth.
public class Mingo_24 {

	private int[][] matrix = new int[10][10];
	private static int count = 0;
	private static boolean positiveDiagChecked = false;
	private static boolean negativeDiagChecked = false;

	public void printMingle() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "    ");
			}
			System.out.println();
		}
	}

	public void isMingo(int[][] matrix) {
		int value = 0;
		int row = 0;
		int col = 0;
		int data = 0;
		for (int i = 0; i < 100; i++) {
			value = (int) (Math.random() * 100);
			row = value / 10;
			col = value - row * 10;
			while (matrix[row][col] != 0) {
				value = (int) (Math.random() * 100);
				row = value / 10;
				col = value - row * 10;
			}
			data = (int) (Math.random() * 1000);
			matrix[row][col] = data;
			checkMingle(matrix, row, col);
		}

	}

	public void checkMingle(int[][] matrix, int row, int col) {
		// check row
		int index = 0;
		while (index < matrix[row].length && matrix[row][index] != 0) {
			index++;
		}
		if (index == matrix[row].length) {
			count++;
			System.out.println("Number " + count + " mingle" + " row:" + row);
		}
		// check column
		index = 0;
		while (index < matrix.length && matrix[index][col] != 0) {
			index++;
		}
		if (index == matrix.length) {
			count++;
			System.out.println("Number " + count + " mingle" + " col: " + col);
		}
		// check positive diag
		if (!positiveDiagChecked) {
			index = 0;
			while (index < matrix.length && matrix[index][index] != 0) {
				index++;
			}
			if (index == matrix.length) {
				count++;
				System.out.println("Number " + count + " mingle" + " row:"
						+ row + " col: " + col + "It is positive diag!!!!");
				positiveDiagChecked = true;
			}
		}
		// check negative diag
		if (!negativeDiagChecked) {
			index = 0;
			while (index < matrix[row].length && matrix[matrix.length - index - 1][index] != 0) {
				index++;
			}
			if (index == matrix[row].length) {
				count++;
				System.out.println("Number " + count + " mingle" + " row:"
						+ row + " col: " + col + "It is negative diag!!!!");
				negativeDiagChecked = true;
			}
		}
	}

	public static void main(String[] args) {
		Mingo_24 cm = new Mingo_24();
		cm.isMingo(cm.matrix);
		cm.printMingle();
	}
}
