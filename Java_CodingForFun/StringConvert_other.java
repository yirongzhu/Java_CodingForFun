package codingForFun;

// Convert string into new string e.g. "abcD"->"cdeF" and "plxY" -> "rnzA"
public class StringConvert_other {

	public String convertString(String s) {
		int shift = 2;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c = (char) ('a' + (c - 'a' + shift) % 26);
			}
			if (c >= 'A' && c <= 'Z') {
				c = (char) ('A' + (c - 'A' + shift) % 26);
			}
			result.append(c);
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		StringConvert_other sco = new StringConvert_other();
		System.out.println(sco.convertString("abcD"));
		System.out.println(sco.convertString("plxY"));
	}
}
