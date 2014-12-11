package codingForFun;

// Print the sequences from the input given by the user separated by semicolon 
// e.g.: 4678912356012356 
// output: 4;6789;123;56;0123;56;
public class SeparateNumber_21 {

	public String getSequence(String num) {
		if (num == null || num.length() == 0) {
			return num;
		}
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while (i < num.length()) {
			if (i < num.length() - 1 && num.charAt(i) == num.charAt(i + 1) - 1) {
				sb.append(num.charAt(i));
			}
			else {
				sb.append(num.charAt(i));
				sb.append(';');
			}
			i++;
		}
		return sb.toString();
	}
	
	// Sequence length should be longer than two
	public String getSequence1(String num) {
		if (num == null || num.length() == 0) {
			return num;
		}
		StringBuffer sb = new StringBuffer();
		boolean test = false;
		for (int i = 1; i < num.length(); i++) {
			if (num.charAt(i - 1) + 1 == num.charAt(i)) {
				sb.append(num.charAt(i - 1));
				test = true;
			}
			else {
				if (test) {
					sb.append(num.charAt(i - 1));
					sb.append(';');
				}
				test = false;
			}
		}
		if (num.charAt(num.length() - 2) + 1 == num.charAt(num.length() - 1)) {
			sb.append(num.charAt(num.length() - 1));
			sb.append(';');
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SeparateNumber_21 sn = new SeparateNumber_21();
		System.out.println(sn.getSequence1("4678931235601235789"));
	}
}
