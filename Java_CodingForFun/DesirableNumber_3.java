package codingForFun;

// A number is called 'desirable' if all the digits are strictly ascending eg: 159 as 1<5<9. You know that your rival has a strictly numeric password that is 'desirable'.
// Your close ally has given you the number of digits (N) in your rival's password.
// WAP th\hjtat takes in'N' as input and prints out all possible 'desirable' numbers that can be formed with N digits.
public class DesirableNumber_3 {

	private static final String digits = "123456789";
	
	public void printDesirableNumber(int length) {
		String result = "";
		int current = 0;
		printDesirableNumberHelper(length, current, result);
	}
	
	public void printDesirableNumberHelper(int length, int current, String result) {
		if (length == 0) {
			System.out.println(result);
			return;
		}
		for (int i = current; i < digits.length(); i++) {
			int index = digits.indexOf(digits.charAt(i)) + 1;
			printDesirableNumberHelper(length - 1, index, result + digits.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		DesirableNumber_3 dn = new DesirableNumber_3();
		dn.printDesirableNumber(4);
	}
}
