package codingForFun;

// A magic square of order n is an arrangement of the numbers from 1 to n^2 in an n by n matrix with each number occurring exactly once so that each row,
// each column and each main diagonal has the same sum. The n should be an odd number. In the middle cell of the top row, fill number 1.
// Then go to above row and right column, and fill following number 2. If it¡¯s out of boundary, go to the opposite row or column.
// If the next cell is already occupied, go to the cell below this cell and fill following number. An example of 5*5 grid is like this for the first 9 numbers:
// 0 0 1 8 0
// 0 5 7 0 0
// 4 6 0 0 0
// 0 0 0 0 3
// 0 0 0 2 9
public class MagicSquare_33 {

	public int[][] formMagicSquare(int n) {
		if (n < 0 || n % 2 == 0) {
			return null;
		}
		int[][] magicSquare = new int[n][n];
		int i = 0, j = n / 2;
		for (int value = 1; value <= n * n; value++) {
			if (i >= 0 && i < n && j >= 0 && j < n && magicSquare[i][j] == 0) {
				magicSquare[i][j] = value;
			}
			else if (i < 0 && j >= 0 && j < n) {
				i += n;
				magicSquare[i][j] = value;
			}
			else if (j >= n && i >= 0 && i < n) {
				j -= n;
				magicSquare[i][j] = value;
			}
			else {
				i += 2;
				j--;
				magicSquare[i][j] = value;
			}
			i--;
			j++;
		}
		return magicSquare;
	}
	
	public static void main(String[] args) {
		MagicSquare_33 ms = new MagicSquare_33();
		int[][] magicSquare = ms.formMagicSquare(5);
		for (int i = 0; i < magicSquare.length; i++) {
			for (int j = 0; j < magicSquare[0].length; j++) {
				System.out.print(magicSquare[i][j] + " ");
			}
			System.out.println();
		}
	}
}
