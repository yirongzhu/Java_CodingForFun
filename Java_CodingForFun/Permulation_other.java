package codingForFun;

public class Permulation_other {

	private static final String digits = "0123456789";
	
	public void printPermulation(int length) {
		String result = "";
		printPermulationHelper(length, result);
	}
	
	public void printPermulationHelper(int length, String result) {
		if (length == 0) {
			System.out.println(result);
			return;
		}
		for (int i = 0; i < digits.length(); i++) {
			if (result.indexOf(digits.charAt(i)) != -1) {
				continue;
			}
			printPermulationHelper(length - 1, result + digits.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		Permulation_other po = new Permulation_other();
		po.printPermulation(4);
	}
}
