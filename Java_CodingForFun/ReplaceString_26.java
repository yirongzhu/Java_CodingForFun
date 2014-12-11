package codingForFun;

// From a given string, replace all instances of 'a' with 'one' and 'A' with 'ONE'.
// Example Input: " A boy is playing in a garden"
// Example Output: " ONE boy is playing in one garden"
// -- Not that 'A' and 'a' are to be replaced only when they are single characters, not as part of another word.
public class ReplaceString_26 {

	public String replaceString(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String one = "one";
		String ONE = "ONE";
		String[] buffer = s.split(" ", -1);
		StringBuffer result = new StringBuffer();
		for (String e : buffer) {
			if (e.equals("a")) {
				result.append(one);
			}
			else if (e.equals("A")) {
				result.append(ONE);
			}
			else {
				result.append(e);
			}
			result.append(" ");
		}
		String resultString = result.toString();
		if (!resultString.equals("")) {
			return resultString.substring(0, resultString.length() - 1);
		}
		else {
			return resultString;
		}
	}
	
	public static void main(String[] args) {
		ReplaceString_26 rs = new ReplaceString_26();
		String s = "       ";
		System.out.println(rs.replaceString(s));
	}
}
