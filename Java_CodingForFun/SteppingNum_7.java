package codingForFun;

// A number is called as a stepping number if the adjacent digits are having a difference of 1. For eg. 8,343,545 are stepping numbers. While 890, 098 are not.
// The difference between a ¡®9¡¯ and ¡®0¡¯ should not be considered as 1. Given start number(s) and an end number (e) your function should list out all the stepping
// numbers in the range including both the numbers s & e.
public class SteppingNum_7 {
/*
	public void findAllSteppingNum(int s, int e) {
		for (int i = s; i <= e; i++) {
			if (isSteppingNum(i)) {
				System.out.println(i);
			}
		}
	}
	
	public boolean isSteppingNum(int num) {
		num = num < 0 ? - num : num;
		if (num < 10) {
			return true;
		}
		String s = String.valueOf(num);
		for (int i = 0; i < s.length() - 1; i++) {
			if (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1) {
				return false;
			}
		}
		return true;
	}
*/
	
	public void findAllSteppingNum(int s, int e) {
		int ls = String.valueOf(s).length();
		int le = String.valueOf(e).length();
		for (int i = ls; i <= le; i++) {
			for (int j = 1; j < 10; j++) {
				findAllSteppingNumHelper(s, e, i, j);
			}
		}
	}
	
	public void findAllSteppingNumHelper(int s, int e, int l, int n) {
		if (l == 1) {
			if (n >= s && n <= e) {
				System.out.println(n);
			}
			return;
		}
		int lastDigit = n % 10;
		if (lastDigit == 0) {
			findAllSteppingNumHelper(s, e, l - 1, n * 10 + 1);
		}
		else if (lastDigit == 9) {
			findAllSteppingNumHelper(s, e, l - 1, n * 10 + 8);
		}
		else {
			findAllSteppingNumHelper(s, e, l - 1, n * 10 + lastDigit - 1);
			findAllSteppingNumHelper(s, e, l - 1, n * 10 + lastDigit + 1);
		}
	}
	
	public static void main(String[] args) {
		SteppingNum_7 sn = new SteppingNum_7();
		sn.findAllSteppingNum(0, 1000);
	}
}
