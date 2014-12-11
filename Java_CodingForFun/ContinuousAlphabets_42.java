package codingForFun;

// Print continuous alphabets from a sequence of arbitrary alphabets
// For example: Input: abcdefljdflsjflmnopflsjflasjftuvwxyz  Output: abcdef; mnop; tuvwxyz
// Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz  Output: abcdef; mnop; tuvwxyz
public class ContinuousAlphabets_42 {

	public String getContinuousAlphabets(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		s = s.toLowerCase();
		StringBuffer sb = new StringBuffer();
		boolean test = false;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) + 1 == s.charAt(i)) {
				sb.append(s.charAt(i - 1));
				test = true;
			}
			else {
				if (test) {
					sb.append(s.charAt(i - 1));
					sb.append("; ");
				}
				test = false;
			}
		}
		if (s.charAt(s.length() - 2) + 1 == s.charAt(s.length() - 1)) {
			sb.append(s.charAt(s.length() - 1));
		}
		else {
			sb.delete(sb.length() - 2, sb.length());
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ContinuousAlphabets_42 ca = new ContinuousAlphabets_42();
		System.out.println(ca.getContinuousAlphabets("abcdefljdflsjflmnopflsjflasjftuvwxyz"));
		System.out.println(ca.getContinuousAlphabets("AbcDefljdflsjflmnopflsjflasjftuvWxYz"));
		System.out.println(ca.getContinuousAlphabets("abcdz"));
		System.out.println(ca.getContinuousAlphabets("abcdYz"));
		System.out.println(ca.getContinuousAlphabets("abcd"));
	}
}
