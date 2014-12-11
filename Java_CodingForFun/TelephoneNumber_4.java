package codingForFun;

// Print all valid phone numbers of length n subject to following constraints: 
// 1.If a number contains a 4, it should start with 4 
// 2.No two consecutive digits can be same 
// 3.Three digits (e.g. 7,2,9) will be entirely disallowed, take as input
public class TelephoneNumber_4 {

	private static String digits = "0134568";
	
	public void printPhoneNumber(int length) {
		String result = "";
		printPhoneNumberHelper(length, result);
	}
	
	public void printPhoneNumberHelper(int length, String result) {
		if (length == 0) {
			System.out.println(result);
			return;
		}
		for (int i = 0; i < digits.length(); i++) {
			if (result.length() > 0 && result.charAt(result.length() - 1) == digits.charAt(i)) {
				continue;
			}
			if (result.length() > 0 && result.charAt(0) != '4' && digits.charAt(i) == '4') {
				continue;
			}
			printPhoneNumberHelper(length - 1, result + digits.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		TelephoneNumber_4 tn = new TelephoneNumber_4();
		tn.printPhoneNumber(3);
	}
}
