package codingForFun;

// reverse the words of a string.  i.e This is great -> great is This
public class ReverseWordsInAString_other {

	// Reversed string should not contain leading or trailing spaces. Reduce them to a single space in the reversed string.
	public String reverseWords(String s) {
		s = s.trim();
		StringBuffer result = new StringBuffer();
		String[] buffer = s.split(" ");
		for (int i = buffer.length - 1; i >= 0; i--) {
			if (!buffer[i].equals("")) {
				result.append(buffer[i]);
				result.append(" ");
			}
		}
		String r = result.toString();
		if (!r.equals("")) {
			return r.substring(0, r.length() - 1);
		}
		else {
			return r;
		}
	}
}
