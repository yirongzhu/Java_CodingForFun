package codingForFun;

// Let the user enter a decimal number. The range allowed is 0.0001 to 0.9999. Only four decimal places are allowed. The output should be an irreducible fraction.
// E.g.: If the user enters 0.35,the irreducible fraction will be 7/20.
public class DecimalNumber_41 {

	public String getIrreducibleNumber(double num) {
		int a = 10000;
		int b = (int) (num * a);
		int d = getMaximumDivisor(a, b);
		String s = ((b / d) + " / " + (a / d));
		return s;
	}
	
	public int getMaximumDivisor(int a, int b) {
		int r;
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public static void main(String[] args) {
		DecimalNumber_41 dn = new DecimalNumber_41();
		System.out.println(dn.getIrreducibleNumber(0.3125));
	}
}
