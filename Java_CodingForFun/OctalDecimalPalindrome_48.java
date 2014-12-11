package codingForFun;

// The decimal and octal values of some number share both palindromes sometimes. Find such numbers within a given range.
public class OctalDecimalPalindrome_48 {

	public boolean isPalindrome(String result) {
		int len = result.length();
		for (int i = 0; i < len / 2; i++) {
			if (result.charAt(i) != result.charAt(len - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	public String decimalToOctal(int decimal) {
		int result = 0;
		int digit = 1;
		while (decimal != 0) {
			result += decimal % 8 * digit;
			decimal /= 8;
			digit *= 10;
		}
		return String.valueOf(result);
	}
	
	public void getDOPalindrom(int limit) {
		for (int i = 0; i < limit; i++) {
			String decimal = String.valueOf(i);
			if (isPalindrome(decimal)) {
				String octal = decimalToOctal(i);
				if (isPalindrome(octal)) {
					System.out.println(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		OctalDecimalPalindrome_48 odp = new OctalDecimalPalindrome_48();
		odp.getDOPalindrom(1000);
	}
}
