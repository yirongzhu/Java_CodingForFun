package codingForFun;

// There is a security keypad at the entrance of a building. It has 9 numbers 1 - 9 in a 3x3 matrix format. 
// 1 2 3 
// 4 5 6 
// 7 8 9 
// The security has decided to allow one digit error for a person but that digit should be horizontal or vertical.
// Example: for 5 the user is allowed to enter 2, 4, 6, 8 or for 4 the user is allowed to enter 1, 5, 7.
// IF the security code to enter is 1478 and if the user enters 1178 he should be allowed.
// Write a function to take security code from the user and print out if he should be allowed or not.
public class SecurityKeypad_29 {

	public boolean allowed(int[] a) {
		int[][] keypad = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] code = { 1, 4, 7, 8 };
		if (a.length != code.length) {
			return false;
		}
		int countMistake = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != code[i]) {
				countMistake++;
				if (countMistake > 1) {
					return false;
				} 
				else {
					if (!checkNear(keypad, code[i], a[i])) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean checkNear(int[][] keypad, int i, int ai) {
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				if (ai == keypad[j][k]) {
					if (j - 1 >= 0 && keypad[j - 1][k] == i) {
						return true;
					}
					if (j + 1 <= 2 && keypad[j + 1][k] == i) {
						return true;
					}
					if (k - 1 >= 0 && keypad[j][k - 1] == i) {
						return true;
					}
					if (k + 1 <= 2 && keypad[j][k + 1] == i) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		SecurityKeypad_29 sk = new SecurityKeypad_29();
		int[] a = new int[] {1, 9, 7, 8};
		System.out.println(sk.allowed(a));
	}
}
