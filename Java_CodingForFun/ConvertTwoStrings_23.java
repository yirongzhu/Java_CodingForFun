package codingForFun;

// You can swap only two consecutive elements. You have to show all steps to convert a string into another string (both strings will be anagrams of each other).
// E.g. GUM to MUG      GUM GMU MGU MUG
public class ConvertTwoStrings_23 {

	public void convertTwoStrings(String s1, String s2) {
		if (s1 == null || s2 == null || s1 == "" || s2 == "" || s1.length() != s2.length()) {
			return;
		}
		int len = s1.length();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char temp;
		for (int i = 0; i < len; i++) {
			int j = i;
			for ( ; c1[j] != c2[i]; j++);
			for ( ; j > i; j--) {
				System.out.println(new String(c1));
				temp = c1[j];
				c1[j] = c1[j - 1];
				c1[j - 1] = temp;
			}
		}
		System.out.println(new String(c1));
	}
	
	public static void main(String[] args) {
		ConvertTwoStrings_23 co = new ConvertTwoStrings_23();
		co.convertTwoStrings("ACADBB123", "DC1BA32BA");
	}
}
