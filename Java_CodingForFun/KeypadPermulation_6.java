package codingForFun;

import java.util.*;

// Phone has letters on the number keys. for example, number 2 has ABC on it, number 3 has DEF, 4 number has GHI,... , and number 9 has WXYZ.
// Write a program that will print out all of the possible combination of those letters depending on the input.  
public class KeypadPermulation_6 {

	private static String[] s = { null, "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	public void Combination(String prefix, String num) {
		if (num.length() == 0) {
			System.out.println(prefix);
		} 
		else {
			int x = Integer.parseInt(num.charAt(0) + "");
			String temp = new String();
			temp = s[x - 1];
			if (temp != null) {
				for (int j = 0; j < temp.length(); j++) {
					Combination(prefix + temp.charAt(j), num.substring(1, num.length()));
				}
			} 
			else {
				Combination(prefix, num.substring(1, num.length()));
			}
		}
	}

	public static void main(String args[]) {
		KeypadPermulation_6 kp = new KeypadPermulation_6();
		Scanner in = new Scanner(System.in);
		int num;
		System.out.print("Enter a number: ");
		num = in.nextInt();
		kp.Combination("", Integer.toString(num));
	}
}
