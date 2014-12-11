package codingForFun;

public class MaxLabel {
	public static int maxLable(int num, int digit) {
		if (digit < 0 || digit > 9 || num < 1)
			return Integer.MIN_VALUE;
		String str;
		while (true) {
			str = String.valueOf(num);
			int i = 0;
			for (; i < str.length() && str.charAt(i) - '0' != digit; i++);
			if (i == str.length())
				break; // no invalid digits
			int p = str.length() - 1 - i; // power level of left most invalid
											// digit
			num = (int) (num - Math.pow(10, p) - num % Math.pow(10, p) + getRemain(
					p, digit));
			// example: 38912 - 100 - 12 + 88 = 38888
		}
		return Integer.parseInt(str);
	}

	private static int getRemain(int p, int d) { // get remaining num
		int r;
		if (d == 9)
			r = 8;
		else
			r = 9;
		int res = 0;
		for (; p > 0; p--) {
			res = res * 10 + r;
		}
		return res;
	}
}
