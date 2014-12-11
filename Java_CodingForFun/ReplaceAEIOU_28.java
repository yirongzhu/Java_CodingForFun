package codingForFun;

// Replace a,e,i,o,u with A,E,I,O,U. At most four eligible letters from the rear of the string are replaced. 
// The first three eligible letters in the string are always exempted from replacement.
public class ReplaceAEIOU_28 {

	public String replaceAEIOU(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		char[] c = s.toCharArray();
		String vowel = "aeiou";
		int i = 0;
		int count = 0;
		while (i < c.length && count < 3) {
			if (vowel.indexOf(c[i]) != -1) {
				count++;
			}
			i++;
		}
		count = 0;
		for (int j = i; j < c.length && count < 4; j++) {
			if (vowel.indexOf(c[j]) != -1) {
				c[j] -= 32;
				count++;
			}
		}
		return new String(c);
	}
	
	public static void main(String[] args) {
		ReplaceAEIOU_28 ra = new ReplaceAEIOU_28();
		String s = "iajeikohuabeji";
		System.out.println(s);
		System.out.println(ra.replaceAEIOU(s));
	}
}
