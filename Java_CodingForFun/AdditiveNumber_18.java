package codingForFun;

import java.util.*;

// An additive sequence is 1,2,3,5,8,13 where T(n) = T(n -1) + T(n - 2). A number range is given to you. Find the additive sequence number in that range.
// Given the start and an ending integer as user input, generate all integers with the following property.
public class AdditiveNumber_18 {

	public List<Integer> additive(int n1, int n2) {
		List<Integer> res = new ArrayList<Integer>();
		if (n1 < 112 || n2 < 112 || n1 > n2) { // error check
			return res;
		}
		for (int i = 1; i < 500; i++) {
			int x1 = i, x2 = i;
			int x3 = x1 + x2;
			int x = cast(x1, x2);
			x = cast(x, x3);
			if (x > n2)
				break; // out of range
			for (;;) {
				if (x > n2)
					break;
				if (x >= n1) {
					res.add(x);
				}
				x1 = x2;
				x2 = x3;
				x3 = x1 + x2;
				if (notOver(x, x3)) // check if over flow
					x = cast(x, x3);
				else
					break;
			}
		}
		return res;
	}

	public static int cast(int m1, int m2) {
		int p = len(m2);
		return (int) (m1 * Math.pow(10, p) + m2);
	}

	public static boolean notOver(int m1, int m2) {
		int p = len(m2);
		return m1 <= (Integer.MAX_VALUE - m2) / Math.pow(10, p);
	}

	public static int len(int n) {
		return (int) Math.log10(n) + 1;
	}

	public static void main(String[] args) {
		AdditiveNumber_18 an = new AdditiveNumber_18();
		List<Integer> l = an.additive(112, 1000000000);
		for (Integer e : l) {
			System.out.println(e);
		}
	}
}
