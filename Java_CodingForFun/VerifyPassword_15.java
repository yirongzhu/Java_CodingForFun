package codingForFun;

import java.util.HashMap;

// Verify Password
// Verify if the given password is valid/invalid
// 1. must be 5-12 characters long 
// 2. must contain at least one number and one lower case character 
// 3. a sequence must not be followed by the same sequence (like 123123qs is invalid, 123qs123 is valid)
public class VerifyPassword_15 {

	public boolean isValidPassword(String string) {
		if (string == null) {
			return false;
		}
		return islenValid(string) && ischarValid(string) && isseqValid(string);
	}
	
	private boolean islenValid(String string) {
		return (string.length() >= 5 && string.length() <= 12);
	}

	private boolean ischarValid(String string) {
		char[] crs = string.toCharArray();
		boolean num_flag = false;
		boolean char_flag = false;
		for (int i = 0; i < string.length(); i++) {
			if (crs[i] >= '0' && crs[i] <= '9') {
				num_flag = true;
			}
			if (crs[i] >= 'a' && crs[i] <= 'z') {
				char_flag = true;
			}
		}
		return num_flag && char_flag;
	}

	private static boolean isseqValid(String str) {
		/**
		 * HashMap store the substring as a key and its ending index as a value.
		 * Before putting value into the hashmap, it checks if the substring
		 * already exists. If yes, retrieve the value and compare value + 1 with
		 * the starting index of the new substring. If they are equal, it means
		 * there are consecutive substrings.
		 */
		int len = str.length();

		for (int i = 1; i < len; i++) {
			HashMap<String, Integer> stringindexMap = new HashMap<String, Integer>();
			for (int j = 0; j + i <= len; j++) {
				String sub = str.substring(j, j + i);
				if (stringindexMap.get(sub) == null) {
					stringindexMap.put(sub, j + i - 1);
				} 
				else {
					int prevlastIndex = stringindexMap.get(sub);
					if (prevlastIndex == j - 1)
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		VerifyPassword_15 vp = new VerifyPassword_15();
		String str = "";
		System.out.println(vp.isValidPassword(str));
	}
}
